package pl.udu.uwr.pum.carsyappkotlin.util

import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.format.DateTimeFormatter

val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd")
val decimalFormat = DecimalFormat("###,###.##")
