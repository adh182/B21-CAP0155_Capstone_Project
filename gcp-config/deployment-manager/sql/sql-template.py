#Cloud SQL template
import json

def GenerateConfig(context):
	'''Create Cloud SQL Instance and Database'''

	PROJECT_ID = 'b21-cap0155-capstone-project'
	INSTANCE_NAME = PROJECT_ID +'-' + context.env['name'] + "-instance"
	DATABASE_NAME = PROJECT_ID +'-' + context.env['name'] + "-db"


	resources = [{
		'name': INSTANCE_NAME,
		'type': 'gcp-types/sqladmin-v1beta4:instances',
		'properties': {
			'databaseVersion': 'MYSQL_5_7',
			'region': context.properties['region'],
			'settings':{
				'tier': context.properties['tier'],
				'dataDiskSizeGb': context.properties['dataDiskSizeGb'],
				'dataDiskType': 'PD_SSD'
			}
		}
	}, 
	{	
		'name': DATABASE_NAME,
		'type': 'gcp-types/sqladmin-v1beta4:databases',
		'properties':{
			'name': DATABASE_NAME,
			'instance': ''.join(['$(ref.', INSTANCE_NAME,'.name)']),
			'charset': 'utf8'
		}

	}]

	return {'resources': resources}