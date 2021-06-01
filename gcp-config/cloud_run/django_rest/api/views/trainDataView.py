from django.shortcuts import render
from rest_framework import viewsets
from api.models.trainDataModel import TrainData
from api.serializers.trainDataSerializer import TrainDataSerializer

# Create your views here.
class TrainDataViewSet(viewsets.ModelViewSet):
	queryset =  TrainData.objects.all()
	serializer_class = TrainDataSerializer