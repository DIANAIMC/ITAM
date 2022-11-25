#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep 30 19:33:05 2021

@author: dianam
"""
#Clase Alumno, quisimos implementar varios elementos extra solamente para prácticar 
#aunque no sean usados realmente
class Alumno():
    
    #Constructor de la clase
    def __init__(self,nombre,cu,carrera,beca):
        self.nombre=nombre
        self.cu=cu
        self.carrera=carrera
        self.beca=beca
     
    #Getters
    def getNombre(self):
        return self.nombre
    
    def getCu(self):
        return self.cu
    
    def getCarrera(self):
        return self.carrera
    
    def getBeca(self):
        return self.beca
    
    #Setters
    
    def setNombre(self,nom):
        self.nombre=nom
        
    def setCu(self, newCU):
        self.cu=newCU
        
    def setCarrera(self,carr):
        self.carrera=carr
        
    def setBeca(self,bec):
        self.beca=bec
        
    def __eq__(self, other):
        return self.cu == other.cu
    
    def __lt__(self, other):
        return self.cu < other.cu
    
    def __str__(self):
        if(self.beca == True):
            bec="tiene beca"
        else:
            bec="no tiene beca"
        print(self.nombre, self.cu, self.carrera, bec)
        
#Método que se van a experimentar
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

def insertionSort(array):
    if(len(array) == 0):
        print("La lista está vacía, no hay nada que ordenar") 
    #queremos ir añadiendo los números acomodados a nuestra sorted list 
    for i in range(1, len(array)): 
        j = i
        #mientras que el número que queremos insertar es mayor a 0 
        #(es decir que todavía no llegamos a nuestra sorted list) 
        #& mientras nuestro número actual es menos que el número 
        #inmediatamente anterior a él
        while j > 0 and array[j] < array[j-1]: 
            swap(j, j-1, array)
            #j está siguiendo el número que buscamos insertar
            j -= 1 
    return array

#Método auxiliar que intercambia dos datos de la lista
def swap(i, j, array):
  array[i], array[j] = array[j], array[i]

#Imprime una lista dada
def printList(arr):
    for i in range(len(arr)):
        print(arr[i].__str__(), end=" ")
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

#instanciamos todos nuestros alumnos
diana = Alumno("Diana", 196914, "Ciencia de Datos", False)
yuliana = Alumno("Yuliana", 188037, "Ciencia de Datos", True)
mariel = Alumno("Mariel", 195902, "Ingenieria en Computación", True)
miguel = Alumno("Miguel", 181365, "Derecho", False)
sebas = Alumno("Sebastián", 187534, "Derecho", False)
fulanito = Alumno ("Fulanito", 202120, "Economía", True)
perenganito = Alumno("Perenganito", 176529, "Dirección Financiera", False)
andres = Alumno("Andrés", 202020, "Ingeniería en Computación", False)
esponda = Alumno("Esponda", 197654, "ciencia de Datos", True)
fosil = Alumno("Fósil", 113021, "Economía", False)

#creamos nuestra lista
lista = [diana, yuliana, mariel, miguel, sebas, fulanito, perenganito, andres, esponda, fosil]

#
#CASO NORMAL
#

#MERGESORT
print("MERGESORT")
print("El arreglo dado es", end="\n")
randomListInt(lista, 0)
printList(lista)
inicio = time.time()
mergeSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista de 10 elemento tardó en segundos: ", fin-inicio)

#SELECTIONSORT
print("SELECTIONSORT")
print("El arreglo dado es", end="\n")
randomListInt(lista, 0)
printList(lista)
inicio = time.time()
selectionSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista de 10 elemento tardó en segundos: ", fin-inicio)

#INSERTIONSORT
print("INSERTIONSORT")
print("El arreglo dado es", end="\n")
randomListInt(lista, 0)
printList(lista)
inicio = time.time()
mergeSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista de 10 elemento tardó en segundos: ", fin-inicio)  

#
#PEOR CASO
#

#MERGESORT
print("MERGESORT")
print("El arreglo dado es", end="\n")
randomListInt(lista, 0).sort(reverse=True)
printList(lista)
inicio = time.time()
mergeSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista de 10 elemento tardó en segundos: ", fin-inicio)

#SELECTIONSORT
print("SELECTIONSORT")
print("El arreglo dado es", end="\n")
randomListInt(lista, 0).sort(reverse=True)
printList(lista)
inicio = time.time()
selectionSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista de 10 elemento tardó en segundos: ", fin-inicio)

#INSERTIONSORT
print("INSERTIONSORT")
print("El arreglo dado es", end="\n")
randomListInt(lista, 0).sort(reverse=True)
printList(lista)
inicio = time.time()
mergeSort(lista)
fin = time.time()
print("El arreglo ordenado es: ", end="\n")
printList(lista)
print("La lista de 10 elemento tardó en segundos: ", fin-inicio)


        
    
    
    