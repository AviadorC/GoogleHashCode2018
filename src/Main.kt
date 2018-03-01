
import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")


    val file = File("a_example.in")
    val input = Scanner(file)
    while (input.hasNextLine()) {
        val line = input.nextLine()
        val elements = line.split(" ").map { it.toInt() }
        val x = 1;
    }


}