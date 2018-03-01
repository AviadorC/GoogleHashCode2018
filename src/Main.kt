
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    println("Hello World!")


    val file = File("a_example.in")
    val input = Scanner(file)

    val inputData = parseData(input)

    val allVehicles = arrayListOf<Vehicle>()
    for (i in 0 until inputData.vehicles) {
        allVehicles.add(Vehicle())
    }

    inputData.arrayOfRides.sortBy { it.latestFinish }
    val finishes = inputData.arrayOfRides.groupBy { it.latestFinish }

    val ridesByImportance = hashMapOf<Int, ArrayList<Ride>>()
    for (ride in finishes.keys) {
        val rides = finishes[ride]
        var newRides = arrayListOf<Ride>()
        newRides.addAll(rides!!)
        newRides.sortBy { it.earliestStart }

        ridesByImportance.put(ride, newRides)
    }

    val orderedKeys = ridesByImportance.keys.toIntArray()
    orderedKeys.sort()

    for (i in 0 until inputData.steps) {

    }

    val x = 0
}

private fun parseData(input: Scanner) : InputData {
    val inputData = InputData()

    var firstLine = true
    var riderCounter = 0
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
        newRide.id = riderCounter
        newRide.from = Point(elements[0], elements[1])
        newRide.to = Point(elements[2], elements[3])
        newRide.earliestStart = elements[4]
        newRide.latestFinish = elements[5]
        newRide.rideLength = Math.abs(newRide.to.row - newRide.from.row) + Math.abs(newRide.to.column - newRide.from.column)

        inputData.arrayOfRides.add(newRide)

        riderCounter += 1

    }

    return inputData
}