object Perceptron {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class Point(a:Double, b:Double) {
  	val x:Double = a
  	val y:Double = b
  }
  
  def isNegative():Int = {
  	val random = scala.util.Random
  	if (random.nextInt % 2 == 0) -1 else 1
  
  }                                               //> isNegative: ()Int
  
  def generatePoint : Point = {
  	val random = scala.util.Random
  	
  	val x = random.nextFloat * isNegative
  	val y = random.nextFloat * isNegative
  	
  	return new Point(x, y)
  		
  }                                               //> generatePoint: => Perceptron.Point
  
  val randX = generatePoint                       //> randX  : Perceptron.Point = Perceptron$$anonfun$main$1$Point$1@36d64342
  
  def calcSlope(a:Point, b:Point) =
  		(b.y - a.y) / (b.x - a.x)         //> calcSlope: (a: Perceptron.Point, b: Perceptron.Point)Double
  
  def generateTestSet = {
  	// get slope and intercept
  	val a = generatePoint
  	val b = generatePoint
  	
  	val slope = calcSlope(a, b)
  	val intercept = generatePoint
  	
  	// generate test set around this function
  }                                               //> generateTestSet: => Unit
  
  
  // how to get weights such that f(x) = y gives you a signed result?
  // points A and B create the slope
  // point C is against the slope formed by A and B
  def pointOnSide(a:Point, b:Point, c:Point):Double = {
  	// returns -1 or 1 given the side
  	// point C is tested against point A and B
  	val point = ((b.x - a.x)*(c.y - a.y)) - ((b.y - a.y)*(c.x-a.x))
	  if (point < 0) -1 else 1
	}                                         //> pointOnSide: (a: Perceptron.Point, b: Perceptron.Point, c: Perceptron.Point
                                                  //| )Double
  
  val p = new Point(0.123, 0.456)                 //> p  : Perceptron.Point = Perceptron$$anonfun$main$1$Point$1@39ba5a14
  val n = new Point(0.34, 0.78)                   //> n  : Perceptron.Point = Perceptron$$anonfun$main$1$Point$1@511baa65
  val c = new Point(0.122, -0.34)                 //> c  : Perceptron.Point = Perceptron$$anonfun$main$1$Point$1@340f438e
  
  pointOnSide(p, n, c)                            //> res0: Double = -1.0
  
	def testFunction() = {
		var points = List[Point]()
		var ylist = List[Double]()
		val slopeX = generatePoint
		val slopeY = generatePoint
		
		var numPoints = 100
		
		var a = 0
		for (a <- 1 to numPoints) {
			val newpt = generatePoint
			points = newpt :: points
			ylist = pointOnSide(slopeX, slopeY, newpt) :: ylist
		}
		
		// pick random two points and generate a slope
		// identify a point that is misplaced

		var startingSlopeA = new Point(0.0, 0.0)
		var startingSlopeB = new Point(0.0, 0.0)
		var pt = null
		
		// need to start again from beginning
		var index = 0
		for ( index <- 0 to points.size-1) {
				for ( (pt, i)  <- points.view.zipWithIndex ) {
					//if calcuated side does not match actual side, generate new
					// slope points
					val y = pointOnSide(startingSlopeA, startingSlopeB, pt)
					if (y != ylist(i)) {
						startingSlopeA = generateNewWeightedPoints(y, startingSlopeA, pt)
						startingSlopeB = generateNewWeightedPoints(y, startingSlopeB, pt)
						
					}
				
				}
		}

		
		// returns the new value of one of the slope points
		// y is the actual output (as opposed to the expected y)
		// coord is the x or y coordinate
		// wOld is the old point of the slope
		def generateNewWeightedPoints(y:Double, wOld:Point, coord:Point): Point = {
			val wx = wOld.x + (y * coord.x)
			val wy = wOld.y + (y * coord.y)
			return new Point(wx, wy)
		
		}
		
		// now it's time to do iterations
		// a and b are different iterations of the slope + weights
		def runIteration(points:List[Point], ylist:List[Double], a:Point, b:Point) {
				
		
		}
		
	
	}                                         //> testFunction: ()Unit
	
	
 
}