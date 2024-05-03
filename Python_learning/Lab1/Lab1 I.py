List = []
for i in range(int(input())):
    s = input()
    pos = s.rfind('@gmail.com')
    if pos != -1:
        List.append(s[:pos])
for s in List:
    print(s)
