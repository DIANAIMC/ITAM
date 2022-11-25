# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 11:09:54 2021

@author: andre
"""

a={1,2,3,4}
b={3,4,5,6}
c=a|b  #Unión
print(c)  #Imprime: {1,2,3,4,5,6}
print(a&b)  #Intersección (imprime: {3,4})
#La siguiente instrucción provocaría un error de sintaxis ("set object is
#not subscriptable") debido a que los conjuntos no tienen índices:
#print(a[1])
d={"a",3,4.5}
#El orden en el que se imprimen los elementos de un conjunto no necesariamente
#corresponde al orden en el que se agregaron dichos elementos:
print(d)  #Imprime: {3,"a",4.5}...a veces (pero puede imprimirse cualquier
#otra permutación de los mismos elementos).
#Prueba de que son mutables los conjuntos:
d.add("k")
print(d)  #Imprime: {"k",3,"a",4.5} o alguna permutación de los mismos
#elementos.
#Pruebas con el operador subconjunto (abierto y cerrado):
print(d<c)  #Imprime: False
print(d<=c)  #Imprime: False
conj1={1,2,3}
conj2={3,2,1}
print(conj1==conj2)  #Imprime: True (porque todos los elementos de "conj1"
#están en "conj2" y viceversa).
print(conj1<conj2)  #Imprime: False (porque "conj1" no es un subconjunto propio de "conj2").
print(conj1<=conj2)  #Imprime: True (porque "conj1" sí es un subconjunto,
#aunque no sea un subconjunto propio, de "conj2").
