package hw2

/**
 * @author ssami
 */
object Perceptron extends App {
  
  class Point(a:Double, b:Double) {
    val x:Double = a
    val y:Double = b
  }
  
  def crossProduct(a:Point, b:Point, c:Point):Double = ((b.x - a.x)*(c.y - a.y)) - ((b.y - a.y)*(c.x-a.x))
  
  /**
   * points A and B create the slope
   * point C is against the slope formed by A and B
   * Returns 1 or -1 given the side
   * 
   */
  def pointOnSide(a:Point, b:Point, c:Point):Int = {
    val point = crossProduct(a, b, c)
    if (point < 0) -1 else 1
    
  }  
  
  def generatePoint : Point = {
    val random = scala.util.Random
    
    val x = (random.nextFloat*2) - 1
    val y = (random.nextFloat*2) - 1
    
    return new Point(x, y)
  }  
  
  /**
   * Generates a set of test points given the points on the slope
   */
  def generatePoints(num: Int, pointA: Point, pointB: Point): Map[Point, Double] = { 
    val testData = scala.collection.mutable.Map[Point, Double]()
    
    var i = 0 
    for (i <- 1 to num){
      val p = generatePoint
      testData(p) = pointOnSide(pointA, pointB, p)
    }
    
    return testData.toMap
    
  }
  
  
  def h(weight:List[Double], p:Point ): Double = if ( (weight(0)*p.x + weight(1)*p.y + weight(2)) > 0) 1 else -1
  
  
  
  /*
   * 
   * weight(new) = weight(old) + x*y 
   */
  def newH(weight:List[Double], p:Point, y:Double): List[Double] = {
    val newWt = scala.collection.mutable.ArrayBuffer[Double](0.0, 0.0, 0.0)
    newWt(0) = weight(0) + p.x*y
    newWt(1) = weight(1) + p.y*y
    newWt(2) = weight(2) + 1*y
    
    return newWt.toList
  }
  
  def identifyMisclassified(points:Map[Point, Double], weight:List[Double], h:(List[Double], Point) => Double ): List[Point] = {
    var ind = 0
    val misclass = scala.collection.mutable.ArrayBuffer[Point]()
    
    points.keys.foreach { (i: Point) => if ( h(weight, i) != points.get(i).get) misclass += i}
    misclass.toList
  }
  
  def test(h:List[Double], p:Point => Double) = {
    
  }
  
  /**
   * Returns a list of doubles: 
   * a) the number of iterations it took to get the right answer
   * b) the number of times h() was right about new test points
   */
  def run(numPoints:Int): List[Double] = {
    
    val pointA = generatePoint
    val pointB = generatePoint
    val trainPoints = generatePoints(numPoints, pointA, pointB)
    var weight = List[Double](0.0, 0.0, 0.0)
    var iterations = 0
    
    import scala.util.control.Breaks._
    breakable {
      while (true) {
        val misclassified = identifyMisclassified(trainPoints, weight.toList, h)
        if (misclassified.isEmpty) break
        val ind = scala.util.Random.nextInt(misclassified.length)  // pick a random point
        val mp = misclassified(ind)  // the random misclassified point
        val yt = trainPoints.get(mp)  // its target y value
        
        weight = newH(weight, mp, yt.get)
        iterations += 1
        println("   Iterations:"+iterations)
        
      }  
    }
    
    // generate testing points which will test h()
    val testPoints = generatePoints(numPoints, pointA, pointB)
    var wrong = 0  // times that h() is right about y
    
    testPoints.keys.foreach { point => if (h(weight, point) != testPoints.get(point).get) wrong += 1}  //increment every time we predict the right value
    val predictRight = wrong.toDouble/numPoints.toDouble*100.0
    
    return List[Double](iterations.toDouble, predictRight)
    
  }
  
  def experiment(numExperiments: Int, numDataPoints:Int) = {
    // run experiments for 1000 times
    var i = 0 
    var avgIterations = 0.0 
    var avgPercentRight = 0.0
    for (i <- 1 to numExperiments) {
      println("Running experiment num: " + i)
      val stats = run(numDataPoints)
      avgIterations += stats(0)
      avgPercentRight += stats(1)
    }
    
    println("Average iterations: " + avgIterations/numExperiments.toDouble)
    println("Average percent wrong: " + avgPercentRight/numExperiments.toDouble)
    
  }
  
  experiment(10, 10)
  
  
}