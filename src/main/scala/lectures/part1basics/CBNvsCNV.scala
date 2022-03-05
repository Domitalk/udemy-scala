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

}
