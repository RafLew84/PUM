package pl.udu.uwr.pum.shoppyjava.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pl.udu.uwr.pum.shoppyjava.data.ItemDatabase;
import pl.udu.uwr.pum.shoppyjava.model.Item;
import pl.udu.uwr.pum.shoppyjava.repository.ItemRepository;

public class ItemViewModel extends AndroidViewModel {

    private final ItemRepository repository;

    private final LiveData<List<Item>> readAllData;

    public void update(Item item){
        ItemDatabase.databaseWriteExecutor.execute(() -> repository.update(item));
    }

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        readAllData = repository.ReadAllData();
    }

    public LiveData<List<Item>> getAllData() {
        return readAllData;
    }

    public LiveData<Item> getItem(int id){
        return repository.getItem(id);
    }

    public void insert(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> repository.insert(item));
    }

    public void delete(Item item){
        ItemDatabase.databaseWriteExecutor.execute(() -> repository.delete(item));
    }
}
