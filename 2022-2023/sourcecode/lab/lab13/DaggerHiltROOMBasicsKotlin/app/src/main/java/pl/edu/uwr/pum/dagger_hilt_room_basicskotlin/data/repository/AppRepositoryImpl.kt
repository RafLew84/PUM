package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.repository

import androidx.lifecycle.LiveData
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.db.AppDao
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor (private val appDao: AppDao) : AppRepository {
    override val readAllData: LiveData<List<Student>> = appDao.readAllData()
    override suspend fun insert(student: Student) = appDao.addItem(student)
}