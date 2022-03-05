package lectures.part1basics

object CBNvsCNV extends App {

    def calledByValue(x: Long): Unit = {
        // when called by value, the value of input is passed, not the input object
        println("by value " + x)
        println("by value " + x)
    }

    def calledByName(x: => Long): Unit = {
        // when called by name, the entire input is passed whole so System.nanoTime() is passed and not the value of System.nanoTime() as time of passing
        println("by value: " + x)
        println("by value: " + x)
    }


    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int) = println(x)

    // you would expect this to crash, but it won't
    // because the calledByName passes the entire function and it's only called when it's used
    // and in this case, it's literally never used because only the first argument is used in printFirst
    // if on the other hand, infinite is the first arg, then it would crash because it's used in printFirst
    // infinite is supposed to crash bc it calls itself recursively forever after adding 1
    printFirst(34, infinite())



}
