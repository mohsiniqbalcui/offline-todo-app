package com.familyaura.todo.ui.buy

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.familyaura.todo.data.BuyData
import com.familyaura.todo.database.StoreDatabase
import com.familyaura.todo.repositories.UserAppRepository
import com.familyaura.todo.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuyViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserAppRepository
    private val _buyData = MutableLiveData<List<BuyData>>()
    val buyData: LiveData<List<BuyData>> = _buyData

    init {
        val sellDao = StoreDatabase.getDatabase(application).sellDao()
        repository = UserAppRepository(sellDao)
    }

    fun getBuyData() {
        viewModelScope.launch(Dispatchers.IO) {

            val call = RetrofitClient.apiInterface.getBuy()
            call.enqueue(object : Callback<ArrayList<BuyData>> {
                override fun onResponse(
                    call: Call<ArrayList<BuyData>>,
                    response: Response<ArrayList<BuyData>>
                ) {
                    if (!response.isSuccessful && response.body() == null) {
                        return
                    }
                    response.body()?.let { updateOrCreateAll(it) }
                    _buyData.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<BuyData>>, t: Throwable) {
                    t.printStackTrace()
                    call.cancel()
                }
            })
        }
    }

    fun updateOrCreateAll(kins: ArrayList<BuyData>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateOrCreate(kins)
        }
    }

}