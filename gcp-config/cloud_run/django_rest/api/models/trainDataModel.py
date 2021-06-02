from django.db import models

# Create your models here.
class TrainData(models.Model):
	geo_level_1_id = models.IntegerField()
	geo_level_2_id = models.IntegerField()
	geo_level_3_id = models.IntegerField()
	count_floors_pre_eq = models.IntegerField()
	age = models.IntegerField()
	area_percentage = models.IntegerField()
	height_percentage = models.IntegerField()
	land_surface_condition = models.CharField(max_length=250)
	foundation_type = models.CharField(max_length=250)
	roof_type = models.CharField(max_length=250)
	ground_floor_type = models.CharField(max_length=250)
	other_floor_type = models.CharField(max_length=250)
	position = models.CharField(max_length=250)
	plan_configuration = models.CharField(max_length=250)
	has_superstructure_adobe_mud = models.BooleanField(default=False)
	has_superstructure_mud_mortar_stone = models.BooleanField(default=False)
	has_superstructure_stone_flag = models.BooleanField(default=False)
	has_superstructure_cement_mortar_stone = models.BooleanField(default=False)
	has_superstructure_mud_mortar_brick = models.BooleanField(default=False)
	has_superstructure_cement_mortar_brick = models.BooleanField(default=False)
	has_superstructure_timber = models.BooleanField(default=False)
	has_superstructure_bamboo = models.BooleanField(default=False)
	has_superstructure_rc_non_engineered = models.BooleanField(default=False)
	has_superstructure_rc_engineered = models.BooleanField(default=False)
	has_superstructure_other = models.BooleanField(default=False)
	legal_ownership_status = models.CharField(max_length=250)
	count_families = models.IntegerField()
	has_secondary_use = models.BooleanField(default=False)
	has_secondary_use_agriculture = models.BooleanField(default=False)
	has_secondary_use_hotel = models.BooleanField(default=False)
	has_secondary_use_rental = models.BooleanField(default=False)
	has_secondary_use_institution = models.BooleanField(default=False)
	has_secondary_use_school = models.BooleanField(default=False)
	has_secondary_use_industry = models.BooleanField(default=False)
	has_secondary_use_health_post = models.BooleanField(default=False)
	has_secondary_use_gov_office = models.BooleanField(default=False)
	has_secondary_use_use_police = models.BooleanField(default=False)
	has_secondary_use_other = models.BooleanField(default=False)
	damage_grade = models.IntegerField()