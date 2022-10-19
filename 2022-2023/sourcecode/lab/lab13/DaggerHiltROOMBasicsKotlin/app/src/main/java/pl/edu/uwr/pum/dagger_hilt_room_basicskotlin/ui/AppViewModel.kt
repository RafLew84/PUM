package pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.data.Student
import pl.edu.uwr.pum.dagger_hilt_room_basicskotlin.domain.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    app: Application,
    private  val repository: AppRepository
) : AndroidViewModel(app) {

    val readAllData: LiveData<List<Student>> = repository.readAllData

    fun insert(student: Student) = viewModelScope.launch {
        repository.insert(student)
    }
}