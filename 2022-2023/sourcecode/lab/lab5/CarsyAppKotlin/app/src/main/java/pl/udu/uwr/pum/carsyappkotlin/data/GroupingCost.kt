package pl.udu.uwr.pum.carsyappkotlin.data

open class CostListItem(
    val type: Int
) {
    companion object {
        const val TYPE_DATE = 0
        const val TYPE_GENERAL = 1
    }
}

class CostGeneralItem(
    val cost: Cost
) : CostListItem(TYPE_GENERAL)

class CostDateItem(
    val date: String
) : CostListItem(TYPE_DATE)