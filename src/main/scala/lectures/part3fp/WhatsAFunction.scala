package lectures.part3fp

object WhatsAFunction extends App {

  // use functions as first class elements, like values and not processes
  // but java is oop, instance of classes
  // so we need to change it up to make fp

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // we can call this out of the box
  println(doubler(2))
}

// we used to instantiate this class to start working with it
// bc oop wants a class and instance
class Action {
  def execute(element: Int): String = ???
}

trait MyFunction[A, B] {
  def apply(element: A): B
}