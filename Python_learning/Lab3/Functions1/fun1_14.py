import fun1_5
import fun1_6
import fun1_10
import fun1_15


s = fun1_6.revSen(input('Write the sentence:\n'))
print('reversed sentence:\n', s)
ar = fun1_10.uniqAr(s.split())
print('list of it\'s uniq words:\n', ar)

ltrS = fun1_15.first_letters(ar)
if input('do you want permutation of first letters of previous set? (yes / no)\n') == 'yes':
    print('permutations of theirs first letters:')
    fun1_5.perm('', ltrS)
else: print('No, then no.')

