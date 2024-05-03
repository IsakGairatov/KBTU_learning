def Check(x):
    up, lo, nu = 0, 0, 0
    for i in x:
        if up + lo + nu == 3:
            break
        elif ord('A') <= ord(i) <= ord('Z'):
            up = 1
        elif ord('a') <= ord(i) <= ord('z'):
            lo = 1
        elif ord('0') <= ord(i) <= ord('9'):
            nu = 1
    return (up + lo + nu) // 3


List1 = []
for i in range(int(input())):
    s = input()
    if Check(s) and s not in List1:
        List1.append(s)
List1.sort()
print(len(List1))
for i in List1:
    print(i)
