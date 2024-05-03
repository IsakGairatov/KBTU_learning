from turtle import position
import pygame


def main():
    pygame.init()
    screen = pygame.display.set_mode((640, 480))

    baseLayer = pygame.Surface((640, 480))

    clock = pygame.time.Clock()

    prevX = -1
    prevY = -1
    currentX = -1
    currentY = -1

    screen.fill((0, 0, 0))

    mouse_mode = 0
    color = (255, 255, 255)
    isMouseDown = False

    while True:
        pressed = pygame.key.get_pressed()
        if pressed[pygame.K_r]:
            color = (255, 0, 0)
        elif pressed[pygame.K_g]:
            color = (0, 255, 0)
        elif pressed[pygame.K_b]:
            color = (0, 0, 255)
        elif pressed[pygame.K_w]:
            color = (255, 255, 255)
        if pressed[pygame.K_SPACE]:
            screen.fill((0, 0, 0))
        if pressed[pygame.K_1]:
            mouse_mode = 1
        elif pressed[pygame.K_2]:
            mouse_mode = 2
        elif pressed[pygame.K_0]:
            mouse_mode = 0


        if mouse_mode == 0:
            currentX = prevX
            currentY = prevY

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    return

                if event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == 1:
                        isMouseDown = True

                if event.type == pygame.MOUSEBUTTONUP:
                    if event.button == 1:
                        isMouseDown = False

                if event.type == pygame.MOUSEMOTION:
                    # if mouse moved, add point to list
                    currentX = event.pos[0]
                    currentY = event.pos[1]

            if isMouseDown:
                pygame.draw.line(screen, color, (prevX, prevY), (currentX, currentY))

            prevX = currentX
            prevY = currentY

            pygame.display.flip()
            clock.tick(60)

        elif mouse_mode == 1:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    return

                if event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == 1:
                        isMouseDown = True
                        currentX = event.pos[0]
                        currentY = event.pos[1]
                        prevX = event.pos[0]
                        prevY = event.pos[1]
                        baseLayer.blit(screen, (0, 0))

                if event.type == pygame.MOUSEBUTTONUP:
                    isMouseDown = False
                    baseLayer.blit(screen, (0, 0))

                if event.type == pygame.MOUSEMOTION:
                    if isMouseDown:
                        currentX = event.pos[0]
                        currentY = event.pos[1]

            if isMouseDown and prevX != -1 and prevY != -1 and currentX != -1 and currentY != -1:
                screen.blit(baseLayer, (0, 0))
                r = calculateRect(prevX, prevY, currentX, currentY)
                pygame.draw.rect(screen, color, pygame.Rect(r), 1)
                # print("{} {} {} {}".format(prevX, prevY, currentX, currentY))

            pygame.display.flip()
            clock.tick(60)
        elif mouse_mode == 2:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    return

                if event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == 1:
                        isMouseDown = True
                        currentX = event.pos[0]
                        currentY = event.pos[1]
                        prevX = event.pos[0]
                        prevY = event.pos[1]
                        baseLayer.blit(screen, (0, 0))

                if event.type == pygame.MOUSEBUTTONUP:
                    isMouseDown = False
                    baseLayer.blit(screen, (0, 0))

                if event.type == pygame.MOUSEMOTION:
                    if isMouseDown:
                        currentX = event.pos[0]
                        currentY = event.pos[1]

            if isMouseDown and prevX != -1 and prevY != -1 and currentX != -1 and currentY != -1:
                screen.blit(baseLayer, (0, 0))
                r = getRadius(prevX, prevY, currentX, currentY)
                pygame.draw.circle(screen, color, (prevX, prevY), r, 1)
            pygame.display.flip()
            clock.tick(60)

def calculateRect(x1, y1, x2, y2):
    return pygame.Rect(min(x1, x2), min(y1, y2), abs(x1 - x2), abs(y1 - y2))


def getRadius(x1, y1, x2, y2):
    return ((x1 - x2)**2 + (y1 - y2)**2)**0.5


main()