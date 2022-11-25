# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 10:29:57 2021

@author: andre
"""

frase="hola mundo"
print("1",frase[0])  #Imprime "h", el elemento 0
print("2",len(frase))  #Imprime 10
#Provocaría el lanzamiento de una excepción de tipo IndexError (con un mensaje
#de error: "string index out of range"):
#print(frase[10])
#Provocaría el lanzamiento de una excepción de tipo TypeError (con un mensaje
#de error: "'str' object does not support item assignment") debido a que las
#cadenas son inmutables:
#frase[2]="z"
print("3",frase[-len(frase)])  #Imprime "h", el elemento -10, que es
#equivalente al 0.
print("4",frase[0:6])  #Imprime "hola m", los elementos 0 al 5 de la frase
print("5",frase[-10:-4])  #Imprime "hola m", los elementos -10 al -5 (que
#equivale al 5)
#Es muy importante el orden en el que se especifican los límites de la
#"rebanada":
print("6",frase[-4:-10])  #Imprime "" (cadena vacía) puesto que el
#índice izquierdo no puede estar más a la derecha que el índice derecho
#de la "rebanada" para que exista una subcadena
print("7",frase[:6])  #Imprime "hola m", los primeros elementos hasta el
#número 5 de la frase
print("8",frase[6:])  #Imprime "undo", los últimos elementos desde el
#número 6 de la frase
#Ahora algunos ejemplos con "salto" (tercera componente en la
#especificación de la "rebanada"):
print("9",frase[0:6:2])  #Imprime los primeros "seis" caracteres
#saltándose uno de cada dos (es decir, realmente imprime sólo
#tres caracteres, "hl ")
print("10",frase[-10:-4:3])  #Imprime los caracteres del 0
#(equivalente a -10) al 5 (equivalente al -5), saltándose dos de
#cada tres, por lo tanto imprimiendo "ha"
print("11",frase[::4])  #Imprime uno de cada cuatro caracteres de
#principio a fin de la frase (por lo tanto imprimiendo "h d")
#Si el salto es negativo, entonces se procesa de derecha a izquierda la
#cadena de caracteres, y entonces cambian las interpretaciones de las
#primeras dos partes de la especificación de la rebanada: ahora la primera
#es el extremo derecho de la rebanada (sigue siendo el inicio, y sigue siendo
#incluyente) y la segunda es el extremo izquierdo de la rebanada (sigue
#siendo el final, y sigue siendo excluyente), como muestran los siguientes
#ejemplos:
print("12",frase[::-2])  #Imprime uno de cada dos caracteres del
#fin al principio de la frase debido al salto negativo ("onmao").
print("13",len(frase[::-2]))  #Cuenta cuántos caracteres hay en la
#rebanada anterior (5).
print("14",frase[-4:-10:-3])  #Imprime, debido al salto negativo, los
#caracteres del -4 (equivalente al 6) al -9 (equivalente al 1),
#saltándose dos de cada tres, por lo tanto imprimiendo "ua".
print("15",frase[6:1:-3])  #Imprime exactamente lo mismo ("ua") que el
#ejemplo anterior debido a las equivalencias de los índices ("ua").
