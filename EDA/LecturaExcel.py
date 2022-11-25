#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov 12 12:42:23 2021

@author: Diana, Mariel
"""

import csv

csv_file = 'netflix_titles.csv'
txt_file = 'netflixTitles.txt'
with open(txt_file, "w") as my_output_file:
    with open(csv_file, "r") as my_input_file:
        [ my_output_file.write("/".join(row)+'\n') for row in csv.reader(my_input_file)]
    my_output_file.close()
    
def lee(archivo):
    id = open(archivo, "r")
    contenido = id.read()
    lista=contenido.split("\n") #cada enter es un nuevo elemento de la lista
    id.close()
    return lista

# Lectura de archivos y creación de lista con elementos de clase 'Pelicula'
# Como entrada se tiene 'nLin': el número de películas que se desea leer 
# del archivo "titles.txt"
# Regresa una lista con los elementos en su interior. 
def listaTitulos():
    listaNetflix = lee("/Users/marielsgtzz/Desktop/ITAM/Otoño2021/EDA/netflixTitles.txt")
    return listaNetflix

titulos = listaTitulos()


t=[]
i=0
#para excluir la s del ID para tener un dato de tipo entero
for titulo in titulos:
    aux = titulos[i]
    a2 = aux[1:]
    t.append(a2)
    i = i+1
    

txt = open("titulosNetflix.txt", "w")
for titulo in t:
    txt.write(titulo + "\n")
txt.close()