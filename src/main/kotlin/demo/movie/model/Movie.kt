package demo.movie.model

data class Movie(
    val title: String,
    val year: Integer,
    val cast: Array<String>,
    val genres: Array<String>
)