package pl.udu.uwr.pum.shoppykotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.udu.uwr.pum.shoppykotlin.model.Item
import pl.udu.uwr.pum.shoppykotlin.data.ItemDatabase
import pl.udu.uwr.pum.shoppykotlin.repository.ItemRepository

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Item>>
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

    fun getItem(id: Int): LiveData<Item>{
        return repository.getItem(id)
    }

    fun updateItem(item: Item){
        viewModelScope.launch {
            repository.updateItem(item)
        }
    }
}