package demo.movie

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import demo.movie.model.Movie
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.hbox
import java.io.File

class MovieView() : View() {

    override val root = hbox {

        button("Look up Actor/Actress") {
            action {
            }
        }
        button("Look up Movie Title")
        button("Look up a Year")
        button("Add a new movie")
        button("Degrees to Kevin Bacon")

    }

}

fun main( args : Array<String> ) {

    val gson = Gson()
    val json = File("src/main/resources/movies.json").readText(Charsets.UTF_8)

    val typeOfMovieArray = object : TypeToken<Array<Movie>>(){}.type
    val movies = gson.fromJson<Array<Movie>>(json, typeOfMovieArray)

}