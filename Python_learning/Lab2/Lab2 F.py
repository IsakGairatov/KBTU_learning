dict0 = {}

for i in range(int(input())):
    x, y = input().split()
    if x in dict0:
        dict0[x] += int(y)
    else:
        dict0[x] = int(y)

values = list(dict0.values())
values.sort()
max1 = values[-1]
list1 = []

for i in dict0.keys():
    if dict0[i] == max1:
        list1.append(i + ' is lucky!')
    else:
        list1.append(i + ' has to receive ' + str(max1 - dict0[i]) + ' tenge')
list1.sort()
for i in list1:
    print(i)
