class Primes:
    def __init__(self):
        self.array = []
        self.filtered = []

    def getArray(self, ar):
        self.array = ar

    def filter(self):
        add = lambda x: self.filtered.append(x)
        for k in self.array:
            if isPrime(k):
                add(k)


def isPrime(x):
    for i in range(2, int(x ** 0.5) + 1):
        if x % i == 0: return 0
    return 1


Cl1 = Primes()
Cl1.getArray(list(map(int, input('input an array!\n').split())))
Cl1.filter()

print(Cl1.filtered)