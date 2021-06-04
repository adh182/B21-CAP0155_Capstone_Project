package com.cendekia.capstone.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cendekia.capstone.R
import com.cendekia.capstone.adapter.PostAdapter
import com.cendekia.capstone.data.source.models.MyPredictionRequest
import com.cendekia.capstone.data.source.models.MyPredictionResponse
import com.cendekia.capstone.data.source.models.MyTrainResponse
import com.cendekia.capstone.data.source.remotedatasource.RetrofitClient
import com.cendekia.capstone.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    var radioGroup: RadioGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radioGroup = binding.adobeMud

        binding.btnSubmitData.setOnClickListener {
            Intent(activity, ResultPredictionActivity::class.java).also {
                createPost()
                startActivity(it)
            }
        }
    }

    private fun createPost() {

        RetrofitClient.instance.prediction(
            MyPredictionRequest(
                binding.geoLevel1.text.toString().toInt(),
                binding.geoLevel2.text.toString().toInt(),
                binding.geoLevel3.text.toString().toInt(),
                binding.countFloorsPreEq.text.toString().toInt(),
                binding.age.text.toString().toInt(),
                binding.areaPercentage.text.toString().toInt(),
                binding.heightPercentage.text.toString().toInt(),
                binding.landSurfaceCondition.text.toString(),
                binding.foundationType.text.toString(),
                binding.roofType.text.toString(),
                binding.groundFloorType.text.toString(),
                binding.otherFloorType.text.toString(),
                binding.position.text.toString(),
                binding.planConfiguration.text.toString(),
                true,
                false,
                false,
                true,
                false,
                true,
                false,
                false,
                true,
                false,
                true,
                binding.ownershipStatus.text.toString(),
                binding.countFamilies.text.toString().toInt(),
                false,
                true,
                true,
                false,
                true,
                false,
                false,
                true,
                false,
                true,
                false
            )
        ).enqueue(object : Callback<MyPredictionResponse> {
            override fun onResponse(
                call: Call<MyPredictionResponse>,
                response: Response<MyPredictionResponse>
            ) {
                  Toast.makeText(activity, "Data Sent Successfully", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<MyPredictionResponse>, t: Throwable) {
                t.message?.let { Log.d("Failure", it) }
                Toast.makeText(activity, "Data Sent Failed, Please Check Your Data", Toast.LENGTH_SHORT).show()
            }
        })
    }

}