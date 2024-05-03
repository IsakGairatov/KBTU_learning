list0, prod = list(map(int, input().split())), 1
for i in range(len(list0)):
    prod *= list0[i]
print(prod)