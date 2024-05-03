n = int(input())

for i in range(0, n):
    for k in range(0, n):
        if i == 0:
            print(k, end=' ')
        elif k == 0:
            print(i, end=' ')
        elif i == k:
            print(i**2, end=' ')
        else:
            print('0', end=' ')
    print('')
