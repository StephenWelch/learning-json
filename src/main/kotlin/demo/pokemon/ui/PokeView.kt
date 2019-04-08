package demo.pokemon.ui

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import demo.pokemon.model.Pokedex
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import tornadofx.*
import java.io.File

class PokeView(): View() {

    val gson = Gson()
    val json = File("src/main/resources/pokedex.json").readText(Charsets.UTF_8)
    val pokedex = gson.fromJson<Pokedex>(json)

    override val root = stackpane {
            val barChartData: ObservableList<XYChart.Series<String, Number>> = FXCollections.observableArrayList()

            for(pokemon in pokedex.pokemon) {
                val series = XYChart.Series<String, Number>()
                series.data.add(XYChart.Data<String, Number>(pokemon.name, pokemon.spawn_chance))
                barChartData.add(series)
            }

            val categoryAxis = CategoryAxis()
            val chanceAxis = NumberAxis()
            val barchart = barchart(
                "Spawn Chances", categoryAxis, chanceAxis
            )

            barchart.apply {
                data.addAll(barChartData)
                useMaxSize = true
                
            }

    }



}