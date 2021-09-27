hrs = input("Enter Hours:")
h = float(hrs)
rate = input("Enter Rate:")
r = float(rate)

pay = h * r

if h > 40:
    pay += (h-40) * r * 0.5

print(pay)