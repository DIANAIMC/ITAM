# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 11:07:27 2021

@author: andre
"""

tupla1=(1,2)
tupla2=3,4
print(tupla1)  #Imprime: (1,2)
print(tupla2)  #Imprime: (3,4)
tupla3=5,
print(tupla3)  #Imprime: (5,)

tupla=([1],2,3)
tupla[0][0]=8  #El primer 0 indica que queremos acceder al primer
#elemento de la tupla, que resulta ser una lista…el segundo 0 indica que es el
#primer elemento de ese primer elemento (de la lista) el que queremos
#modificar.
print(tupla)  #Imprime: ([8],2,3)
