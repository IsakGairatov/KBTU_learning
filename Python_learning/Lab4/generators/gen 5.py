def gen_nto0(nf):
    return list(range(nf, -1, -1))


for i in gen_nto0(int(input())):
    print(i, end=' ')