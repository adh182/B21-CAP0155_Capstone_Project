package com.cendekia.capstone.data.source.remotedatasource

import com.cendekia.capstone.data.source.models.MyPredictionRequest
import com.cendekia.capstone.data.source.models.MyPredictionResponse
import com.cendekia.capstone.data.source.models.MyTrainResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("/api/prediction/")
    fun prediction(@Body body: MyPredictionRequest?): Call<MyPredictionResponse?>?

    @GET("/api/train/")
    fun getTrainData(): Call<MyTrainResponse?>?
}