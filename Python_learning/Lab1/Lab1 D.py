x, z = float(input()), input()
if z == 'k':
    n = input()
    a = '{0:.' + n + 'f}'
    print(a.format(x / 1024))
else:
    print(x * 1024)
