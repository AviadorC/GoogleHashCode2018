
import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    val file = File("hellofile.txt")
    val input = Scanner(file)
    if (input.hasNextLine()) {
        val answer = input.nextLine()
        println(answer)
    }

    val writer = file.printWriter().use {
        out -> out.println("Written")
    }
}