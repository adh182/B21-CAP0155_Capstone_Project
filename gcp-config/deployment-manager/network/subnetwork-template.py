#Subnetwork template

def GenerateConfig(context):
  """Create custom subnetwork"""

  resources = [{
      'name': context.env['name'],
      'type': 'compute.v1.subnetwork',
      'properties': {
          'ipCidrRange': context.properties['ipCidrRange']
          'network': context.properties['network']
          'region': context.properties['region']
      }
  }]

  return {'resources': resources}