import os

path = input('input the path to delete:\n')
if os.access(path, os.F_OK):
    os.remove(path)
else:
    print('there no file or directory with this path')
