import Dictionary


def isAbove55(num_or_name):
    if num_or_name.isnumeric():
        if Dictionary.movies[num_or_name]['imdb'] > 5.5: return True
        else: return False
    else:
        for i in Dictionary.movies:
            if num_or_name in i['name']:
                if i['imdb'] > 5.5: return True
                return False

