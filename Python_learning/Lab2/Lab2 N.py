a = []
teams = []
x = int(input())

while x != 0:
    a.append(x)
    x = int(input())
hw = len(a) // 2
for i in range(hw):
    teams.append(a[i] + a[len(a) - i - 1])
if len(a) % 2 == 1:
    teams.append(a[hw])
for i in teams:
    print(i, end=' ')