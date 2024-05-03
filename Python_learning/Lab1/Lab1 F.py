s = ''
for i in range(int(input())):
    x = int(input())
    if x <= 10:
        s += 'Go to work!\n'
    elif 10 < x <= 25:
        s+= 'You are weak\n'
    elif 25 < x <= 45:
        s += 'Okay, fine\n'
    else:
        s += 'Burn! Burn! Burn Young!\n'
print(s.strip())
