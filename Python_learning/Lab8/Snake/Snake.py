from os import scandir
from select import select
import pygame
import random

pygame.init()

BLACK = (0, 0, 0)
LINE_COLOR = (50, 50, 50)
HEIGHT = 500
WIDTH = 600

# Setting for fonts
font_small = pygame.font.SysFont('Verdana', 20)

BLOCK_SIZE = 20
score = 100
score0 = 100
level = 1

class Point:
    def __init__(self, _x, _y):
        self.x = _x
        self.y = _y


class Food:
    def __init__(self):
        self.location = Point(4, 10)

    def draw(self):
        point = self.location
        rect = pygame.Rect(BLOCK_SIZE * point.x, BLOCK_SIZE * point.y, BLOCK_SIZE, BLOCK_SIZE)
        pygame.draw.rect(SCREEN, (0, 255, 0), rect)

    # Set random location for food and increase scores when food is eaten
    def eaten(self, snake):
        global score
        self.location = Point(random.randint(0, 29), random.randint(0, 24))
        while self.location in snake:
            self.location = Point(random.randint(0, 29), random.randint(0, 24))
        score += 40


class Snake:
    def __init__(self):
        self.body = [Point(10, 11)]
        self.dx = 0
        self.dy = 0

    def move(self):
        for i in range(len(self.body) - 1, 0, -1):
            self.body[i].x = self.body[i - 1].x
            self.body[i].y = self.body[i - 1].y

        self.body[0].x += self.dx
        self.body[0].y += self.dy

        if self.body[0].x * BLOCK_SIZE > WIDTH:
            self.body[0].x = 0

        if self.body[0].y * BLOCK_SIZE > HEIGHT:
            self.body[0].y = 0

        if self.body[0].x < 0:
            self.body[0].x = WIDTH / BLOCK_SIZE

        if self.body[0].y < 0:
            self.body[0].y = HEIGHT / BLOCK_SIZE

    def draw(self):
        point = self.body[0]
        rect = pygame.Rect(BLOCK_SIZE * point.x, BLOCK_SIZE * point.y, BLOCK_SIZE, BLOCK_SIZE)
        pygame.draw.rect(SCREEN, (255, 0, 0), rect)

        for point in self.body[1:]:
            rect = pygame.Rect(BLOCK_SIZE * point.x, BLOCK_SIZE * point.y, BLOCK_SIZE, BLOCK_SIZE)
            pygame.draw.rect(SCREEN, (0, 255, 0), rect)

    def check_collision(self, food):
        if self.body[0].x == food.location.x:
            if self.body[0].y == food.location.y:
                self.body.append(Point(food.location.x, food.location.y))
                food.eaten(self.body)

    # Check for collision with wall, and decrese score if it colliide
    def check_wall_collision(self):
        global score
        if self.body[0].y == 25 or self.body[0].x == 30 or self.body[0].y == -1 or self.body[0].x == -1:
            score -= 10

def main():
    global SCREEN, CLOCK
    pygame.init()
    SCREEN = pygame.display.set_mode((WIDTH, HEIGHT))
    CLOCK = pygame.time.Clock()
    SCREEN.fill(BLACK)


    snake = Snake()
    food = Food()


    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RIGHT:
                    snake.dx = 1
                    snake.dy = 0
                if event.key == pygame.K_LEFT:
                    snake.dx = -1
                    snake.dy = 0
                if event.key == pygame.K_UP:
                    snake.dx = 0
                    snake.dy = -1
                if event.key == pygame.K_DOWN:
                    snake.dx = 0
                    snake.dy = 1

        snake.move()

        # Level changing mechanism
        global level, score0
        if score > score0 * 5:
            score0 = score
            level += 1

        snake.check_wall_collision()
        snake.check_collision(food)

        SCREEN.fill(BLACK)

        drawGrid()

        # Show level
        Level = font_small.render('Level ' + str(level), True, (255, 255, 255))
        SCREEN.blit(Level, (480, 10))

        # Show scores
        scores = font_small.render(str(score), True, (255, 255, 255))
        SCREEN.blit(scores, (10, 10))

        snake.draw()
        food.draw()

        pygame.display.update()
        # Dependents of speed on level
        CLOCK.tick(5 + (level - 1) * 3)


def drawGrid():
    for x in range(0, WIDTH, BLOCK_SIZE):
        for y in range(0, HEIGHT , BLOCK_SIZE):
            rect = pygame.Rect(x, y, BLOCK_SIZE, BLOCK_SIZE)
            pygame.draw.rect(SCREEN, LINE_COLOR, rect, 1)


main()

