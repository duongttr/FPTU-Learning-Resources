import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup
import ssl

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter URL: ')
count = int(input('Enter count: '))
position = int(input('Enter position: '))

def getLink(url):
    print('Retrieving:', url)
    html = urllib.request.urlopen(url, context=ctx).read()
    soup = BeautifulSoup(html, 'html.parser')
    person = soup('a')[position-1]
    name = person.contents[0]
    next_url = person.get('href', None)
    return (name, next_url)

for _ in range(count):
    name, url = getLink(url)

print('Last name in sequence:', name)