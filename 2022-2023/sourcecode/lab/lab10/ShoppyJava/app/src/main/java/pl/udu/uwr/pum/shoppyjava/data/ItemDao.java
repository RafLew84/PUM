package pl.udu.uwr.pum.shoppyjava.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addItem(Item item);

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    LiveData<List<Item>> readAllData();
}
