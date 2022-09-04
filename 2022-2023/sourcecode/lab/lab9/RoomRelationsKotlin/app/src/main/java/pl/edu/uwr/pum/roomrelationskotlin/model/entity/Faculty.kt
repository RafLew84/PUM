package pl.edu.uwr.pum.roomrelationskotlin.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Faculty (
    @PrimaryKey(autoGenerate = false)
    val facultyName: String
        )