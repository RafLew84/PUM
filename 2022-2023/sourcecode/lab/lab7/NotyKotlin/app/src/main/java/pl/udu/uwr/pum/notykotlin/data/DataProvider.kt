package pl.udu.uwr.pum.notykotlin.data

import pl.udu.uwr.pum.notykotlin.model.NoteModel
import java.time.LocalTime
import java.util.*

object DataProvider {
    private val data = arrayOf(
        "notatka 1",
        "notatka 2",
        "notatka 3",
        "notatka 4",
        "notatka 5",
        "notatka 6",
        "notatka 7",
        "notatka 8",
        "notatka 9"
    )
    var s = "12:11"
    var localTime = LocalTime.parse(s)

    var dummyData = ArrayList(listOf(*data))

    val notes: List<NoteModel> = listOf(
        NoteModel("notatka 1", LocalTime.of(12, 0)),
        NoteModel("notatka 2", LocalTime.of(13, 0)),
        NoteModel("notatka 3", LocalTime.of(21, 0)),
        NoteModel("notatka 4", LocalTime.of(9, 9)),
        NoteModel("notatka 5", LocalTime.of(22, 34)),
        NoteModel("notatka 6", LocalTime.of(11, 22)),
        NoteModel("notatka 7", localTime)
    )
}