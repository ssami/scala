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
  
  
  def generateTestPoints(num: Int): Map[Point, Double] = { 
    val pointLineA = generatePoint
    val pointLineB = generatePoint
    val testData = scala.collection.mutable.Map[Point, Double]()
    
    var i = 0 
    for (i <- 1 to num){
      val p = generatePoint
      testData(p) = pointOnSide(pointLineA, pointLineB, p)
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
    
    val keys = points.keys.toList
    for (ind <- 0 to keys.size-1) {
      val hy = h(weight, keys(ind))
      val y = points.get(keys(ind)).get
      if (hy != y) misclass += keys(ind)
    } 
    
    //points.keys.foreach { (i: Point) => if ( h(weight, i) != points.get(i)) misclass += i}

    misclass.toList
    
  }
  
  def experiment(numPoints:Int):Unit = {
    
    val testPoints = generateTestPoints(numPoints)
//    val weight = scala.collection.mutable.ArrayBuffer[Double](0.0, 0.0, 0.0)  // store initial weight vector: [w1, w2, bias]
    var weight = List[Double](0.0, 0.0, 0.0)
    
    while (true) {
      val misclassified = identifyMisclassified(testPoints, weight.toList, h)
      if (misclassified.isEmpty) return 
      val ind = scala.util.Random.nextInt(misclassified.length)  // pick a random point
      val mp = misclassified(ind)  // the random misclassified point
      val yt = testPoints.get(mp)  // its target y value
      
      weight = newH(weight, mp, yt.get)
      println("Weights: " + weight.toString())
      
    }  
    
  }
  
  experiment(10)
  
}