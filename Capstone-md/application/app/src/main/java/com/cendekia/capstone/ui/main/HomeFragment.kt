package com.cendekia.capstone.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
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
                false,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                binding.ownershipStatus.text.toString(),
                binding.countFamilies.text.toString().toInt(),
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false
            )
        )
    }

}