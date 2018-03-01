class InputData {
    var rows: Int = 0
    var columns: Int = 0
    var vehicles: Int = 0
    var rides: Int = 0
    var bonus: Int = 0
    var steps: Int = 0
    var arrayOfRides: ArrayList<Ride> = arrayListOf()
}

class Ride {
    var id : Int = -1
    var from : Point = Point()
    var to : Point = Point()
    var earliestStart : Int = -1
    var latestFinish: Int = -1
    var rideLength = 0
}

data class VehicleRide(
    var totalLength : Int = 0,
    var ride : Ride? = null
)

class Point(val row:Int = 0, val column: Int = 0) {

    fun equals(other: Point): Boolean {
        return this.row == other.row && this.column == other.column
    }
}

class Vehicle {
    var currentRide : Ride? = null
    var currentPoint = Point(0,0)
    var rides = arrayListOf<Int>()
}