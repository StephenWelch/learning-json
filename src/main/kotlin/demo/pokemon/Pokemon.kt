package demo.pokemon

data class Pokemon(
    val id: Int,
    val num: Int,
    val img: String,
    val type: Array<Type>,
    val height: String
)