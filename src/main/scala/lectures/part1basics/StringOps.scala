package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  // arg1 = inclusive, arg2 = exclusive
  println(str.substring(7,11))
  // separates all based on space, returns arr
  println(str.split(" ").toList)
  // true or false return
  println(str.startsWith("Hello"))
  // replace needs two args
  println(str.replace(" ", "-"))

  println(str.toLowerCase())
  println(str.toUpperCase())

  // super useful
  println(str.length)

  // SCALA has access to all of the java String class methods

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  // this is supposed to prepend +: and append :+ but for some reason it's not doing it right
  // this ended up treating as vector
  println("a" +: aNumberString :+ "z")
  println(str.reverse)
  // the first two
  println(str.take(2))


  // Scala String-interpolators
  val name = "David"
  val age = 12
  // the s in front of " will make it so that we can use $ inside to interpolate
  val greeting = s"Hello, my name is $name and I am $age years old"

  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  // two char min and 2 decimal percision for %2.2f
  // %s means string
  // so f-interpol means basically we have to specify format after any variable used in interpol
  val myth = f"$name%s can eat $speed%2.2f"
  println(myth)

  // raw-interpolator
  // can print characters LITERALLY
  println(raw"This is a \n newline")
  // this would normally escape \n bc regex but raw" makes it show up

  // but if used in variable and then injected, it will create a new line
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
