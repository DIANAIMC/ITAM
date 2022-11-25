# -*- coding: utf-8 -*-
"""
Created on Fri Jan 22 09:36:21 2021

@author: andre
"""

#Definición de una clase Entero con un atributo "valor" (cuyo valor estoy
#suponiendo que será un número entero):
class Entero:
    #No se tiene que listar el atributo además de los métodos (aunque
    #se podría, por ejemplo si se desea asignarle un valor por omisión)...
    #en este ejemplo el atributo queda implícito por la forma en la que está
    #definido el constructor.
    #Constructor:
    def __init__(self,valor):
        self.valor=valor
    #Equivalente a toString:
        def __str__(self):
            return str(self.valor)
    #Equivalente a toString pero usado cuando se imprime una lista de objetos
    #(y en otros contextos)...si no se definiera este método, abajo no se
    #vería información útil/amigable al hacer "print(lista1)":
    def __repr__(self):
        return str(self.valor)
    #Sirve para poder hacer algo parecido al compareTo (método "less than"):
    def __lt__(self,other):
        return self.valor<other.valor

#Creación e impresión de varias instancias (y una lista de instancias)
#de la clase Entero:
obj1=Entero(1)
obj2=Entero(2)
obj3=Entero(3)
obj4=Entero(4)
obj5=Entero(5)
obj_14=Entero(-14)
print(obj2)
print(obj4)
lista1=[obj1,obj2,obj3,obj4,obj5,obj_14]
print(lista1)

