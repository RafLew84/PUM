package pl.edu.uwr.pum.myfinanceappkotlin.util

import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.format.DateTimeFormatter

val formatter: NumberFormat = DecimalFormat("#,###.##")
val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd")
