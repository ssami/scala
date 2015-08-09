package week1

object TailRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(264); 
  
  // note: expression:
  // [V1/X1, .... Vn/Xn]B means that
  // the expression B in which all occurrences of
  // Xn have been replaced by Vn.
  
  // [V1/X1, .... Vn/Xn] is a substitution
  
 
  def gcd(a: Int, b:Int): Int =
  	if (b == 0) a else gcd(b, a%b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(17); val res$0 = 
  	
  gcd(4, 16);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  
  gcd(21, 29);System.out.println("""res1: Int = """ + $show(res$1));$skip(17); val res$2 = 
  
  gcd(15, 25);System.out.println("""res2: Int = """ + $show(res$2));$skip(75); 
  
  def factorial(x: Int): Int =
  	if (x == 1) 1 else x * factorial(x-1);System.out.println("""factorial: (x: Int)Int""");$skip(21); val res$3 = 
  
  
  factorial(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(925); 
  
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
  	
  };System.out.println("""factorialTail: (x: Int)Int""");$skip(23); val res$4 = 
  	
  factorialTail(4);System.out.println("""res4: Int = """ + $show(res$4));$skip(22); val res$5 = 
  
  factorialTail(5);System.out.println("""res5: Int = """ + $show(res$5))}
  	
}
