import re

t = input().split()
pattern = r"(.+)_([a-z])"

for i in range(len(t)):
    pos = re.search(pattern, t[i])
    while pos is not None:
        t[i] = re.sub(pattern, pos.group(1) + pos.group(2).upper(), t[i])
        pos = re.search(pattern, t[i])


print(' '.join(t))