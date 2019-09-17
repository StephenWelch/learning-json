package demo.movie.model

data class Movie(
    var title: String,
    var year: Int,
    var cast: List<String>,
    var genres: List<String>
) {
    fun toPrettyString(): String {
        return "${this.title} (${this.year}, ${this.cast[0]})"
    }
}