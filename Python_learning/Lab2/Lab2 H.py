x0, y0 = map(int, input().split())
List1 = []
for i in range(int(input())):
    List1.append(tuple(map(int, input().split())))


def close_to_P(tup):
    return ((tup[0] - x0)**2 + (tup[1] - y0)**2)**0.5


List1.sort(key=close_to_P)

for i in List1:
    print(i[0], i[1])