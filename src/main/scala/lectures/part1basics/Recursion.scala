package lectures.part1basics

import scala.annotation.tailrec

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

//  println(factorial(10))
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



  // CHALLENGES
  /*
  1. concat a string n times
  2. IsPrime function as a tail recursion
  3. fibonacci function with a tail recursion
  */

  // OOPS I DID POPPER NOT CONCAT
  def stringOfNineLives(inputString: String, n: Int): String = {
    @tailrec
    def tailHelper(newString: String, newNumber: Int): String = {
      if (newNumber == 0) newString
      else tailHelper(newString.substring(0, newString.length - 1), newNumber - 1)
    }
    tailHelper(inputString, n)
  }
//  println(stringOfNineLives("abcdef", 3))

  @tailrec
  def concatMe(inputString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatMe(inputString, n - 1, inputString + accumulator)
  }
//  println(concatMe("abc", 6, ""))

  def optimusPrime(n: Int): Boolean = {

    @tailrec
    def recurseMe(newNumber: Int, keepGoing: Boolean): Boolean = {
      if (newNumber <= 1) true
      else if (!keepGoing || n % newNumber == 0) false
      else recurseMe(newNumber - 1, true)
    }
    recurseMe(n - 1, true)
  }


  // video answer to isPrime
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, (n % t != 0) && isStillPrime)
    }
    isPrimeTailrec(n / 2, true )
  }

//  println(optimusPrime(7))

  // oops, i totally forgot what a fibonacci does, so i did it wrong. let's try again
  def fizboTheClown(n: Int): Int = {

    @tailrec
    def recurseTheFizz(newNumber: Int, accumulator: Int): Int = {
      if (newNumber <= 0) accumulator
      else recurseTheFizz(newNumber - 1, newNumber * accumulator)
    }

    recurseTheFizz(n, 1)
  }
//  println(fizboTheClown(4))

//  println(fizboTheClown(4))

  def newFizbo(n: Int): Int = {
    @tailrec
    def fizboRecursive(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fizboRecursive(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fizboRecursive(2, 1, 1)
  }

  println(newFizbo(8))

  // video answer to fibonacci

}
