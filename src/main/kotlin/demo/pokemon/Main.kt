package demo.pokemon

import com.google.gson.Gson
import demo.Pokedex
import java.io.File

fun main( args : Array<String> ) {

    val gson = Gson()

    val json = File("src/main/resources/pokedex.json").readText(Charsets.UTF_8)

    val pokedex = gson.fromJson<List<Pokemon>>(json)

    for(pokemon in pokedex!!.pokemon) {
        println(pokemon)
    }

}