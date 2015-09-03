package hw2

/**
 * @author sumitasami
 */
object Hoeffding extends App {
  
  val EACH_N = 10 // num of times each coin is flipped
  val NUM_COINS = 1000  // num of coins flipped in the experiment
  val EXPERIMENTS = 100000  // num of experimental runs
  
  // heads = true, tails = false 
  
  def flipCoin(): Boolean = scala.util.Random.nextBoolean()
  
  def freqHeadsSingleCoin(): Double = {
    var i = 0
    var heads = 0 
    for (i <- 1 to EACH_N){
      if (flipCoin()) heads += 1
    }
    return (heads.toFloat/EACH_N.toFloat)
  }
  
  def freqsAllCoins(): List[Double] = {
    val allCoins = scala.collection.mutable.MutableList[Double]()
    var i = 0 
    for (i <- 1 to NUM_COINS){
      allCoins += freqHeadsSingleCoin()
    }
    allCoins.toList
  }
  
  def runExp():List[Double] = {
    // c1 = first coin flipped
    // crand = random coin 
    // cmin = min freq of heads
    val allCoins = freqsAllCoins()
    var three = scala.collection.mutable.MutableList[Double]()  // holds the three kinds of coins
    
    three += allCoins(0) //first coin 
    three += allCoins(scala.util.Random.nextInt(allCoins.size))
    val allCoinsSorted = allCoins.sorted
    three += allCoinsSorted(0) // min freq
    
    three.toList
    
    //TODO: if min and random are the same, pick the earlier one 
  }
  
  def experiment() = { 
    var run = 0
    var totalV1 = 0.0
    var totalVrand = 0.0 
    var totalVmin = 0.0 
    for (run <- 1 to EXPERIMENTS) {
      println("Running experiment: " + run)
      val res = runExp()
      totalV1 += res(0)
      totalVrand += res(1)
      totalVmin += res(2)
      println(res)
    }
    
    val v1 = totalV1/EXPERIMENTS.toFloat
    val vrand = totalVrand/EXPERIMENTS.toFloat
    val vmin = totalVmin/EXPERIMENTS.toFloat
    
    println("V1: " + f"$v1%1.3f" + ", VRandom: " + f"$vrand%1.3f" + ", Vmin: " + f"$vmin%1.3f")
  }
  
  experiment()   
  
}