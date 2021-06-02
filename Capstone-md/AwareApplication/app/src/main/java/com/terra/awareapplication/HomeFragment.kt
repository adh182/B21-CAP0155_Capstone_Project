package com.terra.awareapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.terra.awareapplication.adapter.PostAdapter
import com.terra.awareapplication.databinding.FragmentHomeBinding
import com.terra.awareapplication.repositories.models.MyPredictionRequest
import com.terra.awareapplication.repositories.models.MyPredictionResponse
import com.terra.awareapplication.repositories.models.MyTrainResponse
import com.terra.awareapplication.repositories.remotedatasource.RetrofitClient
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
            Intent(activity, ResultPredicitonActivity::class.java).also {
                createPost()
                startActivity(it)
            }
        }
    }

    private fun createPost() {

        RetrofitClient.instance.prediction(
            MyPredictionRequest(
//                binding.geoLevel1.text.toString().toInt(),
//                binding.geoLevel2.text.toString().toInt(),
//                binding.geoLevel3.text.toString().toInt(),
//                binding.countFloorsPreEq.text.toString().toInt(),
//                binding.age.text.toString().toInt(),
//                binding.areaPercentage.text.toString().toInt(),
//                binding.heightPercentage.text.toString().toInt(),
//                binding.landSurfaceCondition.text.toString(),
//                binding.foundationType.text.toString(),
//                binding.roofType.text.toString(),
//                binding.groundFloorType.text.toString(),
//                binding.otherFloorType.text.toString(),
//                binding.position.text.toString(),
//                binding.planConfiguration.text.toString(),
//                true,
//                false,
//                false,
//                true,
//                false,
//                true,
//                false,
//                false,
//                true,
//                false,
//                true,
//                binding.ownershipStatus.text.toString(),
//                binding.countFamilies.text.toString().toInt(),
//                false,
//                false,
//                false,
//                true,
//                false,
//                false,
//                false,
//                false,
//                false,
//                true,
//                false

                1,
                2,
                3,
                6,
                47,
                14,
                13,
                "n",
                "h",
                "n",
                "f",
                "j",
                "o",
                "a",
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
                "a",
                10,
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
//            override fun onResponse(
//                call: Call<MyPredictionRequest>,
//                response: Response<MyPredictionRequest>
//            ) {
//                val responseText = "Response code : ${response.code()}\n" +
//                        "Age: ${response.body()?.age}\n"
//                        "geo level 2 id: ${response.body()?.text}\n" +
//                        "geo level 3 id: ${response.body()?.userId}\n" +
//                        "Count Floors Pre Eq: ${response.body()?.id}\n"
//                binding.tvResponeCode.text = responseText
//            }
//
//            override fun onFailure(call: Call<MyPredictionRequest>, t: Throwable) {
//                binding.tvResponeCode.text = t.message
//            }

            override fun onResponse(
                call: Call<MyPredictionResponse>,
                response: Response<MyPredictionResponse>
            ) {
                val responseText = "Response code : ${response.code()}\n" +
                        "geo_level_1_id: ${response.body()?.geoLevel1Id}\n"+
                        "geo_level_2_id: ${response.body()?.geoLevel2Id}\n"+
                        "geo_level_3_id: ${response.body()?.geoLevel3Id}\n"+
                        "count_floors_pre_eq: ${response.body()?.countFloorsPreEq}\n"+
                        "Age: ${response.body()?.age}\n"+
                        "area_percentage: ${response.body()?.areaPercentage}\n"+
                        "height_percentage: ${response.body()?.heightPercentage}\n"+
                        "land_surface_condition: ${response.body()?.landSurfaceCondition}\n"+
                        "foundation_type: ${response.body()?.foundationType}\n"+
                        "ground_floor_type: ${response.body()?.groundFloorType}\n"+
                        "other_floor_type: ${response.body()?.otherFloorType}\n"+
                        "position: ${response.body()?.position}\n"+
                        "plan_configuration: ${response.body()?.planConfiguration}\n"+
                        "has_superstructure_adobe_mud: ${response.body()?.hasSuperstructureAdobeMud}\n"+
                        "has_superstructure_mud_mortar_stone: ${response.body()?.hasSuperstructureMudMortarStone}\n"+
                        "has_superstructure_stone_flag: ${response.body()?.hasSuperstructureStoneFlag}\n"+
                        "has_superstructure_cement_mortar_stone: ${response.body()?.hasSuperstructureCementMortarStone}\n"+
                        "has_superstructure_mud_mortar_brick: ${response.body()?.hasSuperstructureMudMortarBrick}\n"+
                        "has_superstructure_cement_mortar_brick: ${response.body()?.hasSuperstructureCementMortarBrick}\n"+
                        "has_superstructure_timber: ${response.body()?.hasSuperstructureTimber}\n"+
                        "has_superstructure_bamboo: ${response.body()?.hasSuperstructureBamboo}\n"+
                        "has_superstructure_rc_non_engineered: ${response.body()?.hasSuperstructureRcNonEngineered}\n"+
                        "has_superstructure_rc_engineered: ${response.body()?.hasSuperstructureRcEngineered}\n"+
                        "has_superstructure_other: ${response.body()?.hasSuperstructureOther}\n"+
                        "legal_ownership_status: ${response.body()?.legalOwnershipStatus}\n"+
                        "count_families: ${response.body()?.countFamilies}\n"+
                        "has_secondary_use: ${response.body()?.hasSecondaryUse}\n"+
                        "has_secondary_use_agriculture: ${response.body()?.hasSecondaryUseAgriculture}\n"+
                        "has_secondary_use_hotel: ${response.body()?.hasSecondaryUseHotel}\n"+
                        "has_secondary_use_rental: ${response.body()?.hasSecondaryUseRental}\n"+
                        "has_secondary_use_institution: ${response.body()?.hasSecondaryUseInstitution}\n"+
                        "has_secondary_use_school: ${response.body()?.hasSecondaryUseSchool}\n"+
                        "has_secondary_use_industry: ${response.body()?.hasSecondaryUseIndustry}\n"+
                        "has_secondary_use_health_post: ${response.body()?.hasSecondaryUseHealthPost}\n"+
                        "has_secondary_use_gov_office: ${response.body()?.hasSecondaryUseGovOffice}\n"+
                        "has_secondary_use_use_police: ${response.body()?.hasSecondaryUseUsePolice}\n"+
                        "has_secondary_use_other: ${response.body()?.hasSecondaryUseOther}\n"
                binding.tvResponeCode.text = responseText
            }

            override fun onFailure(call: Call<MyPredictionResponse>, t: Throwable) {
                binding.tvResponeCode.text = t.message
            }
        })
    }

}