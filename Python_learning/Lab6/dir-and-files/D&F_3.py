import os
path = input('input the path:\n')
if os.access(path, os.F_OK):
    print('filename: ' + os.path.basename(path))
    print('Directory: ' + os.path.dirname(path))
else: print('there is no path with this name')