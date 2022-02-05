package lectures.part1basics

object Functions extends App {

  // the structure of a function in scala
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  // i think this used to be ok but now it needs to be called with ()
  //  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // SUPER IMPORTANT
  // instead of loops, we use RECURSIONS IN SCALA

  // unit as the return type so that we don't return anything
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  // 1. greeting function
  // 2. factorial 1 * 2 * 3 .. * n
  // 3. a fibonacci function

  def aGreetingFunction(name: String, age: Int) = {
    println("Hi my name is " + name + " and I am " + age + " years old")
//    println("Hi my name is $name and I am $age years old")
  }

  aGreetingFunction("Dominic", 36)

  def aFactorialFunction(n: Int): Int = {

    def theRecursiveFunction(holdingVar: Int, nextInt: Int): Int = {
      if (nextInt > 0) theRecursiveFunction(holdingVar * nextInt, nextInt - 1) else holdingVar
    }

    theRecursiveFunction(1, n)
  }

  println(aFactorialFunction(3))


  def aFibonacciFunction(n: Int): Int = {
    def theRecurse(first: Int, second: Int, currentSpot: Int): Int = {
      val third = first + second
      if (currentSpot != n) theRecurse(second, third, currentSpot + 1) else third
    }

    if (n > 2) theRecurse(1, 1, 3) else 1

  }

  println(aFibonacciFunction(5))

  def isNumberPrime(number: Int): Boolean = {

    def goDeeper(number: Int, holdingVar: Int): Boolean = {

      val numberDividedByHolding = number % holdingVar
      // if there is no remainder, it was NOT a prime bc it was divisible perfectly
      if (numberDividedByHolding == 0) {
        false
      } else {
        // at the end of valid increments
        if (holdingVar == 2) {
          true
        } else {
          goDeeper(number, holdingVar - 1)
        }
      }

    }

    if (number > 1) goDeeper(number, number - 1) else false

  }

  println(isNumberPrime(13))
  println(isNumberPrime(15))
  


}
