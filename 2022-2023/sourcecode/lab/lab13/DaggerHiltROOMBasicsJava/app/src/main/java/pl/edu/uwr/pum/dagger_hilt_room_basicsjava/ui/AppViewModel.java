package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db.AppDatabase;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.repository.AppRepository;

@HiltViewModel
public class AppViewModel extends AndroidViewModel {

    private final AppRepository repository;

    @Inject
    public AppViewModel(Application app, AppRepository repository) {
        super(app);
        this.repository = repository;
    }

    LiveData<List<Student>> readAllData(){
        return repository.readAllData();
    }

    void insert(Student student){
        AppDatabase.databaseWriteExecutor.execute(() -> repository.insert(student));
    }
}
