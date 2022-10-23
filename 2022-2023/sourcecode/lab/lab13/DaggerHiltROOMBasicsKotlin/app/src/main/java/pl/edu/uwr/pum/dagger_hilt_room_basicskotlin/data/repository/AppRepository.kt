package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.repository

import androidx.lifecycle.LiveData
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.db.AppDao
import javax.inject.Inject

class AppRepository @Inject constructor (private val appDao: AppDao) {
    val readAllData: LiveData<List<Student>> = appDao.readAllData()
    suspend fun insert(student: Student) = appDao.addItem(student)
}