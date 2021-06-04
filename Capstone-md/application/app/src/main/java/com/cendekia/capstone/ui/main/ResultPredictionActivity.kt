package com.cendekia.capstone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
        showLoading(true)
        showPost()
    }

    private fun showPost() {
        binding.apply {
            rvPost.setHasFixedSize(true)
            rvPost.layoutManager = LinearLayoutManager(this@ResultPredictionActivity)
        }
        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<MyTrainResponse>> {

            override fun onResponse(
                call: Call<ArrayList<MyTrainResponse>>,
                response: Response<ArrayList<MyTrainResponse>>
            ) {
                val responseCode = response.code().toString()
                binding.tvResponeCode.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                binding.rvPost.adapter = adapter
                showLoading(false)
            }

            override fun onFailure(call: Call<ArrayList<MyTrainResponse>>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}