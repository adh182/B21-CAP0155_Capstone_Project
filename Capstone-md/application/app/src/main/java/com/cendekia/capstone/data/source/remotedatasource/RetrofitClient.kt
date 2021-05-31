package com.cendekia.capstone.data.source.remotedatasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
            private val BASE_URL = "https://django-service-erjjkwrxoa-et.a.run.app/"
//    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}