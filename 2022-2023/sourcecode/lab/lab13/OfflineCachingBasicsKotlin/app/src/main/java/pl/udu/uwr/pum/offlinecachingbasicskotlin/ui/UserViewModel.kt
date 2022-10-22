package pl.udu.uwr.pum.offlinecachingbasicskotlin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    repository: UserRepository
) : ViewModel() {
    val users = repository.getUsers().asLiveData()
}