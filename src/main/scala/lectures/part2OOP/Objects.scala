package lectures.part2OOP

object Objects extends App {

  // Scala doesn't have class-level functionality, "static"

  object Person {
    // static class level functionality
    val N_EYES = 2
    // this is 'class level functionality' in Scala
    def canFly: Boolean = false

    // Objects don't receive args

    // SCALA OBJECT IS A SINGLETON INSTANCE
    // Is it's own type, and only instance
    // so it's like making a class, and making one instance of a class
    // Single and only instance of that class, so we call it object instead

    // THIS IS NOW A FACTORY METHOD
    // because it'll build a person
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality

  }

  // having a object and class in same scope, same name
  // !!!!!!!!! COMPANIONS !!!!!!!!!!!
  // all the functionality is retrieved from an instance of class because the object is singleton and that's where the functions are pulled from
  // otherwise you pull data/functionality from the instance of class you created



  println(Person.N_EYES)
//  println(Person.canFly)

  val mary = Person
  val john = Person
  println(mary == john)

  val mary2 = new Person("Mary")
  val john2 = new Person("John")
  println(mary2 != john2)

  // watch out for singleton Person vs new Person instance

  val bobby = Person(mary2, john2)
  println(bobby.name)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
  // the java entry point in our case, it's the extends App

  // if we want to run separately we can actually create a def main(args: Array[String]): Unit = {} to run all of our procedurals


}
