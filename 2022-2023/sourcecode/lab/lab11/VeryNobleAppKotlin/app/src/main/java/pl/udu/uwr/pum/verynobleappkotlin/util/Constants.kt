package pl.udu.uwr.pum.verynobleappkotlin.util

enum class Cat{
    PHYSICS, CHEMISTRY, LITERATURE, PEACE, ECONOMY, PHYSIOLOGYORMEDICINE
}

val categories = mapOf(
    Cat.PHYSICS to "phy",
    Cat.CHEMISTRY to "che",
    Cat.ECONOMY to "eco",
    Cat.LITERATURE to "lit",
    Cat.PEACE to "pea",
    Cat.PHYSIOLOGYORMEDICINE to "med"
)

const val baseUrl: String = "https://api.nobelprize.org/"


// binding.categoryFullNameTextView.text = categories[Cat.valueOf(category!!.uppercase().filterNot { it.isWhitespace() })]