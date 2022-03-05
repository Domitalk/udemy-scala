package lectures.part1basics

object DefaultArgs extends App {

  // default arg would really solve a lot of problems here b/c usually the 1 is only used the first time
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10)

  // now we can get into trouble with default value bc its the first arg so order of operations will use the 800 as first arg
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture("jpg", 800, 900)

  // so, pass every leading argument
  // or, name the arguments
  savePicture(width = 900)



}
