package com.familyaura.todo.retrofit

import com.familyaura.todo.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofitClient: Retrofit.Builder by lazy {

//        val levelType: Level = if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
//            Level.BODY else Level.NONE

//        val logging = HttpLoggingInterceptor()
//        logging.level = levelType
//
//        val okhttpClient = OkHttpClient.Builder()
//        okhttpClient.addInterceptor(logging)
//
//        okhttpClient.addInterceptor(
//            RetrofitInterceptor(
//                "User-Agent",
//                "Name/" + BuildConfig.VERSION_NAME + " (Android; " + "Build:" + BuildConfig.VERSION_CODE + "; " + "SDK:" + Build.VERSION.SDK_INT + ";" + ")"
//            )
//        )

        Retrofit.Builder()
            .baseUrl(BASE_URL)
//            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}
