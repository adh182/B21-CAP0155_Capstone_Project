from api.models.trainDataModel import TrainData
from rest_framework import serializers

class TrainDataSerializer(serializers.ModelSerializer):
	class Meta:
		model = TrainData
		fields = '__all__'