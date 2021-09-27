import urllib.request, urllib.parse, urllib.error
import xml.etree.ElementTree as ET
import ssl

def cvert(x):
    return int(x.text)

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url_loc = input('Enter location: ')

xml = urllib.request.urlopen(url_loc, context=ctx).read()
tree = ET.fromstring(xml)

counts = tree.findall('.//count')
print(sum(map(cvert, counts)))
