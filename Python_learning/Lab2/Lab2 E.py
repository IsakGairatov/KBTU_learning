def fun(k):
    return x + 2 * k


inp = tuple(map(int, input().split()))
if len(inp) == 1:

    inp += (int(input()),)
n, x = inp
Bitwise = x
for i in range(1, n):
    Bitwise ^= fun(i)
print(Bitwise)
