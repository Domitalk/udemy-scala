package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(2 + 3  * 4)
  // most expressions are maths
  // + - * / & |
  // scala has some unique ones like ^ << >> >>>

  println(1 == x)
  // equality comparison
  // == != > >= < <=

  println(!(1 == x))
  // logical
  // ! && ||

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // INSTRUCTIONS VS EXPRESSIONS
  // Instructions order the code to DO something
  // Expressions are about VALUE
  //

  // IF Expressions
  val aCondition = true
  // if expression because its returning a value
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // while loops are imperative
  // imperative languages like java do well with it, SCALA DOES NOT
  // Everything in Scala should be expressions

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), while, reassign
  // when side effect happens, they return a Unit aka nothing
  // this is to be avoided in Scala because its expressive, not imperative

  // code blocks are expressions
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // error, because z is inside a code block
  //  val anotherValue = z + 1

  // Scala all about gimme a value


  // 1. diff bt "hello" and println("hello")
  // String and Unit ?

  val someValue = {
    2 < 3
  }
  // true ?

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // 42 ?
  // the if became irrelevant because in a expression lang the return isn't some escape, it's the final thing





}
