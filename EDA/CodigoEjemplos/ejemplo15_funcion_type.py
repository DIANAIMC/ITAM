# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 11:16:23 2021

@author: andre
"""

#En este ejemplo se crea una lista heterogénea que contiene un número entero,
#un número real, una cadena de caracteres, un valor booleano, una tupla y un
#tipo de datos:
lista=[1,3.5,"what?",True,(1,"bla"),bool]
print(lista)
#Dentro del ciclo se procesan los elementos de la lista, se detecta su tipo,
#y dependiendo del tipo se imprime un mensaje distinto.  La detección del
#tipo se logra a través de la función predefinida "type" y se compara el
#valor obtenido (que es un objeto de tipo "type", no es una cadena de
#caracteres ni nada por el estilo) con cada uno de cinco opciones previstas
#(además de contar con un "else" para cualquier otra opción):
for i in lista:
    t=type(i)
    if t==int:
        print("Es un número entero.")
    elif t==float:
        print("Es un número real.")
    elif t==str:
        print("Es una cadena de caracteres.")
    elif t==bool:
        print("Es un valor booleano.")
    elif t==type:
        print("Es un tipo de datos.")
    else:
        print("Es algún otro tipo de valor.")
