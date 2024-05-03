class Shape:
    def __init__(self):
        self.length = 0

    def area(self):
        print(0)


class Rectangle(Shape):
    def __init__(self, l1, w1):
        self.length = l1
        self.width = w1

    def area(self):
        print(self.length * self.width)


Rc1 = Rectangle(int(input()), int(input()))

Rc1.area()
