n = int(input())
even = n % 2 == 0

if even:
    for i in range(0, n):
        for k in range(0, n):
            if i >= k:
                print('#', end='')
            else:
                print('.', end='')
        print('')
else:
    for i in range(0, n):
        for k in range(0, n):
            if n - i - 1 <= k:
                print('#', end='')
            else:
                print('.', end='')
        print('')
