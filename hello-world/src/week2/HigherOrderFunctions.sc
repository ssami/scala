package week2

object HigherOrderFunctions {
  println("A function that takes other functions as arguments")
                                                  //> A function that takes other functions as arguments
                                                  
  // what's new here is a parameter called
  // A => B, where the function takes A type and returns B type
  // e.g. def sum(f: Int => Int, a:Int, b:Int)
  
  // we don't need to define the functions separately - we can write anonymous functions
  
  // anonymous function for cube:

  // (x:Int) => x*x*x
  
  def sum(f:Int => Int, a:Int, b:Int): Int = {
  	def loop(a:Int, acc:Int):Int = {
  		if (a == b) 0
  		else loop (a+1, f(a)+acc)
  	
  	}
  	loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  
 
  
  

}