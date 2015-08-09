package week1

object Tester {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(8); val res$0 = 
  1 + 2;System.out.println("""res0: Int(3) = """ + $show(res$0));$skip(49); 
  def abs(x:Double): Double = if (x>0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(667); 
  
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
   };System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$1 = 
  
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
  sqrt(1e-6);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); val res$3 = 
  sqrt(1e60);System.out.println("""res3: Double = """ + $show(res$3));$skip(17); val res$4 = 
  
  math.log(2);System.out.println("""res4: Double = """ + $show(res$4));$skip(16); val res$5 = 
  math.log(1e6);System.out.println("""res5: Double = """ + $show(res$5));$skip(19); 
  
  val x = 3 * 3;System.out.println("""x  : Int = """ + $show(x ));$skip(8); val res$6 = 
  x * x;System.out.println("""res6: Int = """ + $show(res$6));$skip(35); 
  
  def double(x: Int): Int = x*2;System.out.println("""double: (x: Int)Int""");$skip(15); val res$7 = 
  
  double(4);System.out.println("""res7: Int = """ + $show(res$7));$skip(62); 
  
  def areaRectangle(len: Double, ht: Double)
  	= len * ht;System.out.println("""areaRectangle: (len: Double, ht: Double)Double""");$skip(26); val res$8 = 
  	
  areaRectangle(3, 6);System.out.println("""res8: Double = """ + $show(res$8));$skip(67); 
  
  def areaSquare(radius: Double)
  	= math.Pi * radius * radius;System.out.println("""areaSquare: (radius: Double)Double""");$skip(67); val res$9 = 
                                                  
  areaSquare(2);System.out.println("""res9: Double = """ + $show(res$9));$skip(221); 
  
  
  def hoeffdinger(epsilon: Double, M: Integer, N: Integer) = {
  	// m is the number of experiments
  	// n is the number of data input points
  	val exp = -2 * math.pow(epsilon, 2) * N
  	2 * M * math.exp(exp)
  };System.out.println("""hoeffdinger: (epsilon: Double, M: Integer, N: Integer)Double""");$skip(34); val res$10 = 
  
  hoeffdinger(0.01, 5, 100000);System.out.println("""res10: Double = """ + $show(res$10))}
  
}
