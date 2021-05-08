#Storage Bucket Template

def GenerateConfig(context):
	'''Cretae cloud storage bucket'''

	PROJECT_ID = 'b21-cap0155-capstone-project'

	resources = [{
		'name': PROJECT_ID + '-' + context.env['name'],
		'type': 'storage.v1.bucket',
		'properties': {
			'locationType': 'multi-region',
			'location': 'ASIA',
			'storageClass': 'STANDARD',
			'versioning': {
				'enabled': True
			}
		}

	}]

	return {'resources': resources}