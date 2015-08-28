package recfun
import common._

object Main {
  def main(args: Array[String]) {
    /**Ex1**/
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(pascal(col, row) + " ")
//      println()
//    }
    
    /**Ex 2**/
    println("Balancing parentheses")
    val pos1 = "(if (zero? x) max (/ 1 x))"
    val pos2 = "I told him (that it’s not (yet) done). (But he wasn’t listening)"
    val neg1 = ":-)"
    val neg2 = "())("
    val neg3 = ")))"
    println("Is balanced? " + pos1 + ": " + balance(pos1.iterator.toList))
    println("Is balanced? " + pos2 + ": " +  balance(pos2.iterator.toList))
    println("Is balanced? "  + neg1 + ": " + balance(neg1.iterator.toList))
    println("Is balanced? "  + neg2 + ": " +  balance(neg2.iterator.toList))
    println("Is balanced? "  + neg3 + ": " + balance(neg3.iterator.toList))
    
    /**Ex 3**/
//    println("Count the permutations of coins for money=4, coins=[1, 2, 3]")
//    val coins = List(1, 2, 3)
//    val count = countChange(4, coins)
//    println("total ways:" + count)
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    // return if first row (which is just 1), 
    // column is 0 (which is always 1) 
    // or c > r, which means we are at the end of the list
    if (c == 0 || r == 0 || c >= r) 1 
    else pascal(c-1, r-1) + pascal(c, r-1) 
    
  }

  /**
   * Exercise 2
   * Write a recursive function which verifies the balancing of parentheses in a string, 
   * which we represent as a List[Char] not a String. For example, the function should return true for the following strings:
      
      (if (zero? x) max (/ 1 x))
      I told him (that it’s not (yet) done). (But he wasn’t listening)
      
      The function should return false for the following strings:
      
      :-)
      ())(
   * 
   */
  def balance(chars: List[Char]): Boolean = {
    
    // if true for opening and list char contains closing, return true 
    // else mark 
    val CLOSING = ')'
    val OPENING = '('
    
    def checkBalance(count:Int, seq:List[Char]): Boolean = {
      if (count < 0) return false
      if (seq.isEmpty) (count == 0)
      else { 
        if (seq.head == CLOSING) checkBalance(count-1, seq.tail)
        else if (seq.head == OPENING) checkBalance(count+1, seq.tail)
        else checkBalance(count, seq.tail)
      }
    }
    
    checkBalance(0, chars)
  }

  /**
   * Exercise 3
   * Write a recursive function that counts how many different ways you can make change for an amount, 
   * given a list of coin denominations. 
   * For example, there are 3 ways to give change for 4 if you have coins with 
   * denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.
   * 
   * Hint: Think of the degenerate cases. How many ways can you give change 
   * for 0 CHF? How many ways can you give change for >0 CHF, if you have no coins?
   * 
   * Adapted, unfortunately, from: 
   * 
   * http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    def countInner(money:Int, coins:List[Int], count:Int): Int = {
        if (coins.isEmpty || money < 0)  0   // invalid breakdown
        else{
          if (money == 0)  return count + 1  // valid breakdown
          return countInner(money, coins.tail, count) + countInner(money-coins.head, coins, count)
        }
    }    
    countInner(money, coins, 0)
  }
}
