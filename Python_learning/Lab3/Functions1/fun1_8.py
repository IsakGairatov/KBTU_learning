def spy_game(ar):
    nums = ''
    for i in ar:
        if i == '0' or i == '7':
            nums += i
    if nums.find('007') != -1: return 1
    return 0


