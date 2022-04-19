import re

fname = "actual_data.txt"
fhandle = open(fname, 'r')
number_list = map(int, re.findall('[0-9]+', fhandle.read()))
print(sum(number_list))