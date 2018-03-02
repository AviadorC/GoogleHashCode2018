package com.zetcode

import java.io.File
import Vehicle

class Output {
    val fileName = "result.txt"
    val myfile = File(fileName)

    fun write(vehicle: Vehicle ) {
        myfile

        var text = StringBuilder()
        text.append(vehicle.rides.count().toString() + " ")

        for (item: Int in vehicle.rides) {
            text.append(item.toString() + " ")
        }

        myfile.appendText(text.toString())
        myfile.appendText("\n")
    }
}