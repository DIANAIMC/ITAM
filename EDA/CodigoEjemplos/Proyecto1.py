#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 11:35:21 2021

@author: dianam
"""
class EmptyListException(RuntimeError): 
    def __init__(self, arg): 
        self.args = arg 

    
def mergeSort(arr):
    #dividirá el arreglo principal por mitades hasta llegar a arreglos de index 1
    if len(arr) > 1: 
  
         # mid es la mitad del arreglo
        mid = len(arr)//2
  
        # mitad izquierda
        Izq = arr[:mid]
  
        # mitad derecha
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


def printList(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print()
import random
def randomListInt(lista, n):
    for i in range(n):
       lista[i] = random.randint(-99, 99)
    return lista

def randomListDouble(lista, n):
    for i in range(n):
       lista[i] = random.random()
    return lista


#PRUEBAS
import time
#Listas que serán ordenadas
lista0 = [0]
lista1 = [0]*10
lista2 = [0]*100
lista3 = [0]*1000
lista4 = [0]*10000
lista5 = [0]*100000
listaObjetosRandom = [1, 0.1, 2.5, -9, 4]

"""
print("Pruebas para mergeSort con lista de distintos objetos")
inicio = time.time()
print("El arreglo dado es", end="\n")
printList(listaObjetosRandom)
mergeSort(listaObjetosRandom)
print("El arreglo ordenado es: ", end="\n")
printList(listaObjetosRandom)
fin = time.time()
print("La lista de distintos objetos tardó en segundos: ", fin-inicio)
"""
#
#Pruebas para mergeSort
#

#
#PRUEBAS CON ENTEROS
#

print("Pruebas para mergeSort con enteros")
inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista0, 0)
printList(lista0)
mergeSort(lista0)
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
fin = time.time()
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista1, 10)
printList(lista1)
mergeSort(lista1)
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
fin = time.time()
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista2, 100)
printList(lista2)
mergeSort(lista2)
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
fin = time.time()
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000)
printList(lista3)
mergeSort(lista3)
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
fin = time.time()
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000)
printList(lista4)
mergeSort(lista4)
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
fin = time.time()
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000)
printList(lista5)
mergeSort(lista5)
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
fin = time.time()
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)

#
#PEOR CASO
#

print("Pruebas para MergeSort en el peor caso")
inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista0, 0).sort(reverse=True)
printList(lista0)
mergeSort(lista0)
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
fin = time.time()
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista1, 10).sort(reverse=True)
printList(lista1)
mergeSort(lista1)
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
fin = time.time()
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista2, 100).sort(reverse=True)
printList(lista2)
mergeSort(lista2)
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
fin = time.time()
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista3, 1000).sort(reverse=True)
printList(lista3)
mergeSort(lista3)
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
fin = time.time()
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista4, 10000).sort(reverse=True)
printList(lista4)
mergeSort(lista4)
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
fin = time.time()
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListInt(lista5, 100000).sort(reverse=True)
printList(lista5)
mergeSort(lista5)
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
fin = time.time()
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)

#
#MERGESORT PARA DOUBLE
#

print("Pruebas para mergeSort con double")
inicio = time.time()
print("El arreglo dado es", end="\n")
randomListDouble(lista0, 0)
printList(lista0)
mergeSort(lista0)
print("El arreglo ordenado es: ", end="\n")
printList(lista0)
fin = time.time()
print("La lista 0 de 1 elemento tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListDouble(lista1, 10)
printList(lista1)
mergeSort(lista1)
print("El arreglo ordenado es: ", end="\n")
printList(lista1)
fin = time.time()
print("La lista 1 de 10 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListDouble(lista2, 100)
printList(lista2)
mergeSort(lista2)
print("El arreglo ordenado es: ", end="\n")
printList(lista2)
fin = time.time()
print("La lista 2 de 100 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListDouble(lista3, 1000)
printList(lista3)
mergeSort(lista3)
print("El arreglo ordenado es: ", end="\n")
printList(lista3)
fin = time.time()
print("La lista 3 de 1000 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListDouble(lista4, 10000)
printList(lista4)
mergeSort(lista4)
print("El arreglo ordenado es: ", end="\n")
printList(lista4)
fin = time.time()
print("La lista 4 de 10000 elementos tardó en segundos: ", fin-inicio)

inicio = time.time()
print("El arreglo dado es", end="\n")
randomListDouble(lista5, 100000)
printList(lista5)
mergeSort(lista5)
print("El arreglo ordenado es: ", end="\n")
printList(lista5)
fin = time.time()
print("La lista 5 de 100000 elementos tardó en segundos: ", fin-inicio)

