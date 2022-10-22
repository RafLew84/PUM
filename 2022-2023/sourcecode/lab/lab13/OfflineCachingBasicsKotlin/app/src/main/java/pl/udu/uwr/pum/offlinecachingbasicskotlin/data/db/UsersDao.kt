package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.User

@Dao
interface UsersDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(user: List<User>)

    @Query("DELETE FROM users")
    suspend fun clear()

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<User>>
}