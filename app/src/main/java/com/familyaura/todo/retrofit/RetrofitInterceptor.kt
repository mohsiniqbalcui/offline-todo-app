package com.familyaura.todo.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class RetrofitInterceptor(var key: String, var value: String) : Interceptor {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader(key, value).build()
        return chain.proceed(request)
    }
}