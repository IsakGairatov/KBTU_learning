import re

text = input()
pattern = "[a-z]+_[a-z]+"

r = re.search(pattern, text)

if r is not None:
    print('match at position:', r.start())
else:
    print('not found.')