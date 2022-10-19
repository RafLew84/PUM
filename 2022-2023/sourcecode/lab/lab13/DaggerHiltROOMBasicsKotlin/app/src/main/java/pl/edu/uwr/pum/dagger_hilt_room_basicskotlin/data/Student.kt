package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val name: String)