package com.zetcode

import java.io.File
import Vehicle

public class output {
   public val fileName = "result.txt"
    public val myfile = File(fileName)

    fun write(vehicle: Vehicle ) {
        var text: String = ""
        text += (vehicle.rides.count().toString() + " ")

        for (item: Int in vehicle.rides) {
            text += (item.toString() + " ")
        }

        myfile.appendText(text)
    }
}