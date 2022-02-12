package lectures.part1basics

object TypeInference extends App {
  // the only available value is 2 which is int
  val x = 2
  // in this case a Int + String is usually a String as we often use in printing or making strings
  val y = x + "items"
  // this isn't a order issue of having the String at the end
  // default a String + Int is always String
  val z = "items" + x
  println(z)

  // compiler knows this is going to return Int  bc its the only known and there is no conflict
  def succ(x: Int) = x + 1

  // this will throw error because it needs a return type
  // the reason is, compiler doesn't want to nestle down into the recursion
  // it can't go all the way in with all the possibilities just to help you when it compiles
  // it needs a stated return type so the runtime/compile isn't an unmanageable mess
//  def factorial(n: Int) =
//    if (n <= 0) 1
//    else n * factorial(n - 1)
//
//
}
