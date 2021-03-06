package com.cendekia.capstone.data.source.remotedatasource

import com.cendekia.capstone.data.source.models.MyPredictionRequest
import com.cendekia.capstone.data.source.models.MyPredictionResponse
import com.cendekia.capstone.data.source.models.MyTrainResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @Headers("Content-Type: application/json")
    @POST("api/prediction/")
    fun prediction(@Body body: MyPredictionRequest): Call<MyPredictionResponse>

    @GET("api/train/")
    fun getPosts(): Call<ArrayList<MyTrainResponse>>
}