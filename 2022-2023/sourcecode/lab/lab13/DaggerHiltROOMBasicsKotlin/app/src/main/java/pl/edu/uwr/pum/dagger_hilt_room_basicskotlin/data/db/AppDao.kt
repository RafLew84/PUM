package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(student: Student)

    @Query("SELECT * FROM student")
    fun readAllData(): LiveData<List<Student>>
}