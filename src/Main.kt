
import jdk.internal.util.xml.impl.Input
import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")


    val file = File("a_example.in")
    val input = Scanner(file)

    val inputData = InputData()

    while (input.hasNextLine()) {
        val line = input.nextLine()
        val elements = line.split(" ").map { it.toInt() }
        inputData.rows = elements[0]
        inputData.columns = elements[1]
        inputData.vehicles = elements[2]
        inputData.rides = elements[3]
        inputData.bonus = elements[4]
        inputData.steps = elements[5]

        val x = 0
    }


}