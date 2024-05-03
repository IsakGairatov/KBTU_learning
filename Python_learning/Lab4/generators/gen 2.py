def gen_even(nf):
    return range(2, nf, 2)


n = int(input())
for i in gen_even(n):
    if i < n - 1:
        print(i, end=',')
    else:
        print(i)
