def gen_d34(nf):
    return [i for i in range(1, nf) if i % 12 == 0]


for i in gen_d34(int(input())):
    print(i, end=' ')