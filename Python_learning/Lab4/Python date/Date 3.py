import datetime

now = datetime.datetime.now()
print(now.strftime('%Y'), now.strftime('%m'), now.strftime('%d'), sep='-')
