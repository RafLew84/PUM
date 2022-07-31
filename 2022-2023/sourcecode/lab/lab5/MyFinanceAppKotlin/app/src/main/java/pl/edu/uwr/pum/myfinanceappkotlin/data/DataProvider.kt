package pl.edu.uwr.pum.myfinanceappkotlin.data

import android.graphics.Color

object DataProvider {
    val accounts = listOf(
        Accounts("Home savings", "1111111111", 23456.34, Color.BLUE),
        Accounts("Car savings", "2222222222", 126578.99, Color.LTGRAY),
        Accounts("Vacation", "3457733323", 9875.12, Color.MAGENTA),
        Accounts("Emergency", "9488344443", 10000.77, Color.RED),
        Accounts("Healthcare", "3243554434", 12345.00, Color.YELLOW),
        Accounts("Shopping", "2947560007", 3456.56, Color.BLACK)
    )

    val totalAmount = (accounts.indices).sumOf { accounts[it].amount }
}