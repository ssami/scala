package week1

object TailRecursion {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // note: expression:
  // [V1/X1, .... Vn/Xn]B means that
  // the expression B in which all occurrences of
  // Xn have been replaced by Vn.
  
  // [V1/X1, .... Vn/Xn] is a substitution
  
 
  def gcd(a: Int, b:Int): Int =
  	if (b == 0) a else gcd(b, a%b)            //> gcd: (a: Int, b: Int)Int
  	
  gcd(4, 16)                                      //> res0: Int = 4
  
  gcd(21, 29)                                     //> res1: Int = 1
  
  gcd(15, 25)                                     //> res2: Int = 5
  
  def factorial(x: Int): Int =
  	if (x == 1) 1 else x * factorial(x-1)     //> factorial: (x: Int)Int
  
  
  factorial(5)                                    //> res3: Int = 120
  
  // if the recursive function calls itself as its last action
  // it's called Tail recursion.
  // this function can re-use the stack frame.
  
  // tail recursive functions are just iterative processes
  // and behave like loops
  
  // the factorial sequence "looked" like a simple loop,
  // but since we call x* factorial, the function
  // doesn't call itself as the absolute last thing
  // in fact the sequence expands and we have to keep all values on the stack
  // as intermediate steps before finishing
  
  // @tailrec annotation, but this worksheet doesn't support...?
  // but if function was not tail recursive, annotation would throw an error
  	
  
  // Quiz: design a tail-recursive implementation of factorial
  
  
  def factorialTail(x: Int): Int = {
  	def fact(a: Int, b: Int): Int = {
  		if (b == 1) a else  fact(a * b, b-1)
  	}
  	fact(x, x-1)
  	// actually the answer was fact(1, x)
  	
  }                                               //> factorialTail: (x: Int)Int
  	
  factorialTail(4)                                //> res4: Int = 24
  
  factorialTail(5)                                //> res5: Int = 120
  	
}