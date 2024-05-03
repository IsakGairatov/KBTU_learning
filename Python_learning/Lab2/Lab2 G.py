demons = {}
for i in range(int(input())):
    x, y = input().split()
    if y in demons:
        demons[y] += 1
    else:
        demons[y] = 1
for i in range(int(input())):
    x, y, z = input().split()
    if y in demons:
        demons[y] -= int(z)


def make_zero(x0):
    if x0 < 0:
        return 0
    else:
        return x0


sum0 = 0
for i in demons.keys():
    sum0 += make_zero(demons[i])

print('Demons left:', sum0)
