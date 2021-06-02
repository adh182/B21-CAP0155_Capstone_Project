package com.terra.awareapplication.repositories.remotedatasource

import com.terra.awareapplication.repositories.models.MyPredictionRequest
import com.terra.awareapplication.repositories.models.MyPredictionResponse
import com.terra.awareapplication.repositories.models.MyTrainResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @Headers("Content-Type: application/json")
    @POST("api/prediction/")
    fun prediction(@Body body: MyPredictionRequest): Call<MyPredictionResponse>

    @GET("api/train/")
    fun getPosts(): Call<ArrayList<MyTrainResponse>>
}