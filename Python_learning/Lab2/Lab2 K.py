def remSigns(s):
    for k in s:
        if not (k.islower() or k.isupper()):
            s = s.replace(k, '')
    return s


List = [remSigns(s) for s in set(input().split())]
List.sort()
print(len(List))
for i in List:
    print(i)