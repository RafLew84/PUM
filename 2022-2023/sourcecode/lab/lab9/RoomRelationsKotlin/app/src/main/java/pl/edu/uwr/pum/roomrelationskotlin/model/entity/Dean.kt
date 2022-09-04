package pl.edu.uwr.pum.roomrelationskotlin.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dean (
    @PrimaryKey(autoGenerate = false)
    val deanName: String,
    val facultyName: String
        )