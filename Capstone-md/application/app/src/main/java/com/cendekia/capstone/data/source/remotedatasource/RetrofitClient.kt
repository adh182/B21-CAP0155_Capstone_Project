package com.cendekia.capstone.data.source.remotedatasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://b21-cap0155-capstone-project.et.r.appspot.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiInstance: Api = retrofit.create(Api::class.java)
}