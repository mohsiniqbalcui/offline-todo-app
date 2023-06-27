package com.familyaura.todo.retrofit

import com.familyaura.todo.data.BuyData
import com.familyaura.todo.data.CallData
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("call")
    fun getCall(): Call<ArrayList<CallData>>

    @GET("buy")
    fun getBuy(): Call<ArrayList<BuyData>>

}