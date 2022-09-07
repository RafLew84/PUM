package pl.udu.uwr.pum.shoppyjava.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.udu.uwr.pum.shoppyjava.model.Item;
import pl.udu.uwr.pum.shoppyjava.data.ItemDao;
import pl.udu.uwr.pum.shoppyjava.data.ItemDatabase;

public class ItemRepository {

    private final ItemDao itemDao;
    private final LiveData<List<Item>> readAllData;

    public ItemRepository(Application application){
        ItemDatabase db = ItemDatabase.getDatabase(application);
        itemDao = db.itemDao();
        readAllData = itemDao.readAllData();
    }

    public void insert(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> itemDao.addItem(item));
    }

    public LiveData<List<Item>> ReadAllData() {
        return readAllData;
    }

    public LiveData<Item> getItem(int id){
        return itemDao.getItem(id);
    }

    public void update(Item item){
        ItemDatabase.databaseWriteExecutor.execute(() -> itemDao.updateItem(item));
    }
}