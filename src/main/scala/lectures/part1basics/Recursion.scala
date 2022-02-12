package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need a factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }

  def anotherFactorial(n: Int): Int = {
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }
    factorialHelper(n, 1)
  }

  println(factorial(10))
  // anotherFactorial(10) = factorialHelper(10, 1)
  //
  // ... factorialHelper(9, 10 * 1)
  // ... factorialHelper(8, 9 * 10 * 1)
  // ... factorialHelper(7, 8 * 9 * 10 * 1)
  // ...
  // ... factorialHelper(2, 3 * 4 ... * 10 * 1)
  // ... factorialHelper(1, 1 * 2 * ... * 10)
  // ... returns accumulator which is
  // ... 1 * 2 * ... * 10



  // let's say, we do a factorial(5000), it'll cause an error because the jvm has limited memory
  // so, the factorialHelper for some reason won't crash it because of the accumulator.
  // the accumulator holds all the data as a placeholder instead of temporarily holding onto all the loops until its done
  // the code executes, and passes on a accumulator, and closes out the recursion before moving on

  // TAIL RECURSION aka, the calling of itself is the last thing
  // JVM won't have to carry the temp number, it can close out first
  // What was tripping up the previous method was the fact that it called itself when saving the val
  // We were creating a jenga tower, while the tail recursion is more like a domino
}
