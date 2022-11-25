# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 10:43:46 2021

@author: andre
"""

lista=[100,200,300,400,500,600]
print(lista[3])  #Imprime 400 (el valor en el índice 3 de la lista).
print(lista[:3])  #Imprime los valores entre el inicio (índice 0) y el
#índice 2 de la lista (es decir, imprime [100,200,300]).
print(lista[3:])  #Imprime los valores entre el índice 3 y el final (índice 5)
#de la lista (es decir, imprime [400,500,600]).
print(lista[::2])  #Imprime de dos en dos los valores desde el inicio
#(índice 0) hasta el final de la lista (es decir, imprime [100,300,500]).
print(lista[::-2])  #Imprime de dos en dos los valores desde el último de
#la lista hasta el primero (es decir, imprime [600,400,200]).
print(lista[1:4])  #Imprime la rebanada que consiste de los valores que
#están entre el índice 1 y el índice 3 de la lista (es decir, imprime
#[200,300,400]).
print(lista[-5:-2])  #Imprime la rebanada que consiste de los valores que
#están entre el índice -5 (que equivale a 1) y el índice -3 (que equivale a
#4).  Es decir, imprime la misma rebanada que se imprime en el ejemplo
#anterior: [200,300,400].
print(lista[1:4][1])  #Imprime el segundo de los elementos (el que está en el
#índice 1) de la rebanada especificada en la instrucción anterior (es
#decir, imprime 300).
lista[1:4][1]=800  #Cambiamos el valor del segundo elemento de la rebanada
#especificada en las dos instrucciones anteriores (de 300 a 800).
print(lista)  #Imprime la lista completa (es decir, imprime [100,200,300,
#400,500,600]), con lo cual se puede ver que la modificación del segundo
#elemento de la rebanada no afectó la lista original, por lo que la rebanada
#se almacenó por separado en otra parte de la memoria de la computadora (no
#fue una "vista" hacia los elementos originales de la lista, sino que se creó
#una sublista con los elementos especificados por la rebanada, y fue en esta
#sublista donde ocurrió el cambio al valor del segundo elemento).
print(lista[1:4])  #Se imprime otra vez la rebanada que consiste de los
#valores que están entre el índice 1 y el índice 3 de la lista (es decir,
#imprime [200,300,400]), con lo cual podemos ver que cada vez que se pide
#una rebanada, ésta se construye otra vez (en otra parte de la memoria,
#como se mencionó en el punto anterior), puesto que en caso contrario
#hubiéramos tenido un 800 en lugar de un 300 como segundo elemento de la
#rebanada después del cambio que le hicimos anteriormente.
#En la siguiente secuencia de instrucciones podemos ver el mismo efecto, pero
#colocando explícitamente la rebanada en una variable distinta (por lo tanto
#en una parte distinta de memoria) antes de realizar el cambio, y viendo
#que dicho cambio ocurre sólo en la sublista especificada por la rebanada, a
#la cual afecta permanentemente, no en la lista original, la cual nunca se
#ve afectada:
sublista=lista[1:4]
print(sublista)  #Imprime [200,300,400].
sublista[1]=800
print(sublista)  #Imprime [200,800,400].
print(lista)  #Imprime [100,200,300,400,500,600].
#Todas estas pruebas con los cambios a las sublistas creadas basándose en
#las especificaciones de las rebanadas no se podrían haber hecho con cadenas
#de caracteres, puesto que ellas son inmutables, al contrario de las listas...
#pero debido a que las cadenas de caracteres son inmutables, me imagino que
#las rebanadas en las cadenas no son copias del original, sino "vistas"
#construidas de una forma computacionalmente eficiente hacia algunos de los
#elementos de las cadenas originales, al contrario de lo que ocurre con las
#listas.
