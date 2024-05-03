import math

n, a = int(input()), float(input())
p = a / (2 * (math.tan(math.pi / n)))
A = n * p**2 * (math.tan(math.pi / n))
print(int(A))