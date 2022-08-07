package pl.udu.uwr.pum.carsyappkotlin.data

import pl.udu.uwr.pum.carsyappkotlin.R
import java.time.LocalDate

enum class CostType(val costType: String, val icon: Int) {
    REFUELING("Tankowanie", R.drawable.ic_fuel),
    SERVICE("Serwis", R.drawable.ic_car_repair),
    PARKING("Parking", R.drawable.ic_parking),
    INSURANCE("Ubezpieczenie", R.drawable.ic_general_cost),
    TICKET("Mandat", R.drawable.ic_ticket)
}

data class Cost (
    val type: CostType,
    val date: LocalDate,
    val amount: Int
    )