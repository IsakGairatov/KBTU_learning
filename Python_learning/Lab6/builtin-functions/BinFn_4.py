from time import sleep


def Fn(x, ms):
    sleep(ms / 1000)
    return pow(x, 1 / 2)


x0, ms0 = int(input()), int(input())
print('Square root of '+ str(x0) + ' after ' + str(ms0) + ' miliseconds is ' + str(Fn(x0, ms0)))