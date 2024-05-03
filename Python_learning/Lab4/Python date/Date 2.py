import datetime

today = datetime.datetime.now()
print(datetime.datetime(today.year, today.month, today.day - 1))
print(datetime.datetime(today.year, today.month, today.day))
print(datetime.datetime(today.year, today.month, today.day + 1))
