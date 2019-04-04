package demo.pokemon

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import tornadofx.View
import tornadofx.button
import tornadofx.hbox
import tornadofx.imageview
import java.io.File

class PokeView(): View() {

    val gson = Gson()
    val json = File("src/main/resources/pokedex.json").readText(Charsets.UTF_8)
    val pokedex = gson.fromJson<Pokedex>(json)

    override val root = hbox {
        imageview("http://www.serebii.net/pokemongo/pokemon/145.png")
        button("Refresh").setOnAction {
            for(pokemon in pokedex.pokemon) {
                println("Creating ImageView for: " + pokemon.img)
                imageview(pokemon.img)
            }
        }
    }



}