from api.model.datasetModel import Dataset
from rest_framework import serializers

class DatasetSerializer(serializers.ModelSerializer):
	class Meta:
		model = Dataset
		fields = '__all__' #menampilkan semua field pada class Dataset