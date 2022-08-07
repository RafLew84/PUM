package pl.udu.uwr.pum.carsyappkotlin.data

import java.time.LocalDate
import java.util.*

object DataProvider {
    private val generalCosts = listOf(
        Cost(CostType.REFUELING, LocalDate.of(2022, 2, 11), 120),
        Cost(CostType.REFUELING, LocalDate.of(2022, 3, 11), 871),
        Cost(CostType.SERVICE, LocalDate.of(2022, 4, 23), 1300),
        Cost(CostType.PARKING, LocalDate.of(2022, 3, 3), 40),
        Cost(CostType.INSURANCE, LocalDate.of(2022, 3, 9), 700),
        Cost(CostType.TICKET, LocalDate.of(2022, 3, 12), 100),
        Cost(CostType.REFUELING, LocalDate.of(2022, 3, 1), 600),
        Cost(CostType.SERVICE, LocalDate.of(2022, 3, 1), 200),
        Cost(CostType.REFUELING, LocalDate.of(2022, 4, 24), 400),
        Cost(CostType.TICKET, LocalDate.of(2022, 4, 3), 300),
        Cost(CostType.REFUELING, LocalDate.of(2022, 2, 20), 300)
    )

    private val groupedCostMap: Map<String, List<Cost>> = generalCosts.groupBy { it.date.month.toString() }

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