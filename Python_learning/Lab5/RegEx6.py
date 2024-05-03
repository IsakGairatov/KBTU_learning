import re

t = input()
pat = r"\.|,|\s"

x = re.sub(pat, ':', t)
print(x)