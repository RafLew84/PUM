package pl.edu.uwr.pum.myfinanceappkotlin.data

import java.time.LocalDate
import java.util.*

data class Bill (
    val name: String,
    val endDate: LocalDate,
    val amount: Double,
    val color: Int
        )