import re

fname = "/Users/jaydentran1909/Documents/Python Coursera/Course 3/C3_W2_Extracting_Data_using_Regex/actual_data.txt"
fhandle = open(fname, 'r')
number_list = map(int, re.findall('[0-9]+', fhandle.read()))
print(sum(number_list))