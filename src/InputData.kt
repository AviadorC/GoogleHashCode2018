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
    var from : Point = Point()
    var to : Point = Point()
    var earliestStart : Int = -1
    var latestFinish: Int = -1
}

data class Point(val row:Int = 0, val column: Int = 0)