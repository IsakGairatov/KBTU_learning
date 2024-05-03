import re

text = input()
pattern = "ab*"
r = re.search(pattern, text)

if r is not None:
    print('match at position:', r.start())
else:
    print("not found.")
