package com.cendekia.capstone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.cendekia.capstone.adapter.PostAdapter
import com.cendekia.capstone.data.source.models.MyTrainResponse
import com.cendekia.capstone.data.source.remotedatasource.RetrofitClient
import com.cendekia.capstone.databinding.ActivityResultPredictionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultPredictionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultPredictionBinding
    private val list = ArrayList<MyTrainResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultPredictionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showPost()
    }

    private fun showPost() {
        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<MyTrainResponse>> {

            override fun onResponse(
                call: Call<ArrayList<MyTrainResponse>>,
                response: Response<ArrayList<MyTrainResponse>>
            ) {
                val responseCode = response.code().toString()
                binding.tvResponeCode.text = responseCode

                val adapter = PostAdapter(list)
                binding.rvPost.adapter = adapter
                adapter.setData(response.body())
            }

            override fun onFailure(call: Call<ArrayList<MyTrainResponse>>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
            }
        })

        binding.apply {
            rvPost.setHasFixedSize(true)
            rvPost.layoutManager = LinearLayoutManager(this@ResultPredictionActivity)
        }
    }

}