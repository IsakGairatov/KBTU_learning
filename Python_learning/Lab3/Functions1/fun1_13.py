import random

name = input('Hello! What is your name?\n')
s = '''Well, {}, I am thinking of a number between 1 and 20.
Take a guess.\n'''.format(name)
g = random.randint(1, 20)
cnt = 1
guess = int(input(s))

while guess != g:
    if guess < g: s = '''Your guess is too low.
Take a guess.\n'''
    else: s = '''Your guess is too large.
Take a guess.\n'''
    cnt += 1
    guess = int(input(s))

if g == guess: print('Good job, KBTU! You guessed my number in {} guesses!'.format(cnt))