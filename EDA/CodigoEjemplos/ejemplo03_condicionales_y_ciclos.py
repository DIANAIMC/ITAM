# -*- coding: utf-8 -*-
"""
Created on Fri Jan 22 09:44:58 2021

@author: andre
"""

a=5
b=10
if a<b:
    print("a es menor que b.")

if a<b:
    print("a es menor que b.")
else:
    print("b es menor que a.")

#Ejemplos de "in" usado para consultar membresía:
letra="j"
if letra in ["a","e","i","o","u"]:
    print("Vocal")
elif letra in ["b","m","p"]:
    print("Consonante bilabial")
elif letra in ["f","v"]:
    print("Consonante labiodental")
elif letra in ["g","k","w","y"]:
    print("Consonante dorsal")
else:
    print("Otra consonante")

#El último ejemplo equivale a:
if letra in ["a","e","i","o","u"]:
    print("Vocal")
else:
    if letra in ["b","m","p"]:
        print("Consonante bilabial")
    else:
        if letra in ["f","v"]:
            print("Consonante labiodental")
        else:
            if letra in ["g","k","w","y"]:
                print("Consonante dorsal")
            else:
                print("Otra consonante")

#Imprime 4 3 2 1 0:
h=4
while h>=0:
    print(h)
    h=h-1

#Ejemplos de "in" usado para extraer los elementos de colecciones:
#Imprime uno por uno los elementos de una lista:
for i in ["alfa","beta","gama"]:
    print(i)

#Imprime sólo las vocales de una palabra (cadena de caracteres):
for letra in "elefante":
    if letra in ["a","e","i","o","u"]:
        print(letra)

#Imprime los valores enteros de 0 a 5 (inclusive):
for val in range(6):
    print(val)

#Imprime los valores enteros de 2 a 5 (inclusive):
for val in range(2,6):
    print(val)

#Imprime los valores enteros de 2 a 15 (inclusive) de tres en tres:
for val in range(2,16,3):
    print(val)
