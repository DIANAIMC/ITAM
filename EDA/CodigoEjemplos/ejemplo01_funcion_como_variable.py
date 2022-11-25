# -*- coding: utf-8 -*-
"""
Created on Fri Jan 22 09:25:09 2021

@author: andre
"""

#La función 'a' imprime "Hola" en la consola:
def a():
    print("Hola")
#La función 'a' imprime "Hola" en la consola:
def x():
    print("Adios")
#La función 'b' invoca a la función que recibe como parámetro:
def b(c):
    #Invoca a la función 'c' (el parámetro):
    c()
#Invoca a la función 'b', enviándole la función 'a' como parámetro.
#El resultado final debería ser que se imprima "Hola" en la consola, que es
#lo que hace 'a':
b(a)
b(x)
