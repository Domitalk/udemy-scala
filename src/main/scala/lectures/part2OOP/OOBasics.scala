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

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel ("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

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

class Writer (firstName: String, surName: String, val year: Int) {
  def fullname: String = {
    s"$firstName $surName"
  }
}
class Novel (name: String, yearOfRelease: Int, val author: Writer) {
  def authorAge: Int = {
    this.yearOfRelease - author.year
  }
  def isWrittenBy(author: Writer): Boolean = {
    this.author == author
  }
  def copy(newYearRelease: Int): Novel = {
    new Novel(name = this.name, yearOfRelease = newYearRelease, author = this.author)
  }
}

class Counter(val num: Int) {
  // a return the count is actually unncessary if there is a val in front of the arg because it effectively recreates a getter when it is a field

  // you want immutable, so return a new entire instance of the variable
  // and we want returned a new Counter as return val
  // zero arg methods don't need to be called with () so we can just use the name here
  def increment = new Counter(num + 1)
  def decrement = new Counter(num - 1)
  def increment(n: Int): Counter =  {
    if (n <= 0) this
    else increment.increment(n - 1)
  }
  def decrement(n: Int): Counter = {
    if (n <= 0) this
      // the n-1 is the recursion here because the amount of times it needs to do it is n
    else decrement.decrement(n - 1)
  }

}