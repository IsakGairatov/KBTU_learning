import datetime

now = datetime.datetime.now()
print(datetime.datetime(now.year, now.month, now.day - 5, now.hour, now.minute, now.second, now.microsecond))
