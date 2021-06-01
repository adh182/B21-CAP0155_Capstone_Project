package com.cendekia.capstone.data.source.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MyPredictionRequest(

    @field:SerializedName("geo_level_1_id")
    val geoLevel1Id: Int,

    @field:SerializedName("geo_level_2_id")
    val geoLevel2Id: Int,

    @field:SerializedName("geo_level_3_id")
    val geoLevel3Id: Int,

    @field:SerializedName("count_floors_pre_eq")
    val countFloorsPreEq: Int,

    @field:SerializedName("age")
    val age: Int,

    @field:SerializedName("area_percentage")
    val areaPercentage: Int,

    @field:SerializedName("height_percentage")
    val heightPercentage: Int,

    @field:SerializedName("land_surface_condition")
    val landSurfaceCondition: String,

    @field:SerializedName("foundation_type")
    val foundationType: String,

    @field:SerializedName("roof_type")
    val roofType: String,

    @field:SerializedName("ground_floor_type")
    val groundFloorType: String,

    @field:SerializedName("other_floor_type")
    val otherFloorType: String,

    @field:SerializedName("plan_configuration")
    val planConfiguration: String,

    @field:SerializedName("position")
    val position: String,

    @field:SerializedName("has_superstructure_adobe_mud")
    val hasSuperstructureAdobeMud: Boolean,

    @field:SerializedName("has_superstructure_mud_mortar_stone")
    val hasSuperstructureMudMortarStone: Boolean,

    @field:SerializedName("has_superstructure_stone_flag")
    val hasSuperstructureStoneFlag: Boolean,

    @field:SerializedName("has_superstructure_cement_mortar_stone")
    val hasSuperstructureCementMortarStone: Boolean,

    @field:SerializedName("has_superstructure_mud_mortar_brick")
    val hasSuperstructureMudMortarBrick: Boolean,

    @field:SerializedName("has_superstructure_cement_mortar_brick")
    val hasSuperstructureCementMortarBrick: Boolean,

    @field:SerializedName("has_superstructure_timber")
    val hasSuperstructureTimber: Boolean,

    @field:SerializedName("has_superstructure_bamboo")
    val hasSuperstructureBamboo: Boolean,

    @field:SerializedName("has_superstructure_rc_non_engineered")
    val hasSuperstructureRcNonEngineered: Boolean,

    @field:SerializedName("has_superstructure_rc_engineered")
    val hasSuperstructureRcEngineered: Boolean,

    @field:SerializedName("has_superstructure_other")
    val hasSuperstructureOther: Boolean,

    @field:SerializedName("legal_ownership_status")
    val legalOwnershipStatus: String,

    @field:SerializedName("count_families")
    val countFamilies: Int,

    @field:SerializedName("has_secondary_use")
    val hasSecondaryUse: Boolean,

    @field:SerializedName("has_secondary_use_agriculture")
    val hasSecondaryUseAgriculture: Boolean,

    @field:SerializedName("has_secondary_use_hotel")
    val hasSecondaryUseHotel: Boolean,

    @field:SerializedName("has_secondary_use_rental")
    val hasSecondaryUseRental: Boolean,

    @field:SerializedName("has_secondary_use_institution")
    val hasSecondaryUseInstitution: Boolean,

    @field:SerializedName("has_secondary_use_school")
    val hasSecondaryUseSchool: Boolean,

    @field:SerializedName("has_secondary_use_industry")
    val hasSecondaryUseIndustry: Boolean,

    @field:SerializedName("has_secondary_use_health_post")
    val hasSecondaryUseHealthPost: Boolean,

    @field:SerializedName("has_secondary_use_gov_office")
    val hasSecondaryUseGovOffice: Boolean,

    @field:SerializedName("has_secondary_use_use_police")
    val hasSecondaryUseUsePolice: Boolean,

    @field:SerializedName("has_secondary_use_other")
    val hasSecondaryUseOther: Boolean
) : Parcelable