import re

t = input()
pattern = r"([a-z])([A-Z]+)"
x = re.sub(pattern, r"\1" + "_" + r"\2", t).lower()
print(x)