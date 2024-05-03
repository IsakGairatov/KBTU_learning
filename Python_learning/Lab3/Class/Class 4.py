class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def show(self):
        print('your point is ' + str(self.x) + ' ' + str(self.y))

    def move(self, x_new, y_new):
        self.x = x_new
        self.y = y_new

    def dist(self, x2, y2):
        print('your distance is ' + str(((self.x - x2)**2 + (self.y - y2)**2)**0.5))


x, y = map(int, input('write point:').split())

P1 = Point(x, y)
P1.show()

x, y = map(int, input('write second point:').split())
P1.dist(x, y)

x, y = map(int, input('write point to change:').split())
P1.move(x, y)
P1.show()


