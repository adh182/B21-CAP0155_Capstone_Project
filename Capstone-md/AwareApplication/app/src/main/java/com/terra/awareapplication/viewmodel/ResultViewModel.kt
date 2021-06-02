package com.terra.awareapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.terra.awareapplication.repositories.models.MyTrainResponse

class ResultViewModel {
    val data = MutableLiveData<MyTrainResponse>()

    fun getDataResult(): LiveData<MyTrainResponse> {
        return data
    }
}