package pl.edu.uwr.pum.roomrelationskotlin.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student (
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val indexNumber: Int,
    val facultyName: String
        )