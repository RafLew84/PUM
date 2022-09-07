package pl.udu.uwr.pum.shoppykotlin.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Item>>
    private val repository: ItemRepository

    init {
        val itemDao = ItemDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        readAllData = repository.readAllData
    }

    fun addItem(item: Item){
        viewModelScope.launch {
            repository.addItem(item)
        }
    }
}