package pl.udu.uwr.pum.notykotlin.model

import android.graphics.Color
import java.time.LocalTime

class NoteModel(var textNote: String, val time: LocalTime) {
    var id = 0
        private set
    var color = Color.BLACK

    constructor(id: Int, textNote: String, time: LocalTime, color: Int) : this(textNote, time) {
        this.id = id
        this.color = color
    }

}
