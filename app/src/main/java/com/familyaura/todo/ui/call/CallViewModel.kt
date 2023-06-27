package com.familyaura.todo.ui.call

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.familyaura.todo.data.CallData
import com.familyaura.todo.retrofit.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallViewModel: ViewModel() {

    private val _callData = MutableLiveData<ArrayList<CallData>>()
    val callData: LiveData<ArrayList<CallData>> = _callData

    fun getCallData() {
        viewModelScope.launch {
        val call = RetrofitClient.apiInterface.getCall()
        call.enqueue(object : Callback<ArrayList<CallData>> {
            override fun onResponse(
                call: Call<ArrayList<CallData>>,
                response: Response<ArrayList<CallData>>
            ) {
                if (!response.isSuccessful && response.body() == null) {
                    return
                }
                _callData.value = response.body()

            }

            override fun onFailure(call: Call<ArrayList<CallData>>, t: Throwable) {
                t.printStackTrace()
                call.cancel()
            }

        })
        }
    }

}