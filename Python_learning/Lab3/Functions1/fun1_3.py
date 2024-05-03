def solve(numheads, numlegs):
    numRab = (numlegs - 2 * numheads) // 2
    numCh = numheads - numRab
    return 'The number of Chicken: {}\nThe number of Rabbits: {}'.format(numCh, numRab)


