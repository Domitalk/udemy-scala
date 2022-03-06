package lectures.part2OOP

object InheritanceAndTraits extends App{

  // single class inheritance
  // ONLY INHERIT ONE CLASS
  class Animal {
    val creatureType = "Wild"
    protected def eat = println("nom nom nom")
    // you can private, like in Java
    // or protected, which allows subclasses to access the method as well

  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
//  cat.eat
  // eat is now protected, now we can't access it outside. but Cat class can access it
  cat.crunch


  // constructors
  class Person(name: String, age: Int)
  // this won't compile bc it tries to construct Person first
//  class Adult(name: String, age: Int, idCard: String) extends Person
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)


  //overriding

  class Dog extends Animal {
    override val creatureType: String = "Domestic"
    // this is public now bc override and no protected
    override def eat = println("Crunch Crunch Override")

  }


  // same as above, but instead overriding in teh constructor
  class Dog2(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("Crunch Crunch Override")
    }

  }

  val dog = new Dog2("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution
  // POLYMORPHISM, bc the "type" was Animal but Dog2 inherited Animal
  val unknownAnimal: Animal = new Dog
  // this crash? because
//  unknownAnimal.eat


  // final keyword will prevent override
  // seal will make it so you can extend class in THIS FILE but not other files
  // super is used like normal, to access parent's methods

}
