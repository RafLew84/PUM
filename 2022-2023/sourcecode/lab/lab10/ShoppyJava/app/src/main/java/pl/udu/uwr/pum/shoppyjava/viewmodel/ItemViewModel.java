package pl.udu.uwr.pum.shoppyjava.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pl.udu.uwr.pum.shoppyjava.data.Item;
import pl.udu.uwr.pum.shoppyjava.repository.ItemRepository;

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
