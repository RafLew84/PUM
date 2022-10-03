package pl.udu.uwr.pum.foody.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import pl.udu.uwr.pum.foody.data.Meal

@Dao
interface FoodDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(meal: Meal)

    @Delete
    suspend fun delete(meal: Meal)

    @Query("SELECT * FROM meal")
    fun getAllMeals() : LiveData<List<Meal>>
}