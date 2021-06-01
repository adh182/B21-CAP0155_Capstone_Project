from django.shortcuts import render
from rest_framework import viewsets
from api.models.datasetModel import Dataset
from api.serializers.datasetSerializer import DatasetSerializer

# Create your views here.
class DatasetViewSet(viewsets.ModelViewSet):
	queryset =  Dataset.objects.all()
	serializer_class = DatasetSerializer