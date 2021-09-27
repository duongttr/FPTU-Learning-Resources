largest = -float('inf')
smallest = float('inf')
while True:
    try:
        num = input("Enter a number: ")
        if num == "done":
            break
        elif int(num) > largest:
            largest = int(num)
        elif int(num) < smallest:
            smallest = int(num)
    except:
        print('Invalid input')

print("Maximum is", largest)
print("Minimum is", smallest)