package pl.udu.uwr.pum.carsyappkotlin.data

data class Car (
    val name: String,
    val brand: String,
    val model: String,
    val yearOfProduction: Int,
    val costs: List<Cost>
)