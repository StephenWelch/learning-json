package demo.pokemon

import demo.pokemon.ui.PokeView
import javafx.application.Application
import javafx.stage.Stage
import tornadofx.App

class Main(): App() {

    override val primaryView = PokeView::class

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 800.0
        stage.height = 600.0
    }

}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}

