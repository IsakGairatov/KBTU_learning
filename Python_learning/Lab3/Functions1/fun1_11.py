def Pol(s):
    s = s.lower()
    i = 0
    while i < len(s) / 2:
        if s[i] != s[len(s) - 1 - i]:
            return 0
        return 1


