import pygame

pygame.init()
screen = pygame.display.set_mode((100, 100))
done = False


songs = ['songs/song_1.ogg', 'songs/song_2.mp3', 'songs/song_3.mp3', 'songs/song_4.mp3', 'songs/song_5.mp3',
         'songs/song_6.mp3']


print('''Up - play\nDown - stop\nRight - next\nLeft - previous''')


def next_s():
    global songs
    songs = songs[1:] + [songs[0]]
    pygame.mixer.music.stop()
    pygame.mixer.music.load(songs[0])
    pygame.mixer.music.play()


def last_s():
    global songs
    songs = [songs[-1]] + songs[:-1]
    pygame.mixer.music.stop()
    pygame.mixer.music.load(songs[0])
    pygame.mixer.music.play()


while not done:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            done = True
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP:
                pygame.mixer.music.load(songs[0])
                pygame.mixer.music.play()
            if event.key == pygame.K_DOWN:
                pygame.mixer.music.stop()
            if event.key == pygame.K_RIGHT: next_s()
            if event.key == pygame.K_LEFT: last_s()
    pygame.display.flip()