class StringOps:
    def __init__(self):
        self.string = ''

    def getString(self, str0):
        self.string = str0

    def PrintUpper(self):
        print(self.string.upper())


St1 = StringOps()
St1.getString(input())
St1.PrintUpper()
