def toLowercase(s):
    x = ''
    for i in s:
        if ord('A') <= ord(i) <= ord('Z'):
            x += chr(ord(i) + 32)
        else:
            x += i
    return x


print(toLowercase(input()))
