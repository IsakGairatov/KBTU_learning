import os

root, pattern = '.', '*.*'
dirs, files0, al = [], [], []

for path, subdirs, files in os.walk(root):
    for name in subdirs:
        dirs.append(os.path.join(path, name))
        al.append(os.path.join(path, name))
    for name in files:
        files0.append(os.path.join(path, name))
        al.append(os.path.join(path, name))


def showList(a):
    for i in a:
        print(i, end='  ')
    print('')


showList(dirs)
showList(files0)
showList(al)