# -*- coding: utf-8 -*-
"""
Created on Fri Jan 15 10:10:24 2021

@author: andre
"""

#Clase que representa una excepción no predefinida, cola vacía:
class EmptyQueueException(RuntimeError): 
    def __init__(self, arg): 
        self.args = arg 

#Clase que usa una lista de Python para implementar el concepto de cola.
#Supone que se agregan los elementos a la derecha (es decir, en el extremo
#con los índices más grandes, usando el método "append") de la lista
#conforme va creciendo (y por lo tanto se deben eliminar del lado
#izquierdo, usando el método "pop").  Las listas de Python (y sus métodos)
#se explicarán en detalle más adelante:
class ListQueue:
    #Constructor (inicialmente va a estar vacía la cola):
    def __init__(self):
        self.datos=[]
    def enqueue(self,dato):
        self.datos.append(dato)
    def dequeue(self):
        if(not self.is_empty()):
            res=self.datos[0]
            self.datos.pop(0)
            return res
        else:
            raise EmptyQueueException("La cola está vacía...")
#            print("Cola vacía...no se puede eliminar un dato.")
    def first(self):
        if(not self.is_empty()):
            return self.datos[0]
        else:
            raise EmptyQueueException("La cola está vacía...")
#            print("Cola vacía...no existe ningún dato.")
    def is_empty(self):
        return self.datos==[]

#Pruebas:    
cola1=ListQueue()  #Se crea vacía la cola.
#El try-except termina imprimiendo un mensaje de error (es decir, se
#ejecuta el "except" porque no funciona el intento ("try") de eliminar un
#dato de la cola:
try:
    cola1.dequeue()
except EmptyQueueException:
    print("Error...")
cola1.enqueue(33)  #Ahora sí se agrega un dato a la cola.
#Se imprime el primer dato de la cola, sin alterar su contenido:
print(cola1.first())
#Se elimina un dato de la cola (no lo puse dentro de un "try" porque sé que
#va a terminarse de ejecutar la operación exitosamente):
cola1.dequeue()
print(cola1.is_empty())  #Se imprime "True" porque quedó vacía la cola.
