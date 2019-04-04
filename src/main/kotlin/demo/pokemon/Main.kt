package demo.pokemon

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import javafx.application.Application
import tornadofx.App
import tornadofx.UIComponent
import tornadofx.View
import tornadofx.hbox
import java.io.File
import kotlin.reflect.KClass

class Main(): App() {

    override val primaryView = PokeView::class

}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}

//fun main( args : Array<String> ) {
//
//    val gson = Gson()
//
//    val json = File("src/main/resources/pokedex.json").readText(Charsets.UTF_8)
//
//    val pokedex = gson.fromJson<Pokedex>(json)
//
//    println(pokedex)
//    println("Pokedex Size: " + pokedex.pokemon.size)
//
//}