package pl.edu.uwr.pum.myfinanceappkotlin.data

import android.graphics.Color

object DataProvider {
    val accounts = listOf(
        Accounts("Home savings", "1111111111", 23456, Color.CYAN),
        Accounts("Car savings", "2222222222", 126578, Color.LTGRAY),
        Accounts("Vacation", "3457733323", 9875, Color.MAGENTA),
        Accounts("Emergency", "9488344443", 10000, Color.RED),
        Accounts("Healthcare", "3243554434", 12345, Color.YELLOW)
    )
}