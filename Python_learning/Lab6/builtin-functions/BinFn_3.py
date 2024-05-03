def isPol(s):
    s = s.lower()
    l = len(s)
    for i in range(l // 2):
        if s[i] != s[l - i - 1]: return 'This string is not Palindrome'
    return 'This string is Palindrome'


print(isPol(input()))
