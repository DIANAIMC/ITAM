 # -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 11:14:27 2021

@author: andre
"""

cadena="abcde"
lista=["a","b","c","d","e"]
tupla=("a","b","c","d","e")
conjunto={"a","b","c","d","e"}
conjunto_congelado=frozenset({"a","b","c","d","e"})
diccionario={"Coches":["Volvo","Ford","Toyota"],
             "Animales":["León","Elefante","Oso"],
             "Colores":["Rojo","Naranja","Amarillo","Verde","Azul","Violeta"]}

#Se puede iterar sobre una cadena:
print("Cadena:")
res=""
for x in cadena:
    res=res+x+" "
print(res)
print(len(res))

#Se puede iterar sobre una lista:
print("Lista:")
res=""
for x in lista:
    res=res+str(x)+" "
print(res)

#Se puede iterar sobre una tupla:
print("Tupla:")
res=""
for x in tupla:
    res=res+str(x)+" "
print(res)

 

#Se puede iterar sobre un conjunto, pero el orden en el que se visitarán
#sus elementos es arbitrario y no necesariamente coincide con el orden en
#el que se hayan agregado/indicado al crear el conjunto:
print("Conjunto:")
res=""
for x in conjunto:
    res=res+str(x)+" "
print(res)

#Se puede asignarle una posición (un índice) explícitamente a cada elemento
#de un conjunto mediante el uso de la función "enumerate", que crea tuplas
#índice-valor, pero de todas formas quedan en un orden arbitrario al iterar,
#así es que no es muy útil:
print("Enumerate de un conjunto, versión 1:")
res=""
en=enumerate(conjunto)
print(en)  #Objeto de tipo "enumerate"
for x in en:
    res=res+str(x)+" "
print(res)
#Aquí se extrae únicamente el valor de cada tupla índice-valor que resulte de
#la llamada a "enumerate" (si no se incluye la segunda llamada a "enumerate"
#no funciona por alguna razón...parece que se "corrompe" el resultado de la
#llamada anterior después de iterar sobre ella):
print("Enumerate de un conjunto, versión 2:")
res=""
en=enumerate(conjunto)
for z,y in en:
    res=res+str(y)+" "
print(res)

#Se puede iterar sobre un conjunto congelado, pero el orden en el que se
#visitarán sus elementos es arbitrario y no necesariamente coincide con el
#orden en el que se hayan agregado/indicado al crear el conjunto congelado,
#al igual que con los conjuntos "normales" (no congelados), así es que no es
#muy útil:
print("Conjunto congelado:")
res=""
for x in conjunto_congelado:
    res=res+str(x)+" "
print(res)

#Se puede iterar sobre un diccionario, pero de esta forma sólo se van a extraer
#las llaves (que en teoría, debido a que los pares llave-valor de los
#diccionarios no tienen un orden entre ellos, podrían extraerse/imprimirse en
#cualquier orden arbitrario, no necesariamente en el orden en el que se
#ingresaron al crear el diccionario, ya que los diccionarios son como conjuntos):
print("Iteración sobre (los valores clave/llave de) un diccionario:")
res=""
for x in diccionario:
    res=res+str(x)+" "
print(res)


#Se puede hacer de esta manera para ver el diccionario completo (aunque cada
#par llave-valor lo presenta Python como una tupla):
print("Iteración sobre el diccionario completo (pares clave-valor):")
res=""
for x in diccionario.items():
    res=res+str(x)+" "
print(res)

#Si se deseara extraer sólo los valores del diccionario, se puede:
print("Iteración sobre los valores de un diccionario, versión 1:")
res=""
for ind,val in diccionario.items():
    res=res+str(val)+" "
print(res)

#Muchos acostumbran hacer lo anterior de la sig. manera (usando la "variable
#anónima" de Prolog como primer elemento de cada tupla, ya que no se va a usar
#más adelante), pero en realidad "_" es un nombre de variable válido en
#Python, y ocupa memoria, como se puede ver a través del "print" que se incluyó
#dentro del "for", así es que realmente es equivalente a la versión anterior
#(en donde se usó "ind" en lugar de "_" para el primer elemento de cada tupla):
print("Iteración sobre los valores de un diccionario, versión 2:")
res=""
for _,val in diccionario.items():
    print(_)
    res=res+str(val)+" "
print(res)

#Si no se desea iterar por completo sobre una colección (que es lo que hace
#la instrucción "for"), se puede iterar parcialmente obteniendo un objeto
#iterador (que permite iterar sobre la colección de interés), usando la función
#"next" explícitamente cada vez que uno quiere moverse al siguiente dato de la
#colección, y usando "while" para que las repeticiones se puedan detener antes
#de terminar de iterar por completo (en caso de que así se desee).  Aquí se
#ejemplifica con una lista, pero se puede hacer lo mismo con cualquier tipo de
#colección: 
print("Iteración parcial sobre los elementos de una lista:")
#Obtiene un objeto que sirva para iterar sobre la lista
it=iter(lista)
#Regresa el siguiente dato dentro de la colección sobre la cual se está
#iterando (ojo: el argumento no es la colección, sino un objeto iterador
#asociado con la colección):
elemento=next(it)
res=""
while(elemento!="d"):
    res=res+str(elemento)+" "
    elemento=next(it)
print(res)

#Otras dos versiones, esta vez llegando a iterar sobre toda la colección, lo
#cual hace que se lance una excepción de tipo StopIteration cuando se intente
#usar "next" en caso de que no haya un siguiente elemento de la colección en
#ese momento.  Los "try-except" sirven para manejar la excepción y hacer que
#el programa siga ejecutándose cuando ocurre, en lugar de "tronar" en ese
#momento, así robusteciendo el programa:
print("Iteración completa con 'while' sobre los elementos de una lista:")
it=iter(lista)
elemento=next(it)  #Aquí sabemos que va a haber por lo menos un dato
res=""
try:
    while(elemento!="z"):
        res=res+str(elemento)+" "
        elemento=next(it)  #Aquí es donde podría ocurrir la excepción
except StopIteration:
    print("Se acabó la colección")
print(res)

#Aquí la lista está vacía, por lo que el primer "next" (antes del ciclo) es
#el que debe lanzar la excepción, no el "next" que se tiene dentro del ciclo:
print("Iteración con 'while' sobre los elementos de una lista vacía:")
lis=[]
it=iter(lis)
try:
    elemento=next(it)  #Aquí debe lanzarse la excepción porque no hay datos.
    #No se debe ejecutar el resto de lo que hay dentro del "try", debido a que
    #debe haber ocurrido una excepción en la instrucción anterior, por lo que
    #el flujo de la ejecución debe pasar al "except" que corresponda a la
    #excepción ocurrida (o a un "except" general):
    res=""
    while(elemento!="d"):
        res=res+str(elemento)+" "
        elemento=next(it)
        print(res)
except StopIteration:
    print("No hay elementos en la lista sobre los que se pueda iterar.")
