def computepay(h, r):
    p = h * r
    if h > 40:
        return p + (h-40)*r*0.5

hrs = float(input("Enter Hours:"))
rate = float(input("Enter Rate:"))
p = computepay(hrs, rate)
print("Pay", p)