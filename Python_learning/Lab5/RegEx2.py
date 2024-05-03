import re

text = input()
pattern = "ab{2,3}"

r = re.search(pattern, text)

if r is not None:
    print('match at position:', r.start())
else:
    print('not found.')
