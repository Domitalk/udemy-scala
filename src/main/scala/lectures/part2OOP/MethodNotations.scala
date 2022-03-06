package lectures.part2OOP

import scala.language.postfixOps


// INFIX
// object method params
// mary.likes("Inception")
// mary likes "Inception"
// only works for one arg

// PREFIX
// mary.unary_!
// !mary
// only works for + - ! ~


// POSTFIX
// mary.isAlive
// mary isAlive
// only for methods without params
// rarely used because it can cause confusion

// APPLY
// special because you can call the object as a function and it'll run apply


// Syntactic Sugar
object MethodNotations extends App {
  // we're inside here so there's no conflict with the other Person class that was created
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // exercises, overload the +
    def +(nickname: String): Person = new Person(name = s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    // THIS GUY IS THE PREFIX FROM BOTTOM OF THE OBJECT PREFIX
    def unary_! : String = s"$name, what the heck?!"

    // learns and learnsScala
    def learns(newLang: String): String = s"$name learns $newLang"
    def learnsScala: String = learns("Scala")

    // POSTFIX
    def isAlive: Boolean = true

    // apply needs a ()
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }


  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // this is the syntactic sugar of infix notation aka operator notation
  println(mary likes "Inception")
  // Object Method Parameter
  // this order works when single params

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  // Now we can see a more far reaching way to use this sugar
  println( mary hangOutWith tom )
  // now we can do soemthing crazy
  println(mary + tom)
  // OR
  println(mary.+(tom))
  // Scala doesn't limit reserved keywords as much so you can get super creative like this

  // this means in a sense that
  println(1 + 2)
  println(1.+(2))

  // because + is just a method in the Int class

  // THIS IS CALLED INFIX


  // NOW TO PREFIX

  val x = -1
  val y = 1.unary_-
  // these two are the same
  // unary_ prefix only works with - + ~ !

  // this will call mary.unary_!
  println(!mary)



  // NOW POSTFIX
  println(mary.isAlive)
  // same same but this works when method doesn't have params
  println(mary isAlive)



  // apply is werid in Scala
  println(mary.apply())
  // same as
  println(mary())
  // apply is like calling the entire object itself
  // apply is the default implementation



  // overload the + operator
  // mary + "the rockstar" => new person "Mary (the rockstar)"
  println((mary + "the Rockstar")())
  // or (mary + "the Rockstar").apply() because +String will return a Person and we can call apply on that

  // add an age to the Person class
  // add a unary + operator => new person with the age + 1
  // +mary should return a new mary with the age incremented
  // ANS: Prob a empty +() should new Person (age+1)
  println((+mary).age)


  // add "learns" method in the Person class
  // takes a string and returns "Mary learns $string"
  println(mary.learnsScala)
  println(mary learnsScala)

  // another method called learnsScala which calls learns method with "Scala"
  // use postfix notation

  // overload the apply method
  // mary.apply(2) => "mary watched inception 2 times"

  println(mary(2))

}
