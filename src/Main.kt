
import java.io.File
import java.security.cert.PolicyNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

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
        var availableRideFinishes = orderedKeys.filter { it > i }
        val availableRides = arrayListOf<Ride>()

        for (possibleFinish in availableRideFinishes) {
            val allFinishRoads = ridesByImportance[possibleFinish] ?: continue

            val nonTakenRoads = allFinishRoads.filter { road ->
                allVehicles.any { it.currentRide!!.id == road.id }
            }

            availableRides.addAll(nonTakenRoads)
        }

        val stepsToEnd = inputData.steps - i

        emptyVehicles(allVehicles)

        val nonBusyVehicles = allVehicles.filter { it.currentRide != null }

        var vehicleAvailableRoads : HashMap<Vehicle, ArrayList<VehicleRide>> = hashMapOf()

        for (vehicle in nonBusyVehicles) {
            vehicleAvailableRoads.put(vehicle, arrayListOf())

            for (road in availableRides) {
                val toStart = getLength(vehicle.currentPoint, road.from)
                val fromStartToFinish = getLength(road.from, road.to)
                val totalLength = toStart + fromStartToFinish

                if (totalLength > stepsToEnd) {
                    continue
                }

                vehicleAvailableRoads[vehicle]?.add(VehicleRide(totalLength, road))
            }

            vehicleAvailableRoads[vehicle]?.sortBy { it.totalLength }
            vehicleAvailableRoads = hashMapOf()
        }

        /// Optimalizations



    }

    val x = 0
}

private fun emptyVehicles(allVehicles : ArrayList<Vehicle>) {
    for (v in allVehicles) {
        if (v.currentRide != null && v.currentPoint.equals(v.currentRide?.to))
            v.rides.add(v.currentRide!!.id)
        v.currentRide = null
    }
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
        newRide.rideLength = getLength(newRide.from, newRide.to)

        inputData.arrayOfRides.add(newRide)

        riderCounter += 1

    }

    return inputData
}

private fun getLength(from: Point, to: Point) : Int {
    return Math.abs(from.row - to.row) + Math.abs(from.column - to.column)
}