package pl.edu.uwr.pum.roomrelationskotlin.model.entity.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "lectureName"])
data class StudentLectureCrossRef (
    val studentName: String,
    val lectureName: String
        )