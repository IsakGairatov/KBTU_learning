Shelf, Taken = [], []

for i in range(int(input())):
    a = tuple(input().split())
    if a[0] == '1':
        Shelf.append(a[1])
    elif a[0] == '2' and len(Shelf) != 0:
        Taken.append(Shelf.pop(0))

for i in Taken:
    print(i, end=' ')
