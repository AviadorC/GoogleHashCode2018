package com.zetcode

import java.io.File
import Vehicle

fun main(args: Array<String>) {

    val fileName = "src/resources/myfile3.txt"
    val myfile = File(fileName)

    val content = "Today snow is falling."

    myfile.writeText(content)

    println("Writed to file")
}

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