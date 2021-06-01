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

@api_view(['POST'])
def PredictionViewSet(request):
    data = {
        'geo_level_1_id': request.POST.get('geo_level_1_id'),
        'geo_level_2_id': request.POST.get('geo_level_2_id'),
        'geo_level_3_id': request.POST.get('geo_level_3_id'),
        'count_floors_pre_eq': request.POST.get('count_floors_pre_eq'),
        'age': request.POST.get('age'),
        'area_percentage': request.POST.get('area_percentage'),
        'height_percentage': request.POST.get('height_percentage'),
        'land_surface_condition': request.POST.get('land_surface_condition'),
        'foundation_type': request.POST.get('foundation_type'),
        'roof_type': request.POST.get('roof_type'),
        'ground_floor_type': request.POST.get('ground_floor_type'),
        'other_floor_type': request.POST.get('other_floor_type'),
        'position': request.POST.get('position'),
        'plan_configuration': request.POST.get('plan_configuration'),
        'has_superstructure_adobe_mud': request.POST.get('has_superstructure_adobe_mud'),
        'has_superstructure_mud_mortar_stone': request.POST.get('has_superstructure_mud_mortar_stone'),
        'has_superstructure_stone_flag': request.POST.get('has_superstructure_stone_flag'),
        'has_superstructure_cement_mortar_stone': request.POST.get('has_superstructure_cement_mortar_stone'),
        'has_superstructure_mud_mortar_brick': request.POST.get('has_superstructure_mud_mortar_brick'),
        'has_superstructure_cement_mortar_brick': request.POST.get('has_superstructure_cement_mortar_brick'),
        'has_superstructure_timber': request.POST.get('has_superstructure_timber'),
        'has_superstructure_bamboo': request.POST.get('has_superstructure_bamboo'),
        'has_superstructure_rc_non_engineered': request.POST.get('has_superstructure_rc_non_engineered'),
        'has_superstructure_rc_engineered': request.POST.get('has_superstructure_rc_engineered'),
        'has_superstructure_other': request.POST.get('has_superstructure_other'),
        'legal_ownership_status': request.POST.get('legal_ownership_status'),
        'count_families': request.POST.get('count_families'),
        'has_secondary_use': request.POST.get('has_secondary_use'),
        'has_secondary_use_agriculture': request.POST.get('has_secondary_use_agriculture'),
        'has_secondary_use_hotel': request.POST.get('has_secondary_use_hotel'),
        'has_secondary_use_rental': request.POST.get('has_secondary_use_rental'),
        'has_secondary_use_institution': request.POST.get('has_secondary_use_institution'),
        'has_secondary_use_school': request.POST.get('has_secondary_use_school'),
        'has_secondary_use_industry': request.POST.get('has_secondary_use_industry'),
        'has_secondary_use_health_post': request.POST.get('has_secondary_use_health_post'),
        'has_secondary_use_gov_office': request.POST.get('has_secondary_use_gov_office'),
        'has_secondary_use_use_police': request.POST.get('has_secondary_use_use_police'),
        'has_secondary_use_other': request.POST.get('has_secondary_use_other'),
    }

    damage_grade = predict(data)
    data.update({'damage_grade': damage_grade})

    serializer = TrainDataSerializer(data=data)
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

def predict(data):
    model = tf.keras.models.load_model('.\\api\\training_model\model.h5')

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
    change_value = {'true': 1, 'false': 0, 'True': 1, 'False': 0}

    for column in list(test.columns):
        if column in categorical_feature:
            # Get one hot encoding of columns B
            one_hot = pd.get_dummies(test[column], prefix=column)
            # Drop column B as it is now encoded
            test = test.drop(column, axis = 1)
            # Join the encoded df
            test = test.join(one_hot)
        elif column not in int_feature:
            test[column] = test[column].map(change_value)
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
