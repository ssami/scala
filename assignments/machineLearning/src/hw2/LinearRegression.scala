package hw2

/**
 * @author ssami
 */
class LinearRegression {
  
  
  class Point(a:Double, b:Double) {
    val x:Double = a
    val y:Double = b
  }
  
  def crossProduct(a:Point, b:Point, c:Point):Double = ((b.x - a.x)*(c.y - a.y)) - ((b.y - a.y)*(c.x-a.x))
  
  def generatePoint : Point = {
    val random = scala.util.Random
    
    val x = (random.nextFloat*2) - 1
    val y = (random.nextFloat*2) - 1
    
    return new Point(x, y)
  } 
  
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
  
  def test() {
    import breeze.linalg._
    
    val m = DenseMatrix.zeros[Int](5,5)
    val tm = m.t
    
  }
  
    
 
}
