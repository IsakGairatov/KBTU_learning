def perm(blank, s):
    for i in s:
        if len(s) == 1:
            print(blank + i)
        else:
            a = list(s)
            a.remove(i)
            a = ''.join(a)
            perm(blank + i, a)


