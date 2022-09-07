package pl.udu.uwr.pum.shoppykotlin.repository

import androidx.lifecycle.LiveData
import pl.udu.uwr.pum.shoppykotlin.model.Item
import pl.udu.uwr.pum.shoppykotlin.data.ItemDao

class ItemRepository(private val itemDao: ItemDao) {
    val readAllData: LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item){
        itemDao.addItem(item)
    }

    fun getItem(id: Int): LiveData<Item>{
        return itemDao.getItem(id)
    }

    suspend fun updateItem(item: Item){
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: Item){
        itemDao.deleteItem(item)
    }

    suspend fun deleteAllItems(){
        itemDao.deleteAllItems()
    }

    fun searchItem(query: String): LiveData<List<Item>>{
        return itemDao.search(query)
    }
}