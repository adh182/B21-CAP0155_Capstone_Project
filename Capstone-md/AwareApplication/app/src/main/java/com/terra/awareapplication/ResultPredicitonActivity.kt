package com.terra.awareapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.terra.awareapplication.adapter.PostAdapter
import com.terra.awareapplication.databinding.ActivityResultPredicitonBinding
import com.terra.awareapplication.repositories.models.MyTrainResponse
import com.terra.awareapplication.repositories.remotedatasource.RetrofitClient
import com.terra.awareapplication.viewmodel.ResultViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultPredicitonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultPredicitonBinding
    private val list = ArrayList<MyTrainResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultPredicitonBinding.inflate(layoutInflater)
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
            rvPost.layoutManager = LinearLayoutManager(this@ResultPredicitonActivity)
        }
    }

}