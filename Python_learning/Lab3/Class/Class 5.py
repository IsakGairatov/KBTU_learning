class Account:
    def __init__(self, owner, balance):
        self.owner = owner
        self.balance = balance

    def deposit(self, m):
        self.balance += m
        print('your current balance: ' + str(self.balance))

    def withdraw(self, m):
        if self.balance - m >= 0:
            self.balance -= m
            print('your current balance: ' + str(self.balance))
        else:
            print(self.owner + '\'s balance has not enough to withdraw this amount of money')


Ac1 = Account(input('owner name:\n'), int(input('start balance:\n')))
Ac1.deposit(int(input('give money!\n')))
Ac1.withdraw(int(input('take money!\n')))
Ac1.deposit(int(input('give money!\n')))
Ac1.withdraw(int(input('take money!\n')))