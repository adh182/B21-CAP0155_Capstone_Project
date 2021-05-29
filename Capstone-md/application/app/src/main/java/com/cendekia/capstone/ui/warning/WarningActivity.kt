package com.cendekia.capstone.ui.warning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cendekia.capstone.R
import com.cendekia.capstone.data.source.models.MyPredictionRequest
import com.cendekia.capstone.data.source.models.MyPredictionResponse
import com.cendekia.capstone.data.source.models.MyTrainResponse
import com.cendekia.capstone.data.source.remotedatasource.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WarningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warning)
    }


}