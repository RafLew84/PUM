package pl.edu.uwr.pum.myfinanceappkotlin.data

import android.graphics.Color
import java.time.LocalDate

object DataProvider {
    val accounts = listOf(
        Account("Home savings", "1111111111", 23456.34, Color.BLUE),
        Account("Car savings", "2222222222", 126578.99, Color.LTGRAY),
        Account("Vacation", "3457733323", 9875.12, Color.MAGENTA),
        Account("Emergency", "9488344443", 10000.77, Color.RED),
        Account("Healthcare", "3243554434", 12345.00, Color.YELLOW),
        Account("Shopping", "2947560007", 3456.56, Color.BLACK)
    )

    val bills = listOf(
        Bill("Bank Credit", LocalDate.of(2022, 9,22), 2300.0, Color.BLACK),
        Bill("Tuition", LocalDate.of(2023, 2,10), 1200.0, Color.BLUE),
        Bill("Rent", LocalDate.of(2022, 8,3), 1023.87, Color.YELLOW),
        Bill("Loan", LocalDate.of(2022, 12,22), 334.0, Color.GRAY),
        Bill("Car Repair", LocalDate.of(2023, 1,9), 982.33, Color.WHITE),
        Bill("Dress Loan", LocalDate.of(2023, 5,18), 243.0, Color.MAGENTA),
    )

    val totalAccountsAmount = (accounts.indices).sumOf { accounts[it].amount }
    val totalBillsAmount = (bills.indices).sumOf { bills[it].amount }
}