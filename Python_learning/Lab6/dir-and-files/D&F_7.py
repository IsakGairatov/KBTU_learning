fc = open(input('input the file to copy:\n'), 'r')
fp = open(input('input the file to paste:\n'), 'w')
fp.write(fc.read())
