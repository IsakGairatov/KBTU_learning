import Dictionary


def avCat(cat):
    sum0, n = 0, 0
    if cat in (set([i['category'] for i in Dictionary.movies])):
        list1 = [i['imdb'] for i in Dictionary.movies if i['category'] == cat]
    for i in list1:
        sum0 += i
        n += 1
    return sum0 / n