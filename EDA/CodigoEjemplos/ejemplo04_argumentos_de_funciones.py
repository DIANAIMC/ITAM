# -*- coding: utf-8 -*-
"""
Created on Fri Jan 22 09:55:50 2021

@author: andre
"""

def tarjeta_de_credito(nombre,numero,limite_de_credito=6000):
    #Cuerpo de la función incluyendo un "return" en caso necesario
    print(limite_de_credito)
a=tarjeta_de_credito("Chandrika Bandaranaike Kumaratunga",7828932988384988)
b=tarjeta_de_credito("Neymar",1283928366129473,8)

def funcion(mensaje,valor_num1,valor_num2):
    valor_final=valor_num1+valor_num2
    print("El mensaje es: "+mensaje+" y la suma es:",valor_final)
funcion("hola mundo",5,6) #Imprime correctamente
#Pero la siguiente invocación marca error por no colocar los argumentos en las
#posiciones correctas (lo cual llevaría a Python a tratar de sumar o
#concatenar un entero, 6, con una cadena de caracteres, en la 1ª línea de
#código dentro del cuerpo de la función arriba, que es donde ocurre el error
#en tiempo de ejecución):
#funcion(5,6,"hola mundo")
#
#Por otra parte en el siguiente ejemplo las dos invocaciones a la función
#funcionan perfectamente aunque no se respeta el orden en el que se
#definieron los parámetros a la hora de invocar la función por segunda vez,
#debido a que la segunda invocación usa palabras clave para identificar los
#argumentos reales (i.e., para indicar cómo deben ser interpretados):
def funcion2(mensaje,valor_num1,valor_num2):
    valor_final=valor_num1+valor_num2
    print("El mensaje es: "+mensaje+" y la suma es:",valor_final)
funcion2("hola mundo",5,6) #Imprime correctamente
funcion2(valor_num1=5,valor_num2=6,mensaje="hola mundo") #También imprime
# correctamente

#Regresa dos valores: el promedio de la lista de valores numéricos que se le
#entrega y la cantidad de valores que tuvo dicha lista:
def funcion3(lista):
    suma=0.0
    n=len(lista)
    for i in range(0,n):
        suma=suma+lista[i]
    prom=suma/n
    return prom,n
    #Hubiera funcionado exactamente igual si se hubiera hecho:
    #return (prom,n)
#Se puede invocar la función así:
p,num=funcion3([1,2,3,4])
print("Promedio:",p,"Cantidad:",num) #Imprime: Promedio: 2.5 Cantidad: 4
#También se puede invocar así (con una tupla explícita):
tup=funcion3([1,2,3,4])
print("Promedio:",tup[0],"Cantidad:",tup[1]) #Imprime lo mismo que arriba.
print(tup) #Imprime (2.5, 4)
