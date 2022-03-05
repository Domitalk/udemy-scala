package lectures.part2OOP

object OOBasics extends App {

  // had error before args came in
  val person = new Person("John", 26)
  println(person)
  // can't just person.age like other langs
  // it's a param, not field. the way to change this is to give val/var keyword to the param in constructor

  // after adding val to constructor this works
  println(person.age)
}
// constructor is super simple
class Person (name: String, val age: Int) {
  // body, class implementations is evaluated everytime the class is instantiated
  // x is now a field. so it can be accessed
  val x = 2
  println(1 + 3)
}
