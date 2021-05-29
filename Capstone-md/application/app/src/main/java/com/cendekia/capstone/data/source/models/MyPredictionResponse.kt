package com.cendekia.capstone.data.source.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyPredictionResponse(

    @field:SerializedName("prediction")
    val prediction: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("geo_level_1_id")
    val geoLevel1Id: Int? = null,

    @field:SerializedName("geo_level_2_id")
    val geoLevel2Id: Int? = null,

    @field:SerializedName("geo_level_3_id")
    val geoLevel3Id: Int? = null,

    @field:SerializedName("count_floors_pre_eq")
    val countFloorsPreEq: Int? = null,

    @field:SerializedName("age")
    val age: Int? = null,

    @field:SerializedName("area_percentage")
    val areaPercentage: Int? = null,

    @field:SerializedName("height_percentage")
    val heightPercentage: Int? = null,

    @field:SerializedName("land_surface_condition")
    val landSurfaceCondition: String? = null,

    @field:SerializedName("foundation_type")
    val foundationType: String? = null,

    @field:SerializedName("roof_type")
    val roofType: String? = null,

    @field:SerializedName("ground_floor_type")
    val groundFloorType: String? = null,

    @field:SerializedName("other_floor_type")
    val otherFloorType: String? = null,

    @field:SerializedName("position")
    val position: String? = null,

    @field:SerializedName("plan_configuration")
    val planConfiguration: String? = null,

    @field:SerializedName("has_superstructure_adobe_mud")
    val hasSuperstructureAdobeMud: Boolean? = null,

    @field:SerializedName("has_superstructure_mud_mortar_stone")
    val hasSuperstructureMudMortarStone: Boolean? = null,

    @field:SerializedName("has_superstructure_stone_flag")
    val hasSuperstructureStoneFlag: Boolean? = null,

    @field:SerializedName("has_superstructure_cement_mortar_stone")
    val hasSuperstructureCementMortarStone: Boolean? = null,

    @field:SerializedName("has_superstructure_mud_mortar_brick")
    val hasSuperstructureMudMortarBrick: Boolean? = null,

    @field:SerializedName("has_superstructure_cement_mortar_brick")
    val hasSuperstructureCementMortarBrick: Boolean? = null,

    @field:SerializedName("has_superstructure_timber")
    val hasSuperstructureTimber: Boolean? = null,

    @field:SerializedName("has_superstructure_bamboo")
    val hasSuperstructureBamboo: Boolean? = null,

    @field:SerializedName("has_superstructure_rc_non_engineered")
    val hasSuperstructureRcNonEngineered: Boolean? = null,

    @field:SerializedName("has_superstructure_rc_engineered")
    val hasSuperstructureRcEngineered: Boolean? = null,

    @field:SerializedName("has_superstructure_other")
    val hasSuperstructureOther: Boolean? = null,

    @field:SerializedName("legal_ownership_status")
    val legalOwnershipStatus: String? = null,

    @field:SerializedName("count_families")
    val countFamilies: Int? = null,

    @field:SerializedName("has_secondary_use")
    val hasSecondaryUse: Boolean? = null,

    @field:SerializedName("has_secondary_use_agriculture")
    val hasSecondaryUseAgriculture: Boolean? = null,

    @field:SerializedName("has_secondary_use_hotel")
    val hasSecondaryUseHotel: Boolean? = null,

    @field:SerializedName("has_secondary_use_rental")
    val hasSecondaryUseRental: Boolean? = null,

    @field:SerializedName("has_secondary_use_institution")
    val hasSecondaryUseInstitution: Boolean? = null,

    @field:SerializedName("has_secondary_use_school")
    val hasSecondaryUseSchool: Boolean? = null,

    @field:SerializedName("has_secondary_use_industry")
    val hasSecondaryUseIndustry: Boolean? = null,

    @field:SerializedName("has_secondary_use_health_post")
    val hasSecondaryUseHealthPost: Boolean? = null,

    @field:SerializedName("has_secondary_use_gov_office")
    val hasSecondaryUseGovOffice: Boolean? = null,

    @field:SerializedName("has_secondary_use_use_police")
    val hasSecondaryUseUsePolice: Boolean? = null,

    @field:SerializedName("has_secondary_use_other")
    val hasSecondaryUseOther: Boolean? = null,
) : Parcelable