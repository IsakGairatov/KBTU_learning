import pygame

pygame.init()
screen = pygame.display.set_mode((800, 800))
done = False
x, y = 400, 400


while not done:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        done = True
                if event.type == pygame.KEYDOWN:
                        if event.key == pygame.K_UP and 25 <= y - 20 <= 775: y -= 20
                        if event.key == pygame.K_DOWN and 25 <= y + 20 <= 775: y += 20
                        if event.key == pygame.K_RIGHT and 25 <= x + 20 <= 775: x += 20
                        if event.key == pygame.K_LEFT and 25 <= x - 20 <= 775: x -= 20


        screen.fill((0, 0, 0))
        pygame.draw.circle(screen, (255, 255, 255), (x, y), 25)

        pygame.display.flip()
