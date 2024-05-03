Nums = [('ONE', '1'), ('TWO', '2'), ('THR', '3'), ('FOU', '4'), ('FIV', '5'), ('SIX', '6'),
('SEV', '7'), ('EIG', '8'), ('NIN', '9'), ('ZER', '0')]

s = input()
for i in Nums:
    s = s.replace(i[0], i[1])
a, b, pos = '', '', 0
for i in range(len(s)):
    if s[i].isnumeric():
        a += s[i]
    else:
        pos = i
        break
for i in range(i + 1, len(s)):
    b += s[i]
news = str(int(a) + int(b))
for i in Nums:
    news = news.replace(i[1], i[0])
print(news)
