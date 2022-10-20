package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.domain.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;

public interface AppRepository {
    LiveData<List<Student>> readAllData();
    void insert(Student student);
}
