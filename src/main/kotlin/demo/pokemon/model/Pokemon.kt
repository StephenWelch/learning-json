package demo.pokemon.model

data class Pokemon(
    val id: Int,
    val num: Int,
    val name: String,
    val img: String,
    val type: Array<Type>,
    val height: String,
    val weight: String,
    val candy: String,
    val candy_count: Int,
    val egg: String,
    val spawn_chance: Double,
    val spawn_time: String,
    val multipliers: Array<Double>,
    val weaknesses: Array<Type>,
    val next_evolution: Array<PokemonReference>
)