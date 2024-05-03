Dates = []
x = input()

while x != '0':
    dmy = x.split()
    Dates.append(dmy[::-1])
    x = input()
Dates.sort()
for i in Dates:
    print(i[2], i[1], i[0])
