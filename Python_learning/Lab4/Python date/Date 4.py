import datetime

d1 = datetime.datetime.now()
d2 = datetime.datetime(2027, 3, 13, 20, 30, 13)

s = d2 - d1
print(s.total_seconds())
