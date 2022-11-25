#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 17:29:19 2021

@author: dianam
"""

def printList(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print()
    
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
            if(isinstance(Izq[i], str()) or isinstance(Der[j], str())):
                if(isinstance(Izq[i], str())):
                    auxI=len(Izq[i])
                else:
                    auxI=Izq[i]
                if(isinstance(Der[j], str())):
                    auxD=len(Der[j])
                else:
                    auxD=Izq[j]
                if auxI < auxD:
                    arr[k] = auxI
                    i += 1
                else:
                    arr[k] = auxD
                    j += 1
                k += 1 
                
            else: 
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


   
listaObjetosRandom = [1, 8, 24, 2, 4]
print("Given array is", end="\n")
printList(listaObjetosRandom)
print("Reverse array is: ", end="\n")
mergeSort(listaObjetosRandom)
printList(listaObjetosRandom)