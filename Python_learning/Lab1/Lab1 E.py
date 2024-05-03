def isPrime(x):
    for i in range(2, int(x**0.5) + 1):
        if x % i == 0:
            return 0
    return 1


x = input()
d, f = int(x[0:x.find(' ')]), int(x[x.find(' ') + 1:])
if f % 2 == 0 and d <= 500 and isPrime(d):
    print('Good job!')
else:
    print('Try next time!')
