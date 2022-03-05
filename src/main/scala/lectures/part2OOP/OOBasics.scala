package lectures.part2OOP

object OOBasics extends App {

  // had error before args came in
  val person = new Person("John", 26)
  println(person)
  // can't just person.age like other langs
  // it's a param, not field. the way to change this is to give val/var keyword to the param in constructor

  // after adding val to constructor this works
  println(person.age)
  person.greet("Dom")
}
// constructor is super simple
class Person (name: String, val age: Int) {
  // body, class implementations is evaluated everytime the class is instantiated
  // x is now a field. so it can be accessed
  val x = 2
  println(1 + 3)

  // inside def is method
  def greet(name: String): Unit = println(s"$name says: Hi, $name")
  // this.name would be the class's field
  // name would be the arg passed

  // overloading would be diff params/ diff param types
  // so I can't just greet() x2

  // auxiliary constructor, basically a follow up constructor
  def this(name: String) = this(name, 0)
  // aux constructor can only call constructor
  // so it's just a funnel to get defaults? instead you can give defaults for the constructor at the class definition up top=
  def this() = this("John Doe")



}
