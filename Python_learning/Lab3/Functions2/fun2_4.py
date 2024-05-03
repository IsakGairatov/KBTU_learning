import Dictionary


def average():
    sum0, n = 0, 0
    for i in Dictionary.movies:
        sum0 += i['imdb']
        n += 1
    return sum0 / n
