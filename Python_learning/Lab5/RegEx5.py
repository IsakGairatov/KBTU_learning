import re

t = input()
pat = "a.*b"

r = re.search(pat, t)

if r is not None:
    print('match at position:', r.start())
else:
    print('not found.')
