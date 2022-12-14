#! /usr/bin/env python

# Gráfica de ocurrencias de bots por cantidad de generos

import csv
import matplotlib.pyplot as plt
from statistics import median, mean

ocurrencias_x_numgeneros = []

with open('ocurrenciasxgenero.csv') as f:
    ocurrencias_generos = csv.reader(f)
    for row in ocurrencias_generos:
        for i in row:
            new = i.replace(' ','')
            if len(new) == 1:
                ocurrencias_x_numgeneros.append(int(new))

num_generos = [2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
media = mean(ocurrencias_x_numgeneros)
print(media)
mediana = median(ocurrencias_x_numgeneros)
print(mediana)

f = plt.figure()
f.set_figwidth(10)
f.set_figheight(10)

plt.hist(ocurrencias_x_numgeneros, num_generos, edgecolor = 'black', color = 'mediumturquoise')
plt.title('Número de bots en el decil más bajo por tiempo de reviews por número de géneros', fontweight ="bold")
plt.xlabel('Número de géneros')
plt.ylabel('Ocurrencias')
plt.axvline(media, color = 'r', label = 'Media', linewidth = 2)
plt.axvline(mediana, color = 'y', label = 'Mediana', linewidth = 2)
plt.legend(loc = 1)
plt.show()
