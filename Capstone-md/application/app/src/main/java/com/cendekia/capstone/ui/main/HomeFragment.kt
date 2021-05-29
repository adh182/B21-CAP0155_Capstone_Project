package com.cendekia.capstone.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cendekia.capstone.R
import com.cendekia.capstone.adapter.PostAdapter
import com.cendekia.capstone.data.source.models.MyPredictionResponse
import com.cendekia.capstone.data.source.models.MyTrainResponse
import com.cendekia.capstone.data.source.remotedatasource.RetrofitClient
import com.cendekia.capstone.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val list = ArrayList<MyTrainResponse>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        showPost()
        createPost()

    }

    private fun createPost() {
        RetrofitClient.instance.prediction(
            29,
            "Retrofit Tutorial",
            "Retrofit tutorial for beginner"
        ).enqueue(object : Callback<MyPredictionResponse> {

            override fun onResponse(
                call: Call<MyPredictionResponse>,
                response: Response<MyPredictionResponse>
            ) {
                val responseText = "Response code : ${response.code()}\n" +
                        "geo level 1 id: ${response.body()?.tittle}\n" +
                        "geo level 2 id: ${response.body()?.text}\n" +
                        "geo level 3 id: ${response.body()?.userId}\n" +
                        "Count Floors Pre Eq: ${response.body()?.id}\n"
                binding.tvResponeCode.text = responseText
            }

            override fun onFailure(call: Call<MyPredictionResponse>, t: Throwable) {
                binding.tvResponeCode.text = t.message
            }
        })
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
//                response.body()?.let { list.addAll(it) }
//                val adapter = PostAdapter(list)
//                binding.rvPost.adapter = adapter
//                Log.e("data", response.body().toString())
            }

            override fun onFailure(call: Call<ArrayList<MyTrainResponse>>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
            }
        })

        binding.apply {
            rvPost.setHasFixedSize(true)
            rvPost.layoutManager = LinearLayoutManager(context)
        }
    }


}