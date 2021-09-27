# Use the file name mbox-short.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
count = 0
s = 0
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:"):
        continue
    else:
        count += 1
        p = line.find('0')
        num = float(line[p:].strip())
        s += num
        
print("Average spam confidence:", s / count)
