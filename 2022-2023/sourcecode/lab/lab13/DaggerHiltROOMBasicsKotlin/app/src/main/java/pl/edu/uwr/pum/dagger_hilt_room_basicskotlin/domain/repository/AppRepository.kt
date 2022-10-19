package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.domain.repository

import androidx.lifecycle.LiveData
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student

interface AppRepository {
    val readAllData: LiveData<List<Student>>
    suspend fun insert(student: Student)
}