package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db.AppDao;
public class AppRepository {

    private final AppDao appDao;

    @Inject
    public AppRepository(AppDao appDao) {
        this.appDao = appDao;
    }

    public LiveData<List<Student>> readAllData() {
        return appDao.readAllData();
    }

    public void insert(Student student) {
        appDao.addItem(student);
    }
}
