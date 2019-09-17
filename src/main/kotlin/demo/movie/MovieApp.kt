package demo.movie

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import demo.movie.model.Movie
import javafx.scene.Scene
import javafx.stage.Stage
import tornadofx.App
import tornadofx.UIComponent
import tornadofx.launch
import java.io.File

class MovieApp: App(MovieView::class) {

    override fun createPrimaryScene(view: UIComponent): Scene {
        return Scene(view.root, 640.0, 480.0)
    }
}

fun main( args : Array<String> ) {
    launch<MovieApp>(args)
}