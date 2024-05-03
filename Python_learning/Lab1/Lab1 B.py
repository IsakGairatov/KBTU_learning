s = input()
sumy = 0
for x in s:
    sumy += ord(x)

print('It is tasty!') if sumy > 300 else print('Oh, no!')
