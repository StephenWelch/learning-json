package demo.flag

import com.google.gson.GsonBuilder
import java.awt.Color
import java.util.HashMap
import com.google.gson.reflect.TypeToken



val gson = GsonBuilder().setPrettyPrinting().create()!!

fun main( args : Array<String> ) {

    val americanFlag = Flag("United States of America", arrayOf(Color.RED, Color.WHITE, Color.BLUE), false)
    val stephenFlag = Flag("Stephen", arrayOf(Color.BLUE), false)

    val flagMap = hashMapOf("Murica" to americanFlag, "Stephen" to stephenFlag)

    val json = gson.toJson(flagMap)
    println(json)

    val typeOfHashMap = object : TypeToken<HashMap<String, Flag>>() {

    }.type

    val parsed : HashMap<String, Flag> = gson.fromJson(json,typeOfHashMap)
    println(parsed)

}