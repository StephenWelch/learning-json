package demo.movie

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import demo.movie.model.Movie
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.TextField
import tornadofx.*
import tornadofx.Stylesheet.Companion.listView
import java.io.File

class MovieView : View() {

    override val root = borderpane {

        center {
            vbox {
                button("Look up Actor/Actress") {
                    action {
                        dialog {
                            title = "Enter Information"
                            vbox {
                                label("Enter Actor/Actress Name: ")
                                val nameField = textfield()
                                button("Submit").setOnAction {
                                    dialog {
                                        listview(getMoviesWithName(nameField.text).toObservableList())
                                    }
                                }
                            }
                        }
                    }
                }

                button("Look up Movie Title") {
                    action {
                        dialog {
                            title = "Enter Information"
                            vbox {
                                label("Enter Movie Title: ")
                                val titleField = textfield()
                                button("Submit").setOnAction {
                                    dialog {
                                        listview(getMoviesWithTitle(titleField.text).toObservableList())
                                    }
                                }
                            }
                        }
                    }
                }
                button("Look up a Year") {
                    action {
                        dialog {
                            title = "Enter Year"
                            vbox {
                                label("Enter Year")
                                val yearField = textfield()
                                button("Submit").setOnAction {
                                    dialog {
                                        label(
                                            "Number of Movies with title \"${yearField.text}\": ${getMoviesWithYear(
                                                yearField.text.toInt()
                                            ).size}"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                button("Add a new movie") {
                    action {
                        dialog {
                            hbox {
                                var movie = Movie("", 0, arrayListOf(), arrayListOf())
                                var castField: TextField? = null
                                var genreField: TextField? = null

                                val form = form {
                                    field("Title") {
                                        textfield().textProperty().addListener { observable, _, _ ->
                                            movie.title = observable.value
                                        }
                                    }
                                    field("Year") {
                                        textfield().textProperty().addListener { observable, _, _ ->
                                            movie.year = if (observable.value.isEmpty()) 0 else observable.value.toInt()
                                        }
                                    }
                                    field("Cast Member") {
                                        castField = textfield()
                                    }
                                    field("Genre") {
                                        genreField = textfield()
                                    }
                                }
                                vbox {
                                    button("Submit").setOnAction {
                                        movie.cast = castField!!.text.split(",").toList()
                                        movie.genres = genreField!!.text.split(",").toList()
                                        movies.add(movie)
                                        println("Adding movie: $movie")
//                                println(movies)
                                        File("src/main/resources/movies.json").writeText(gson.toJson(movies))
                                        movies = loadMovies()
                                    }
                                }
                            }

                        }
                    }
                }
                button("Degrees to Kevin Bacon")
            }
        }

    }

    private var movies: MutableList<Movie>
    private val gson: Gson = Gson()

    init {
        movies = loadMovies()
    }

    private fun getMoviesWithName(name: String): List<String> = movies.filter { it.cast.contains(name) }.map { it.title }
    private fun getMoviesWithTitle(title: String): List<String> = movies.filter{ it.title.toLowerCase().contains(title.toLowerCase()) }.map { it.toPrettyString() }
    private fun getMoviesWithYear(year: Int): List<Movie> = movies.filter {it.year == year}


    fun <T> List<T>.toObservableList(): ObservableList<T> {
        val list: ObservableList<T> = observableList()
        list.addAll(this)
        return list
    }

    private fun loadMovies(): MutableList<Movie> {
        val json = File("src/main/resources/movies.json").readText(Charsets.UTF_8)
        val typeOfMovieArray = object : TypeToken<List<Movie>>(){}.type
        return gson.fromJson<MutableList<Movie>>(json, typeOfMovieArray)
    }

}