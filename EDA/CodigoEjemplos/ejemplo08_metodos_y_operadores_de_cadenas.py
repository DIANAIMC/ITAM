# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 10:33:05 2021

@author: andre
"""

frase="hola mundo"

print(frase.count("mu"))  # Imprime 1 porque sólo aparece la subcadena "mu"
#una vez dentro de la frase.
print(frase.count("o"))  # Immprime 2 porque la subcadena "o" aparece dos
#veces dentro de la frase.
print(frase.count("z"))  # Imprime 0 porque la subcadena "z" no aparece ni una
#sola vez dentro de la frase.
print(frase.count(""))  # Imprime 11 porque la cadena vacía cabe una vez en
#cada uno de los 11 _huecos_ que hay entre las diez letras que forman la
#frase.

print(frase.find("mu"))  # Imprime 5 porque a partir del índice 5 de la frase
#es que aparece la subcadena "mu".
print(frase.find("o"))  # Imprime 1 porque la primera "o" de la frase está en
#el índice 1.
print(frase.find("o",2))  # Imprime 9 porque la segunda "o" de la frase
#está en el índice 9.
print(frase.find("o",3))  # Imprime 9 porque, aunque no hay una tercera "o"
#dentro de la frase, la última (que resulta ser la segunda) "o" está en el 
#índice 9.
print(frase.find("z"))  # Imprime -1 para indicar que no aparece la subcadena
#"z" en ninguna parte de la frase.

#Muy parecido al bloque de instrucciones anterior, pero al usar el método
#"index" en lugar de "find" se lanza una excepción en lugar de regresar un -1
#cuando no aparece la subcadena especificada en el primer argumento dentro de
#la frase (debido a lo cual se comentó la última instrucción):
print(frase.index("mu"))  
print(frase.index("o"))
print(frase.index("o",2))
print(frase.index("o",3))
#print(frase.index("z"))

print(frase.islower())  # Imprime True porque todas las letras de la frase son
#minúsculas.
print("bla bla 123 bla, bla".islower())  #Imprime True porque todas las letras
#de esta nueva frase son minúsculas (y no le hace caso a los caracteres que no
#son alfabéticos).

print(frase.istitle())  # Imprime False porque no todas las palabras que
#forman parte de la frase (de hecho, en este caso ninguna de ellas) empieza
#con mayúscula.
print("Stairway To Heaven".istitle())  # Imprime True porque todas las
#palabras que forman parte de la frase empiezan con mayúscuas.
print("Stairway 123 To3 Heaven".istitle())  # Imprime True porque todas las
#palabras que forman parte de la frase empiezan con mayúsculas (si empiezan
#con letras...y no se les hace caso a las que empiezan con otros catacteres).
print("Stairway 123 to3 Heaven".istitle())  # Imprime False porque una de las
#palabras que forman parte de la frase (en este caso la tercera) no comienza
#con mayúscula.

print(frase.title())  # Imprime "Hola Mundo" porque hace que todas las
#palabras que formen parte de la frase empiecen con mayúsculas.
print(frase.capitalize())  # Imprime "Hola mundo" porque hace que la primera
#palabra que forma parte de la frase empiece con mayúscula (si es que empieza
#con una letra).
print("123 hola mundo".capitalize())  # Imprime "123 hola mundo" porque hace
#que la primera palabra que forma parte de la frase empiece con mayúscula
#(pero en este caso la primera palabra no empieza con letra, así es que la
#deja, al igual que el resto de la frase, tal cual).

cad="hola mundo"
print(cad<"hola mundo ")  #Imprime: True
print(cad=="hola mundo")  #Imprime: True
print(cad>="gola mundo")  #Imprime: True
print("a"!=cad)  #Imprime: True
print("a"==cad)  #Imprime: False
print(cad+cad)  #Imprime: "hola mundohola mundo"
print(cad+" cruel")  #Imprime: "hola mundo cruel"
print(cad*5)  #Imprime: " hola mundohola mundohola mundohola mundohola mundo"

