package pl.udu.uwr.pum.shoppykotlin.repository

import androidx.lifecycle.LiveData
import pl.udu.uwr.pum.shoppykotlin.data.Item
import pl.udu.uwr.pum.shoppykotlin.data.ItemDao

class ItemRepository(private val itemDao: ItemDao) {
    val readAllData: LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item){
        itemDao.addItem(item)
    }
}