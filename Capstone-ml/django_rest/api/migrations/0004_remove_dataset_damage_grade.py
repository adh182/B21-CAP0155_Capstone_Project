# Generated by Django 3.2 on 2021-05-30 12:41

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0003_dataset_damage_grade'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='dataset',
            name='damage_grade',
        ),
    ]
