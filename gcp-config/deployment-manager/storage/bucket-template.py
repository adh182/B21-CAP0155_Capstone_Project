#Storage Bucket Template

def GenerateConfig(context):
	'''Cretae cloud storage bucket'''

	PROJECT_NAME = 'B21-CAP0155-Capstone-Project'

	resources = [{
		'name': PROJECT_NAME + '-' + context.env['name'],
		'type': 'storage.v1.bucket',
		'properties': {
			'locationType': 'MULTI_REGION',
			'location': 'ASIA',
			'storageClass': 'STANDARD',
			'versioning': {
				'enabled': True
			}
		}

	}]

	return {'resources': resources}