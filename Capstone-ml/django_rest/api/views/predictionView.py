import tensorflow as tf
import pandas as pd
import numpy as np
from django.shortcuts import render
from django.http import HttpResponse
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import status
from api.models.datasetModel import Dataset
from api.models.trainDataModel import TrainData
from api.serializers.datasetSerializer import DatasetSerializer
from api.serializers.trainDataSerializer import TrainDataSerializer
from keras.utils.data_utils import get_file

@api_view(['POST'])
def PredictionViewSet(request):
    data = request.data
    damage_grade = predict(data)
    data.update({'damage_grade': damage_grade})

    serializer = TrainDataSerializer(data=data)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

def predict(data):
    model_file = get_file(
        'model.h5',
        'https://storage.googleapis.com/b21-cap0155-capstone-project-bucket-1/training_model/model.h5')
    model = tf.keras.models.load_model(model_file)

    test = pd.json_normalize(data)
    test = one_hot(test)

    test = test.tail(1)
    test = test.astype(int)
    
    prediction = np.argmax(model.predict(test), axis=-1)[0]

    return prediction

def one_hot(test):
    # One hot labeling for categorical data
    categorical_feature=['land_surface_condition', 'foundation_type', 'roof_type',
        'ground_floor_type', 'other_floor_type', 'position',
        'plan_configuration', 'legal_ownership_status']
    int_feature=['geo_level_1_id', 'geo_level_2_id', 'geo_level_3_id', 'count_floors_pre_eq',
        'age', 'area_percentage', 'height_percentage', 'count_families']

    test = dummy_data(test)

    for column in list(test.columns):
        if column in categorical_feature:
            # Get one hot encoding of columns B
            one_hot = pd.get_dummies(test[column], prefix=column)
            # Drop column B as it is now encoded
            test = test.drop(column, axis = 1)
            # Join the encoded df
            test = test.join(one_hot)
    return test

def dummy_data(test):
    data_categorical = np.array([
        ['n', 'h', 'n', 'f', 'j', 'j', 'a', 'a'],
        ['o', 'i', 'q', 'm', 'q', 'o', 'c', 'r',],
        ['t', 'r', 'x', 'v', 's', 's', 'd', 'v',],
        ['n', 'u', 'n', 'x', 'x', 't', 'f', 'w',],
        ['o', 'w', 'q', 'z', 'j', 'j', 'm', 'a',],
        ['t', 'h', 'x', 'f', 'q', 'o', 'n', 'r',],
        ['n', 'i', 'n', 'm', 's', 's', 'o', 'v',],
        ['o', 'r', 'q', 'v', 'x', 't', 'q', 'w',],
        ['t', 'u', 'x', 'x', 'j', 'j', 's', 'a',],
        ['n', 'w', 'n', 'z', 'q', 'o', 'u', 'r',],
    ])

    df = pd.DataFrame(data=data_categorical, columns=['land_surface_condition', 'foundation_type', 'roof_type',
        'ground_floor_type', 'other_floor_type', 'position',
        'plan_configuration', 'legal_ownership_status']
    )

    test = df.append(test, ignore_index=True)

    return test