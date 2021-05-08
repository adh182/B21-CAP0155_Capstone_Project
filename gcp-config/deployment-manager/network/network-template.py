#Network template

def GenerateConfig(context):
  """Create custom network"""

  resources = [{
      'name': context.env['name'],
      'type': 'compute.v1.network',
      'properties': {
        'autoCreateSubnetworks' : False
      }
  }]

  return {'resources': resources}