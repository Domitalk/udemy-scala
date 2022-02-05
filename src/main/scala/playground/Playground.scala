package playground

object Playground extends App {


  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      // if 3 <= 1 it's a prime?
      // if 2 <= 1 it's a prime?
      println(t)
      if (t <= 1) true
      // otherwise, 6 % 3 = 0, so false && isPrimeUntil(2)
      // otherwise, 5 % 2 = 1, so not 0 true && recurse isPrimeUntil(1) which returns true
      else n % t != 0 && isPrimeUntil(t -1)
    }
    // 3 goes in
    // for some reason 5/2 = 2 ?
    isPrimeUntil(n / 2)
  }

//  isPrime(6)
  isPrime(5)

}
