package lectures.part1basics

object ValuesVariablesTypes extends App {

  // Overkill, don't necessarily need to define Int type because Scala can infer
  val x: Int = 42
  println(x)

  // inferred type
  val x2 = 42

  // VALS are immutable
  // so, can't assign x = 2 afterwards
  // vals are more like const

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  // char is single ' not "
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 432
  // L at end like in Java
  val aLong: Long = 54325235L
  // f like Java
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14



  var aVariable: Int = 4
  // variables are mutable
  aVariable = 5










}
