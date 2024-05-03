x = input()
n, sum1 = len(x), 0
i, k = n - 1, 0
while i >= 0 and k < n:
    sum1 += int(x[k]) * 2**i
    i -= 1
    k += 1
print(sum1)
