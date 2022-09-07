package pl.udu.uwr.pum.shoppyjava.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private final ItemRepository repository;

    private final LiveData<List<Item>> readAllData;

    public void insert(Item item) { repository.insert(item); }

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        readAllData = repository.ReadAllData();
    }

    public LiveData<List<Item>> getAllData() {
        return readAllData;
    }
}
