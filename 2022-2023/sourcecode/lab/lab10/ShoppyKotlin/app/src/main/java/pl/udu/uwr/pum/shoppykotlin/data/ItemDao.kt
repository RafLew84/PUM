package pl.udu.uwr.pum.shoppykotlin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item: Item)

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Item>>
}