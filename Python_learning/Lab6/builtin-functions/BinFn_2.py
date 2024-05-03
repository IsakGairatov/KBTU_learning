def isup(ch):
    return ch.isupper()


print(len(list(filter(isup, input()))))
