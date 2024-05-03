import pygame, sys
import random, time

# Initialization
pygame.init()

# Setting up FPS
FPS = 60
FramePerSec = pygame.time.Clock()

# Colors
Black = (0, 0, 0)
Red = (255, 0, 0)
White = (255, 255, 255)
Yellow = (255,255,0)

# Coin color of different weight
coincolor = [(255,215,0), (255,165,0), (255,140,0)]

# Other Variables
Sc_width = 400
Sc_height = 600
Speed = 5
Score = 0
Coins = 0
N = 5

# Setting for fonts
font = pygame.font.SysFont('Verdana', 60)
font_small = pygame.font.SysFont('Verdana', 20)
game_over = font.render("Game Over", True, Black)

background = pygame.image.load('images/AnimatedStreet.png')

# Create a white screen

Dsurf = pygame.display.set_mode((400,600))
Dsurf.fill(White)
pygame.display.set_caption("Game")


# Behavior of the coins

class Coin(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        # cx define weight of coin
        self.cx = random.randint(0, 2)
        self.coin = pygame.Surface((30, 30))
        self.coin.fill((211,211,211))
        pygame.draw.circle(self.coin, coincolor[self.cx], (15, 15), 15)
        self.rect = self.coin.get_rect()
        self.rect.center = (random.randint(40, Sc_width - 40), random.randint(40, Sc_width - 40))

    def move(self):
        self.rect.move_ip(0, Speed)
        if self.rect.bottom > 600:
            self.rect.top = 0
            self.rect.center = (random.randint(40, Sc_width - 40), 0)
    def disappear(self):
        self.rect.center = (random.randint(40, Sc_width - 40), 0)


# Behavior of Enemy


class Enemy(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.image.load("images/Enemy.png")
        self.rect = self.image.get_rect()
        self.rect.center = (random.randint(40, Sc_width - 40), 0)

    def move(self):
        global Score
        self.rect.move_ip(0, Speed)
        if self.rect.bottom > 600:
            Score += 1
            self.rect.top = 0
            self.rect.center = (random.randint(40, Sc_width - 40), 0)


# Behaviour of player


class Player(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.image.load("images/Player.png")
        self.rect = self.image.get_rect()
        self.rect.center = (160, 520)

    def move(self):
        pressed_keys = pygame.key.get_pressed()

        if pressed_keys[pygame.K_UP]:
            self.rect.move_ip(0, -5)

        if pressed_keys[pygame.K_DOWN]:
            self.rect.move_ip(0, 5)

        if self.rect.left > 0:
            if pressed_keys[pygame.K_LEFT]:
                self.rect.move_ip(-5, 0)
        if self.rect.right < Sc_width:
            if pressed_keys[pygame.K_RIGHT]:
                self.rect.move_ip(5, 0)


# Setting up Sprites

P1 = Player()
E1 = Enemy()
C1 = Coin()
C2 = Coin()
C3 = Coin()

# List that contain all coins as tuple, because object Coin is not iterable
Cgroup = [(C1, ), (C2, ), (C3, )]

# Creating Sprites Groups
coins = pygame.sprite.Group()
coins.add(C1)
coins.add(C2)
coins.add(C3)
enemies = pygame.sprite.Group()
enemies.add(E1)
all_sprites = pygame.sprite.Group()
all_sprites.add(P1)
all_sprites.add(E1)

# Adding a new User event
INC_SPEED = pygame.USEREVENT + 1
pygame.time.set_timer(INC_SPEED, 1000)

# Game Loop
while True:

    # speed increase depending on amount of coins
    if Coins > N:
        Speed += 0.5
        N *= 2


    # Cycles through all events occuring
    for event in pygame.event.get():
        if event.type == INC_SPEED:
            Speed += 0.1
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # Show scores
    Dsurf.blit(background, (0, 0))
    scores = font_small.render(str(Score), True, Black)
    Dsurf.blit(scores, (10, 10))

    # Moves and Re-draws all Sprites
    for entity in all_sprites:
        entity.move()
        Dsurf.blit(entity.image, entity.rect)

    # To move or redraw coins
    for entity in coins:
        entity.move()
        Dsurf.blit(entity.coin, entity.rect)

    # If player has collision with coin
    for i in Cgroup:
        if pygame.sprite.spritecollideany(P1, i):
            Score += i[0].cx + 2
            Coins += 1
            i[0].disappear()

    # To be run if collision occurs between Player and Enemy

    if pygame.sprite.spritecollideany(P1, enemies):
        pygame.mixer.Sound('sounds/crash.wav').play()
        time.sleep(1)

        Dsurf.fill(Red)
        Dsurf.blit(game_over, (30, 250))

        pygame.display.update()
        for pygame.entity in all_sprites:
            entity.kill()
        time.sleep(2)
        pygame.quit()
        sys.exit()

    pygame.display.update()
    FramePerSec.tick(FPS)