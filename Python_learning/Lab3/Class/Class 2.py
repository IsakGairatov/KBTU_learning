class Shape:
    def __init__(self):
        self.length = 0

    def area(self):
        print(0)


class Square(Shape):
    def getLen(self, len0):
        self.length = len0

    def area(self):
        print(self.length ** 2)


Sh1 = Shape()
Sq1 = Square()

'# Length of square'
Sq1.getLen(int(input()))

'#Area of shape'
Sh1.area()

'#Area of Square'

Sq1.area()
