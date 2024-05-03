import os

import pygame

pygame.init()
screen = pygame.display.set_mode((640, 480))
done = False

_image_lib = {}
def get_image(path):
    global _image_lib
    image = _image_lib.get(path)
    if image is None:
        can_path = path.replace('/', os.sep).replace('\\', os.sep)
        image = pygame.image.load(can_path)
        _image_lib[path] = image
    return image


clock = pygame.time.Clock()



immin = get_image('image/руки мин.png')
imho = get_image('image/руки часы.png')


while not done:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            done = True

    screen.fill((255, 255, 255))
    immin = pygame.transform.rotate(immin, -6)
    dm = immin.get_rect(center=immin.get_rect(center=(320, 240)).center)
    imho = pygame.transform.rotate(imho, -6 / 60)
    dh = imho.get_rect(center=imho.get_rect(center=(320, 240)).center)

    screen.blit(get_image('image/photo_2022-03-29_23-00-31.jpg'), (0, 0))
    screen.blit(immin, dm)
    screen.blit(imho, dh)

    pygame.display.flip()
    clock.tick(1)