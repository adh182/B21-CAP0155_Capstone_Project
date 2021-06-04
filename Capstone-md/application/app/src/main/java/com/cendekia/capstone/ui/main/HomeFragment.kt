package com.cendekia.capstone.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cendekia.capstone.data.source.models.MyPredictionRequest
import com.cendekia.capstone.data.source.models.MyPredictionResponse
import com.cendekia.capstone.data.source.remotedatasource.RetrofitClient
import com.cendekia.capstone.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

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
            val geoLevel1 = binding.geoLevel1.text.toString().trim()
            val geoLevel2 = binding.geoLevel2.text.toString().trim()
            val geoLevel3 = binding.geoLevel2.text.toString().trim()
            val countFloors = binding.geoLevel2.text.toString().trim()
            val age = binding.geoLevel2.text.toString().trim()
            val areaPercentage = binding.areaPercentage.toString().trim()
            val heightPercentage = binding.heightPercentage.toString().trim()
            val landSurfaceCondition = binding.landSurfaceCondition.toString().trim()
            val foundationType = binding.foundationType.toString().trim()
            val roofType = binding.roofType.toString().trim()
            val groundFloorType = binding.groundFloorType.toString().trim()
            val otherFloorType = binding.otherFloorType.toString().trim()
            val position = binding.position.toString().trim()
            val planConfiguration = binding.planConfiguration.toString().trim()
            val legalOwnership = binding.ownershipStatus.toString().trim()
            val countFamilies = binding.countFamilies.toString().trim()


            if (geoLevel1.isEmpty()) {
                binding.geoLevel1.error = "Geo Level 1 must be filled"
                binding.geoLevel1.requestFocus()
                return@setOnClickListener
            }

            if (geoLevel2.isEmpty()) {
                binding.geoLevel2.error = "Geo Level 2 must be filled"
                binding.geoLevel2.requestFocus()
                return@setOnClickListener
            }

            if (geoLevel3.isEmpty()) {
                binding.geoLevel3.error = "Geo Level 3 must be filled"
                binding.geoLevel3.requestFocus()
                return@setOnClickListener
            }

            if (countFloors.isEmpty()) {
                binding.countFloorsPreEq.error = "Number of floors must be filled"
                binding.countFloorsPreEq.requestFocus()
                return@setOnClickListener
            }

            if (age.isEmpty()) {
                binding.age.error = "Age of the building must be filled"
                binding.age.requestFocus()
                return@setOnClickListener
            }

            if (areaPercentage.isEmpty()) {
                binding.areaPercentage.error = "Building Area must be filled"
                binding.areaPercentage.requestFocus()
                return@setOnClickListener
            }

            if (heightPercentage.isEmpty()) {
                binding.heightPercentage.error = "Building Height must be filled"
                binding.heightPercentage.requestFocus()
                return@setOnClickListener
            }

            if (landSurfaceCondition.isEmpty()) {
                binding.landSurfaceCondition.error = "Surface condition must be filled"
                binding.landSurfaceCondition.requestFocus()
                return@setOnClickListener
            }

            if (foundationType.isEmpty()) {
                binding.foundationType.error = "Type of foundation must be filled"
                binding.foundationType.requestFocus()
                return@setOnClickListener
            }

            if (roofType.isEmpty()) {
                binding.roofType.error = "Type of roof  must be filled"
                binding.roofType.requestFocus()
                return@setOnClickListener
            }

            if (groundFloorType.isEmpty()) {
                binding.groundFloorType.error = "Type of the ground floor must be filled"
                binding.groundFloorType.requestFocus()
                return@setOnClickListener
            }

            if (otherFloorType.isEmpty()) {
                binding.otherFloorType.error = "Type of constructions must be filled"
                binding.otherFloorType.requestFocus()
                return@setOnClickListener
            }

            if (position.isEmpty()) {
                binding.position.error = "Position of the building must be filled"
                binding.position.requestFocus()
                return@setOnClickListener
            }

            if (planConfiguration.isEmpty()) {
                binding.planConfiguration.error = "Building plan configuration must be filled"
                binding.planConfiguration.requestFocus()
                return@setOnClickListener
            }

            if (legalOwnership.isEmpty()) {
                binding.ownershipStatus.error = "Legal ownership status must be filled"
                binding.ownershipStatus.requestFocus()
                return@setOnClickListener
            }

            if (countFamilies.isEmpty()) {
                binding.countFamilies.error = "Number of People must be filled"
                binding.countFamilies.requestFocus()
                return@setOnClickListener
            }

            Intent(activity, ResultPredictionActivity::class.java).also {
                createPost()
                startActivity(it)
            }
        }
    }

    private fun createPost() {
        val adobeMud = binding.adobeMud
        val mudMortarStone = binding.MudMortarStone
        val stoneFlag = binding.StoneFlag
        val cementMortarStone = binding.CementMortar
        val mudMortarBrick = binding.MudMortarBrick
        val cementMortarBrick = binding.CementMortarBrick
        val timber = binding.Timber
        val bamboo = binding.Bamboo
        val rcNonEngineered = binding.rcNonEngineered
        val rcEngineered = binding.rcEngineered
        val other = binding.other
        val use = binding.hasSecondary
        val agriculture = binding.hasSecondaryAgriculture
        val hotel = binding.hasSecondaryHotel
        val rental = binding.hasSecondaryRental
        val institution = binding.hasSecondaryInstitution
        val school = binding.hasSecondarySchool
        val industry = binding.hasSecondaryIndustry
        val health = binding.hasSecondaryHealthPost
        val govOffice = binding.hasSecondaryGovOffice
        val police = binding.hasSecondaryPolice
        val useOther = binding.hasSecondaryUseOther

        val intSelectAdobeMud: Int = adobeMud.checkedRadioButtonId
        val intSelectMudMortarStone: Int = mudMortarStone.checkedRadioButtonId
        val intSelectStoneFlag: Int = stoneFlag.checkedRadioButtonId
        val intSelectCementMortarStone: Int = cementMortarStone.checkedRadioButtonId
        val intSelectMudMortarBrick: Int = mudMortarBrick.checkedRadioButtonId
        val intSelectCementMortarBrick: Int = cementMortarBrick.checkedRadioButtonId
        val intSelectTimber: Int = timber.checkedRadioButtonId
        val intSelectBamboo: Int = bamboo.checkedRadioButtonId
        val intSelectRcNonEngineered: Int = rcNonEngineered.checkedRadioButtonId
        val intSelectRcEngineered: Int = rcEngineered.checkedRadioButtonId
        val intSelectOther: Int = other.checkedRadioButtonId
        val intSelectUse: Int = use.checkedRadioButtonId
        val intSelectAgriculture: Int = agriculture.checkedRadioButtonId
        val intSelectHotel: Int = hotel.checkedRadioButtonId
        val intSelectRental: Int = rental.checkedRadioButtonId
        val intSelectInstitution: Int = institution.checkedRadioButtonId
        val intSelectSchool: Int = school.checkedRadioButtonId
        val intSelectIndustry: Int = industry.checkedRadioButtonId
        val intSelectHealth: Int = health.checkedRadioButtonId
        val intSelectGovOffice: Int = govOffice.checkedRadioButtonId
        val intSelectPolice: Int = police.checkedRadioButtonId
        val intSelectUseOther: Int = useOther.checkedRadioButtonId



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
                intSelectAdobeMud.toString().toBoolean(),
                intSelectMudMortarStone.toString().toBoolean(),
                intSelectStoneFlag.toString().toBoolean(),
                intSelectCementMortarStone.toString().toBoolean(),
                intSelectMudMortarBrick.toString().toBoolean(),
                intSelectCementMortarBrick.toString().toBoolean(),
                intSelectTimber.toString().toBoolean(),
                intSelectBamboo.toString().toBoolean(),
                intSelectRcNonEngineered.toString().toBoolean(),
                intSelectRcEngineered.toString().toBoolean(),
                intSelectOther.toString().toBoolean(),
                binding.ownershipStatus.text.toString(),
                binding.countFamilies.text.toString().toInt(),
                intSelectUseOther.toString().toBoolean(),
                intSelectAgriculture.toString().toBoolean(),
                intSelectHotel.toString().toBoolean(),
                intSelectRental.toString().toBoolean(),
                intSelectInstitution.toString().toBoolean(),
                intSelectSchool.toString().toBoolean(),
                intSelectIndustry.toString().toBoolean(),
                intSelectHealth.toString().toBoolean(),
                intSelectGovOffice.toString().toBoolean(),
                intSelectPolice.toString().toBoolean(),
                intSelectUseOther.toString().toBoolean()
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
                Toast.makeText(
                    activity,
                    "Data Sent Failed, Please Check Your Data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

}