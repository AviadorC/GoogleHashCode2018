
import java.io.File
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")


    val file = File("a_example.in")
    val input = Scanner(file)

    val inputData = InputData()

    var firstLine = true
    while (input.hasNextLine()) {
        val line = input.nextLine()
        val elements = line.split(" ").map { it.toInt() }

        if (firstLine) {
            inputData.rows = elements[0]
            inputData.columns = elements[1]
            inputData.vehicles = elements[2]
            inputData.rides = elements[3]
            inputData.bonus = elements[4]
            inputData.steps = elements[5]

            firstLine = false
            continue
        }

        val newRide = Ride()
        newRide.from = Point(elements[0], elements[1])
        newRide.to = Point(elements[2], elements[3])
        newRide.earliestStart = elements[4]
        newRide.latestFinish = elements[5]

        inputData.arrayOfRides.add(newRide)

    }

    val x = 0
}