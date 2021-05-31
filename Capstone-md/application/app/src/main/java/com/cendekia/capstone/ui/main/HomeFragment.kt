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

        showPost()
        createPost()

    }

    private fun createPost() {
        RetrofitClient.instance.prediction(
//            29,
//            "Retrofit Tutorial",
//            "Retrofit tutorial for beginner"
            MyPredictionRequest(
                1, 2, 3,
                6,
                15, 14,
                13,
                "n",
                "h",
                "n",
                "f","j",
                "o","a", true,false,
                false,true,false,
                true,false,false,
                true,false,true,
                "a",10,false,true,
                true,false,true,
                false,
                false,true,false,
                true,false
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