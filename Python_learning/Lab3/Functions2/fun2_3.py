import Dictionary


def Category(cat):
    if cat in (set([i['category'] for i in Dictionary.movies])):
        return [i['name'] for i in Dictionary.movies if i['category'] == cat]
