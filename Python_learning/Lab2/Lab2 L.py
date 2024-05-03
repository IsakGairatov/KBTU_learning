Stack = [1]
List = list(input())

for i in List:
    if i == '(' or i == '[' or i == '{':
        Stack.append(i)
    elif i == ')':
        if Stack[-1] == '(':
            Stack.pop()
        else:
            Stack.clear()
            break
    elif i == ']':
        if Stack[-1] == '[':
            Stack.pop()
        else:
            Stack.clear()
            break
    elif i == '}':
        if Stack[-1] == '{':
            Stack.pop()
        else:
            Stack.clear()
            break
if len(Stack) == 1:
    print('Yes')
else:
    print('No')

