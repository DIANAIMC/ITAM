#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Sep 29 19:17:36 2021

@author: Equipo 6: Diana, Yuliana, Mariel
"""

#Selection Sort

#queremos dos arrays, uno sorted y otro unsorted
def selectionSort(array):
    if(len(array) == 0):
        print("La lista está vacía, no hay nada que ordenar") 
    #guardamos el indice del primer elemento del unsorted array 
    pointer = 0 #guardamos el indice del primer elemento del unsorted array
    while pointer < len(array) - 1: 
        smallest = pointer
    #iteramos a través del unsorted array
        for i in range(pointer+1, len(array)): 
        #checamos si el elemento actual es menor que lo que tenemos 
        #guardado como el más chico
            if array[smallest] > array[i]: 
                smallest = i
    #cuando encontramos el más chico ahora hacemos swap por el que teníamos guardado 
    #como el más chico
        swap(pointer, smallest, array) 
        pointer += 1
    return array

#Método auxiliar que intercambia dos datos de la lista
def swap(i, j, array):
  array[i], array[j] = array[j], array[i]
  
#Imprime una lista dada
def printList(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print()

#Método que dada una lista, la llena con números aleatorios entre -99 y 99
import random
def randomListInt(lista, n):
    for i in range(n):
       lista[i] = random.randint(-99, 99)
    return lista

#Método que dada una lista, la llena con double
def randomListDouble(lista, n):
    for i in range(n):
       lista[i] = random.random()
    return lista

#
#PRUEBAS
#

#importamos tiempo que nos servirá para cálcular el tiempo de ejecución de nuestras funciones
import time
#Listas que serán ordenadas
lista = []
lista0 = [0]
lista1 = [0]*10
lista2 = [0]*100
lista3 = [0]*1000
lista4 = [0]*10000
lista5 = [0]*100000
listadoubleint = [1, 0.1, 2.5, -9, -0.99999, 3.1416, 3, 8, 221, 0.0000001]



#
#PRUEBAS PARA SELECTIONSORT
#

#
#PRUEBA CON UNA LISTA VACÍA
#

print("El arreglo dado es", end="\n")
randomListInt(lista, 0)
printList(lista)
inicio = time.time()
selectionSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)

#
#PRUEBAS CON ENTEROS
#

print("Pruebas para selectionSort con enteros")

print("El arreglo dado es", end="\n")
randomListInt(lista0, 0)
printList(lista0)
inicio = time.time()
selectionSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista1, 10)
printList(lista1)
inicio = time.time()
selectionSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista2, 100)
printList(lista2)
inicio = time.time()
selectionSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000)
printList(lista3)
inicio = time.time()
selectionSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000)
printList(lista4)
inicio = time.time()
selectionSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

#
#El método insertionSort no soporta listas mayores a 10,000 datos
#
"""

print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000)
printList(lista5)
inicio = time.time()
selectionSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)
"""

#
#PEOR CASO, ORDENAR UN ARREGLO DE MAYOR A MENOR
#

print("Pruebas para selectionSort en el peor caso")

print("El arreglo dado es", end="\n")
randomListInt(lista0, 0).sort(reverse=True)
printList(lista0)
inicio = time.time()
selectionSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista1, 10).sort(reverse=True)
printList(lista1)
inicio = time.time()
selectionSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista2, 100).sort(reverse=True)
printList(lista2)
inicio = time.time()
selectionSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000).sort(reverse=True)
printList(lista3)
inicio = time.time()
selectionSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000).sort(reverse=True)
printList(lista4)
inicio = time.time()
selectionSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

#
#El método selectionSort no soporta listas mayores a 10,000 datos
#

"""

print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000).sort(reverse=True)
printList(lista5)
inicio = time.time()
selectionSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)
"""

#
# ORDENAR UN ARREGLO QUE YA ESTÁ ORDENADO
#

print("Pruebas para selectionSort en el caso ordenado")

print("El arreglo dado es", end="\n")
randomListInt(lista0, 0).sort()
printList(lista0)
inicio = time.time()
selectionSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista1, 10).sort()
printList(lista1)
inicio = time.time()
selectionSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista2, 100).sort()
printList(lista2)
inicio = time.time()
selectionSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000).sort()
printList(lista3)
inicio = time.time()
selectionSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000).sort()
printList(lista4)
inicio = time.time()
selectionSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

#
#El método selectionSort no soporta listas mayores a 10,000 datos
#

"""

print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000).sort(reverse=True)
printList(lista5)
inicio = time.time()
selectionSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)
"""

#
#SELECTIONSORT PARA DOUBLE
#

print("Pruebas para selectionSort con double")

print("El arreglo dado es", end="\n")
randomListDouble(lista0, 0)
printList(lista0)
inicio = time.time()
selectionSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista1, 10)
printList(lista1)
inicio = time.time()
selectionSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista2, 100)
printList(lista2)
inicio = time.time()
selectionSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista3, 1000)
printList(lista3)
inicio = time.time()
selectionSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista4, 10000)
printList(lista4)
inicio = time.time()
selectionSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

#
#El método selectionSort no soporta listas mayores a 10,000 datos
#

"""

print("El arreglo dado es", end="\n")
randomListDouble(lista5, 100000)
printList(lista5)
inicio = time.time()
selectionSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)
"""

#
#PRUEBAS DE LISTAS CON DOUBLES Y ENTEROS
#

print("Pruebas para selectionSort con lista de doubles y enteros")

print("El arreglo dado es", end="\n")
printList(listadoubleint)
inicio = time.time()
selectionSort(listadoubleint)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(listadoubleint)
print("La lista de doubles y enteros tardó en segundos: ", fin-inicio)

