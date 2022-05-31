package pl.edu.uwr.pum.wfiappkotlin
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Institute(
    val title: String,
    val info: String,
    val imageResource: Int // identyfikatory są przechowywane jako int
) : Parcelable