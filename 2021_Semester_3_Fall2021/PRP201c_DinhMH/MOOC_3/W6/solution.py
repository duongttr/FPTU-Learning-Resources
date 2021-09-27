import json
import urllib.request, urllib.parse, urllib.error
import ssl

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url_loc = input('Enter location: ')
data = urllib.request.urlopen(url_loc).read()

tree = json.loads(data)

s = 0
for comment in tree['comments']:
    s += comment['count']
print(s)