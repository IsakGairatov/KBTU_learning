import re

t = input()
pattern = r"(\w)([A-Z])"

x = re.sub(pattern, r"\1 \2", t)

print(x)