import Dictionary


def sublist():
    return [i['name'] for i in Dictionary.movies if i['imdb'] > 5.5]