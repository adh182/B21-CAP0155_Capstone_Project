# API Contract -  Prediction
- [1) Make a Prediction [POST]](#pred)

<br>

# 1) Make a Prediction - Prediction <a name="pred"></a>
### POST /api/prediction/

### Request Body

	{
		"geo_level_1_id": 11,
        "geo_level_2_id": 490,
        "geo_level_3_id": 12198,
        "count_floors_pre_eq": 2,
        "age": 30,
        "area_percentage": 6,
        "height_percentage": 5,
        "land_surface_condition": "",
        "foundation_type": "",
        "roof_type": "",
        "ground_floor_type": "",
        "other_floor_type": "",
        "position": "",
        "plan_configuration": "",
        "has_superstructure_adobe_mud": true,
        "has_superstructure_mud_mortar_stone": true,
        "has_superstructure_stone_flag": false,
        "has_superstructure_cement_mortar_stone": false,
        "has_superstructure_mud_mortar_brick": false,
        "has_superstructure_cement_mortar_brick": false,
        "has_superstructure_timber": false,
        "has_superstructure_bamboo": false,
        "has_superstructure_rc_non_engineered": false,
        "has_superstructure_rc_engineered": false,
        "has_superstructure_other": false,
        "legal_ownership_status": "",
        "count_families": 1,
        "has_secondary_use": false,
        "has_secondary_use_agriculture": false,
        "has_secondary_use_hotel": false,
        "has_secondary_use_rental": false,
        "has_secondary_use_institution": false,
        "has_secondary_use_school": false,
        "has_secondary_use_industry": false,
        "has_secondary_use_health_post": false,
        "has_secondary_use_gov_office": false,
        "has_secondary_use_use_police": false,
        "has_secondary_use_other": false
	}

### Response Body

	{
        "prediction": 1,
        "id": 1,
		"geo_level_1_id": 11,
        "geo_level_2_id": 490,
        "geo_level_3_id": 12198,
        "count_floors_pre_eq": 2,
        "age": 30,
        "area_percentage": 6,
        "height_percentage": 5,
        "land_surface_condition": "",
        "foundation_type": "",
        "roof_type": "",
        "ground_floor_type": "",
        "other_floor_type": "",
        "position": "",
        "plan_configuration": "",
        "has_superstructure_adobe_mud": true,
        "has_superstructure_mud_mortar_stone": true,
        "has_superstructure_stone_flag": false,
        "has_superstructure_cement_mortar_stone": false,
        "has_superstructure_mud_mortar_brick": false,
        "has_superstructure_cement_mortar_brick": false,
        "has_superstructure_timber": false,
        "has_superstructure_bamboo": false,
        "has_superstructure_rc_non_engineered": false,
        "has_superstructure_rc_engineered": false,
        "has_superstructure_other": false,
        "legal_ownership_status": "",
        "count_families": 1,
        "has_secondary_use": false,
        "has_secondary_use_agriculture": false,
        "has_secondary_use_hotel": false,
        "has_secondary_use_rental": false,
        "has_secondary_use_institution": false,
        "has_secondary_use_school": false,
        "has_secondary_use_industry": false,
        "has_secondary_use_health_post": false,
        "has_secondary_use_gov_office": false,
        "has_secondary_use_use_police": false,
        "has_secondary_use_other": false
	}

<br>