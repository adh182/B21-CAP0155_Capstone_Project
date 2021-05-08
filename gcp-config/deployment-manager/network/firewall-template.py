#Firewall rules template

def GenerateConfig(context):
  """Create firewall rule - allowing HTTP connection"""

  resources = [{
      'name': context.env['name']+'allow-http',
      'type': 'compute.v1.firewall',
      'properties': {
          'network': context.properties['network']
          'sourceRanges': ['0.0.0.0/0']
          'allowed': [{
              'IPProtocol': 'HTTP'
              'ports': ["80"]
          }]
      }
  }]

  return {'resources': resources}