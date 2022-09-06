package pl.udu.uwr.pum.mvvmbasicskotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var _myData: MutableLiveData<String> = MutableLiveData()
    val myData: LiveData<String> = _myData

    private fun getModel(): Model {
        return Model("text", 1, 2)
    }

    init {
        _myData.value = getModel().getData()
    }
}