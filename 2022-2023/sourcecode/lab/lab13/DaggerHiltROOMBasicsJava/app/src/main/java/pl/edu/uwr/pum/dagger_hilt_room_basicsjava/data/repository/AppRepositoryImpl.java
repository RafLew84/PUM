package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.db.AppDao;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.domain.repository.AppRepository;

public class AppRepositoryImpl implements AppRepository {

    private final AppDao appDao;

    @Inject
    public AppRepositoryImpl(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    public LiveData<List<Student>> readAllData() {
        return appDao.readAllData();
    }

    @Override
    public void insert(Student student) {
        appDao.addItem(student);
    }
}
