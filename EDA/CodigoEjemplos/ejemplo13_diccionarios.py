# -*- coding: utf-8 -*-
"""
Created on Fri Jan 29 11:12:30 2021

@author: andre
"""

d1={1:"cadena de caracteres",2:[12,22]}
d2={"animales":("elefante","leon","antílope"),"coches":("renault","volvo","ford")}
print(d1.keys())  #Imprime: dict_keys([1,2])
print(d2.keys())  #Imprime: dict_keys(["animales","coches"])
print(d1.values())  #Imprime: dict_values(["cadena de caracteres",[12,22]])
print(d2.values())  #Imprime: dict_values([("elefante","leon","antílope"),
#("renault","volvo","ford")])

print(d1[2])  #Imprime: [12,22]
print(d2["coches"])  #Imprime: ("renault","volvo","ford")
