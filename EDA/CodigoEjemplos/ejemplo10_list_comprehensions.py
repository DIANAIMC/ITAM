# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 10:53:30 2021

@author: andre
"""

x=[i for i in range(10) if i%2==0]  #El argumento de "range" es excluyente.
print(x)  #Imprime: [0, 2, 4, 6, 8]

#El código anterior es más compacto que el siguiente, que logra un
#resultado equivalente:
x=[]
for i in range(10):
    if i%2==0:
        x=x+[i]
print(x)  #Imprime: [0, 2, 4, 6, 8]

#Como una extensión del concepto de las rebanadas, suponiendo que ya exista
#una lista también se pueden crear sublistas, o incluso sublistas
#modificadas, a través de filtros parecidos al del ejemplo de "list
#comprehension" arriba, como se muestra en el siguiente ejemplo:
lista1=[1,2,3,4]
lista2=[elem*2 for elem in lista1 if elem>1]
print(lista2)  #Imprime: [4,6,8]
