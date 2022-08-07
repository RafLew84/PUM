package pl.udu.uwr.pum.carsyappkotlin.data

import java.time.LocalDate
import java.util.*
import kotlin.random.Random

object DataProvider {
    private val generalCosts = List(100) {
        Cost(
            CostType.values()[Random.nextInt(CostType.values().size)],
            LocalDate.of(2022, Random.nextInt(1,13), Random.nextInt(1,28)),
            Random.nextInt(5000)
        )
    }

    private val groupedCostMap: Map<String, List<Cost>> = generalCosts.sortedBy { it.date.month }.groupBy { it.date.month.toString() }

    fun getTimeLineList(): List<CostListItem>{
        val list = mutableListOf<CostListItem>()
        for (date: String in groupedCostMap.keys) {
            val groupItems: List<Cost>? = groupedCostMap[date]
            groupItems?.sortedBy { it.date.dayOfMonth }?.forEach {
                list.add(CostGeneralItem(it))
            }
            list.add(CostDateItem(date))
        }
        return list
    }

}