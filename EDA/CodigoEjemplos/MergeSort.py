#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 11:35:21 2021

@author: Equipo 6: Diana, Yuliana, Mariel
"""
"""
class EmptyListException(RuntimeError): 
    def __init__(self, arg): 
        self.args = arg 
"""
    
def mergeSort(arr):
    #Dividirá el arreglo principal por mitades hasta llegar a arreglos de index 1
    if(len(arr) == 0):
        print("La lista está vacía, no hay nada que ordenar") 
    if len(arr) > 1: 
  
         # mid es la mitad del arreglo
        mid = len(arr)//2
  
        # Izq es la mitad izquierda
        Izq = arr[:mid]
  
        # Der es la mitad derecha
        Der = arr[mid:]
  
        # Se ordena la mitad izquierda
        mergeSort(Izq)
  
        # Se ordena la mitad derecha
        mergeSort(Der)
  
        #k es el apuntador del arreglo principal
        #i es el apuntador de la mitad izquierda 
        #j es el apuntador de la mitad derecha
        i = j = k = 0
        
        while i < len(Izq) and j < len(Der):
            if Izq[i] < Der[j]:
                arr[k] = Izq[i]
                i += 1
            else:
                arr[k] = Der[j]
                j += 1
            k += 1
  
        # Copia los elementos de
        #Izq[] solo en caso de haber
        while i < len(Izq):
            arr[k] = Izq[i]
            i += 1
            k += 1
        #Copia los elementos de
        #Der[] solo en caso de haber
        while j < len(Der):
            arr[k] = Der[j]
            j += 1
            k += 1           

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
#PRUEBAS PARA MERGESORT
#

#
#PRUEBA CON UNA LISTA VACÍA
#

print("El arreglo dado es", end="\n")
randomListInt(lista, 0)
printList(lista)
inicio = time.time()
mergeSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)

#
#PRUEBAS CON ENTEROS
#

print("Pruebas para mergeSort con enteros")
print("El arreglo dado es", end="\n")
randomListInt(lista0, 0)
printList(lista0)
inicio = time.time()
mergeSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista1, 10)
printList(lista1)
inicio = time.time()
mergeSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista2, 100)
printList(lista2)
inicio = time.time()
mergeSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000)
printList(lista3)
inicio = time.time()
mergeSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000)
printList(lista4)
inicio = time.time()
mergeSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000)
printList(lista5)
inicio = time.time()
mergeSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)

#
#PEOR CASO, ORDENAR UN ARREGLO DE MAYOR A MENOR
#

print("Pruebas para MergeSort en el peor caso")

print("El arreglo dado es", end="\n")
randomListInt(lista0, 0).sort(reverse=True)
printList(lista0)
inicio = time.time()
mergeSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista1, 10).sort(reverse=True)
printList(lista1)
inicio = time.time()
mergeSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista2, 100).sort(reverse=True)
printList(lista2)
inicio = time.time()
mergeSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000).sort(reverse=True)
printList(lista3)
inicio = time.time()
mergeSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000).sort(reverse=True)
printList(lista4)
inicio = time.time()
mergeSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000).sort(reverse=True)
printList(lista5)
inicio = time.time()
mergeSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)
10
#
# ORDENAR UN ARREGLO QUE YA ESTÁ ORDENADO
#

print("Pruebas para MergeSort en el caso ya ordenado")

print("El arreglo dado es", end="\n")
randomListInt(lista0, 0).sort()
printList(lista0)
inicio = time.time()
mergeSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista1, 10).sort()
printList(lista1)
inicio = time.time()
mergeSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista2, 100).sort()
printList(lista2)
inicio = time.time()
mergeSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000).sort()
printList(lista3)
inicio = time.time()
mergeSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000).sort()
printList(lista4)
inicio = time.time()
mergeSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000).sort()
printList(lista5)
inicio = time.time()
mergeSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)

#
#MERGESORT PARA DOUBLE
#

print("Pruebas para mergeSort con double")

print("El arreglo dado es", end="\n")
randomListDouble(lista0, 0)
printList(lista0)
inicio = time.time()
mergeSort(lista0)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista1, 10)
printList(lista1)
inicio = time.time()
mergeSort(lista1)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista2, 100)
printList(lista2)
inicio = time.time()
mergeSort(lista2)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista3, 1000)
printList(lista3)
inicio = time.time()
mergeSort(lista3)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)


print("El arreglo dado es", end="\n")
randomListDouble(lista4, 10000)
printList(lista4)
inicio = time.time()
mergeSort(lista4)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

#NO CORRE 100,000 DATOS DOUBLE
"""
print("El arreglo dado es", end="\n")
randomListDouble(lista5, 100000)
printList(lista5)
inicio = time.time()
mergeSort(lista5)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)
"""
#
#PRUEBAS DE LISTAS CON DOUBLES Y ENTEROS
#

print("Pruebas para mergeSort con lista de doubles y enteros")

print("El arreglo dado es", end="\n")
printList(listadoubleint)
inicio = time.time()
mergeSort(listadoubleint)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(listadoubleint)
print("La lista de doubles y enteros tardó en segundos: ", fin-inicio)
