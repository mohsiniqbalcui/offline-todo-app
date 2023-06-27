package com.familyaura.todo.ui.sell

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.familyaura.todo.data.BuyData
import com.familyaura.todo.database.StoreDatabase
import com.familyaura.todo.repositories.UserAppRepository

class SellViewModel(application: Application) : AndroidViewModel(application) {

    val sellData: LiveData<List<BuyData>>

    private var repository: UserAppRepository

    init {
        val sellDao = StoreDatabase.getDatabase(application).sellDao()
        repository = UserAppRepository(sellDao)
        sellData = repository.getBuyData()
    }



}