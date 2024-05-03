def prList(ar):
    ar2 = list(ar)
    i, k = 0, 2
    while i < len(ar):
        while k < ar[i]**0.5 + 1:
            if ar[i] % k == 0:
                ar2.remove(ar[i])
                k = 2
                break
            k += 1
        i += 1

    return ar2



