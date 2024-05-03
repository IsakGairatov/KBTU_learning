import json
import config

f = open('Sample_data')

dict0 = json.load(f)

Data, data = [], []
Am = dict0['totalCount']

for i in dict0['imdata']:
    for k in i.values():
        for j in k.values():
            data.append(j['dn'])
            data.append(j['descr'])
            data.append(j['speed'])
            data.append(j['mtu'])
            Data.append(data)
            data = []

print(config.head)
for i in Data:
    sp = 0
    for k in i:
        print(k + ' ' * (config.seps[sp] - len(k)), end='')
        sp += 1
    print('')
