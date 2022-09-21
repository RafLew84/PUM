package pl.udu.uwr.pum.verynobleappkotlin.ui.util

enum class Cat{
    PHYSICS, CHEMISTRY, LITERATURE, PEACE, ECONOMY, MEDICINE
}

val categories = mapOf(
    Cat.PHYSICS to "phy",
    Cat.CHEMISTRY to "che",
    Cat.ECONOMY to "eco",
    Cat.LITERATURE to "lit",
    Cat.PEACE to "pea",
    Cat.MEDICINE to "med"
)

const val baseUrl: String = "http://api.nobelprize.org/"