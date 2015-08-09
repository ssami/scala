package week1

object Tester {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  1 + 2                                           //> res0: Int(3) = 3
  def abs(x:Double): Double = if (x>0) x else -x  //> abs: (x: Double)Double
  
  def sqrt(x: Double) = {
  	// define functions inside other functions
  	// this is a block
  	
  	// everything inside a block is visible only from
  	// inside the block
  	// everything outside the block is visible
  	// inside the block, except if
  	// the variable name inside the block collides
  	// with the variable name outside
	  def sqrtIter(guess:Double, x:Double): Double =
	  	if (isGoodEnough(guess)) guess
	  	else sqrtIter(improve(guess), x)
	  	
	  def isGoodEnough(guess:Double): Boolean =
	  	abs(guess * guess - x)/x < 0.001
	  	
	  	
	  def improve(guess:Double): Double =
	  	((x/guess) + (guess)) / 2
	  	
	  
	   sqrtIter(1.0, x)
   }                                              //> sqrt: (x: Double)Double
  
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(1e-6)                                      //> res2: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res3: Double = 1.0000788456669446E30
  
  math.log(2)                                     //> res4: Double = 0.6931471805599453
  math.log(1e6)                                   //> res5: Double = 13.815510557964274
  
  val x = 3 * 3                                   //> x  : Int = 9
  x * x                                           //> res6: Int = 81
  
  def double(x: Int): Int = x*2                   //> double: (x: Int)Int
  
  double(4)                                       //> res7: Int = 8
  
  def areaRectangle(len: Double, ht: Double)
  	= len * ht                                //> areaRectangle: (len: Double, ht: Double)Double
  	
  areaRectangle(3, 6)                             //> res8: Double = 18.0
  
  def areaSquare(radius: Double)
  	= math.Pi * radius * radius               //> areaSquare: (radius: Double)Double
                                                  
  areaSquare(2)                                   //> res9: Double = 12.566370614359172
  
  
  def hoeffdinger(epsilon: Double, M: Integer, N: Integer) = {
  	// m is the number of experiments
  	// n is the number of data input points
  	val exp = -2 * math.pow(epsilon, 2) * N
  	2 * M * math.exp(exp)
  }                                               //> hoeffdinger: (epsilon: Double, M: Integer, N: Integer)Double
  
  hoeffdinger(0.01, 5, 100000)                    //> res10: Double = 2.061153622438558E-8
  
}