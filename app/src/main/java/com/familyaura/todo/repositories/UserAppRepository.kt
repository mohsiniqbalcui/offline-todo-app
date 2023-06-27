package com.familyaura.todo.repositories

import androidx.lifecycle.LiveData
import com.familyaura.todo.data.BuyData
import com.familyaura.todo.database.BuyDao

class UserAppRepository(private val buyDao: BuyDao) {
    suspend fun updateOrCreate(buyData: List<BuyData>) {
        buyDao.updateOrCreate(buyData)
    }

   fun getBuyData(): LiveData<List<BuyData>> {
        return buyDao.getData()
    }


}