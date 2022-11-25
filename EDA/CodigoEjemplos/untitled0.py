#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 24 19:56:51 2021

@author: Mariel, Diana y Yuliana
"""

import math
import time
from matplotlib import pyplot


#%% Clase Titulo


# Clase Título
class Titulo:
    # Constructor con valores esperados:
    def __init__(self, id, tipo, titulo, directorx, reparto, pais, fechaN, fechaE, calificacion, duracion, categoria, descripcion):
        self.id = id 
        self.tipo = tipo 
        self.titulo = titulo
        self.directorx = directorx 
        self.reparto = reparto 
        self.pais = pais
        self.fechaN = fechaN #Fecha en que se agregó a Netflix
        self.fechaE = fechaE #Fecha de estreno
        self.calificacion = calificacion 
        self.duracion = duracion
        self.categoria = categoria
        self.descripcion = descripcion
    
    # Getters necesarios 
    def getId(self):
        return self.id
    def getTipo(self): 
        return self.tipo
    def getTitulo(self):
        return self.titulo
    def getDirectrx(self):
        return self.directorx
    def getReparto(self):
        return self.reparto
    def getPais(self):
        return self.pais
    def getFN(self):
        return self.fechaN
    def getFE(self):
        return self.fechaE
    def getCali(self):
        return self.calificacion 
    def getDuracion(self):
        return self.duracion
    def getCategoria(self):
        return self.categoria
    def getDescripcion(self):
        return self.descripcion
    
    #Get Key:
    #El valor clave asociado a los objetos título va a ser su id
    def getKey(self):
        return self.id
    
    def __str__(self):                                                                                                                                                                                                               
        return "ID: " + str(self.id) + "Tipo: " + str(self.tipo) + "Titulo: " + str(self.titulo) + "Directorx: " + str(self.directorx) + "Reparto: " + str(self.reparto) + "Pais: " + str(self.pais) + "Fecha Netflix: " + str(self.fechaN) + "Fecha Estreno: " + str(self.fechaE) + "Calificacion: " + str(self.calificacion) + "Duracion: " + str(self.duracion) + "Categoria: " + str(self.categoria) + "Descripcion: " + str(self.descripcion)
    
    # Método equivalente a toString() para cuando la instancia se
    # encuentra en alguna colección.
    # El 'return' muestra solamente el 'id' del título. Esta variante
    # facilita la lectura del orden de los datos en una colección, pues 
    # si se imprime una lista con muchos datos de películas, convendría
    # no tener todos los atributos, sino solo aquellos que nos sirvan para
    # su análisis.
    def __repr__(self):
        #return str(self.id)+" ("+str(self.aho)+") "+" : "+self.nombre
        return str(self.id)
    
    def __lt__(self, otro):
        return self.id < otro.id


# Lectura de archivos y creación de lista con elementos de clase 'Título'
def lee(archivo):
    id = open(archivo, "r")
    contenido = id.read()
    lista=contenido.split("\n") #cada enter es un nuevo elemento de la lista
    id.close()
    return lista


# Regresa una lista con los elementos en su interior. 
def listaTitulos(nLin):
    lista = []
    
    i = 0
    lee = open('/Users/dianam/Desktop/CodigoEjemplos/netflixTitles.txt')
    while i < nLin:
        linea = lee.readline()
        # Se ocupa el método {split()} para separar los valores que se
        # encuentran por línea en el documento de texto.  Regresa una lista con estos valores.
        valores = linea.split('/')
        titulo = Titulo(int(valores[0]),valores[1], valores[2], valores[3], valores[4], valores[5], valores[6], valores[7], valores[8], valores[9], valores[10], valores[11] )
        lista.append(titulo)
        i += 1
    lee.close()
    print (lista)
    return lista




#%% Clase Hash Node

"""
    HASH NODE y HASH TABLE ---------------------------------------------------
"""

# Clase HashNode
class HashNode:
    
    # Constructor:
    #   elem - cualquier tipo de dato, 
    #          en este caso se almacenan títulos.
    #   next - Hash Node
    def __init__(self, elem):
        self.elem = elem
        self.next = None
    
    
    # Getters necesarios
    def getElem(self):  # Elemento
        return self.elem
    def getNext(self):  # Nodo
        return self.next
    
    
    # Setters necesarios
    def setElem(self,e):    # Elemento
        self.elem = e
    def setNext(self,n):    # Nodo
        self.next = n


    # GetKey:
    # Se extrae el valor llave propio del elemento guardado en el nodo.
    def getKey(self):
        return self.elem.getKey()




#%% Clase HashTable

# Clase HashTable
class HashTable:
    
    # Constructor
    def __init__(self, tamano):
        # Se crea una lista del tamaño dado como parámetro y en cada casilla
        # se guarda a un Nodo Hash que contiene un 'None' como elemento.
        #   Estos nodos son los 'centinelas' de las listas que se guardarán
        #   en cada casilla de la tabla para su veloz acceso.
        self.tabla = [HashNode(None) for i in range(tamano)]
        self.cont = 0
    
    
    # Getter de la tabla
    def getTabla(self):
        return self.tabla
    
    
    # Inserción de elemento en la tabla utilizando la función de hash 
    # por el método de la división.
    def inserta(self, elem):
        nuevo = HashNode(elem)
        pos = self.funcHashDiv(nuevo) % len(self.tabla)
        aux = self.tabla[pos].getNext()
        self.tabla[pos].setNext(nuevo)
        nuevo.setNext(aux)
        self.cont += 1
        
    # Inserción de elemento en la tabla utilizando la función de hash 
    # por el método de la multiplicación. 
    def insertaM(self, elem):
        nuevo = HashNode(elem)
        
        pos = self.funcHashMult(nuevo) % len(self.tabla)
        aux = self.tabla[pos].getNext()
        self.tabla[pos].setNext(nuevo)
        nuevo.setNext(aux)
        self.cont += 1


    # Método de búsqueda de un elemento en la tabla de hash.
    def busca(self, elem):
        # Se crea un nodo auxiliar con el elemento que se desea buscar
        # para poder extraer el valor de hash y encontrar la posición donde
        # debería de encontrarse el elemento.
        aux = HashNode(elem)
        # Bandera de fin de datos inicializada en False
        var = False
        pos = self.funcHashDiv(aux) % len(self.tabla)
        actual = self.tabla[pos].getNext()
        while (not var and actual != None):
            if actual.getElem() == elem:
                var = True
            actual = actual.getNext()
        return var
    
    
    # Método de borrado de un elemento en la tabla de hash.
    def borra(self, elem):
        # Se crea un nodo auxiliar con el elemento que se desea buscar
        # para poder extraer el valor de hash y encontrar la posición donde
        # debería de encontrarse el elemento.
        aux = HashNode(elem)
        pos = self.funcHashDiv(aux) % len(self.tabla)
        prev = self.tabla[pos]
        actual = prev.getNext()
        while (actual != None and not actual.getElem() == elem):
            prev = actual
            actual = actual.getNext()
        if actual != None and actual.getElem() == elem:
            aux = actual.getNext()
            prev.setNext(aux)
            self.cont -= 1
       
    
    # Función de Hash por división
    def funcHashDiv(self,elem):
        k = elem.getKey()
        res = k % len(self.tabla)
        return res

    # Función de Hash por multiplicación
    def funcHashMult(self,elem):
        k = elem.getKey()
        a = 1/((1+math.sqrt(5))/2)
        res = math.floor(len(self.tabla)*(k*a-math.floor(k*a)))
        return res
    
    
    # Método que regresa el número de datos contenidos en
    # cada una de las casillas de la tabla
    def numDatosXCasilla(self):
        res = []
        for i in range(0,len(self.tabla)):
            cont = 0
            actual = self.tabla[i].getNext()
            while actual != None:
                cont += 1
                actual = actual.getNext()
            res.append(cont)
        return res
    
    
    # Método que devuelve el promedio de la cantidad de datos
    # de las casillas de la tabla.
    #   Se llama al método {prom}, especificado más abajo.
    def promDatosXCasilla(self):
        return prom(self.numDatosXCasilla())
    
    
    # Método que devuelve el número de lugares vacíos que se encuentran
    # en tabla.
    def numCasillasVacias(self):
        cont = 0
        for i in range(0,len(self.tabla)):
            actual = self.tabla[i].getNext()
            if actual == None:
                cont +=1
        return cont
    
    
    # Método que imprime la tabla de hash.
    def toStr(self):    
        for i in range(0,len(self.tabla)):
            actual = self.tabla[i].getNext()
            print(i)
            while actual != None:
                print(actual.getElem())
                actual = actual.getNext()




#%% Creación y manejador listas

""" 
    CREACIÓN Y MANEJADOR DE LISTAS -------------------------------------------
"""

# Método que calcula y regresa el promedio de los valores de una lista
# dada como parámetro.
def prom(lista):
    return sum(lista) / len(lista)


# Lista, valor fijo y nombre para el caso general
#   Para ambos métodos utilizados, a saber: { pruebaTamaniofijo } y 
#   { pruebaEntradaFija } se consideran en su generalidad de casos 
#   n < m, n ~ m y n > m
def casoGeneral():
    lista = [1000,2000,3500,5000,6500,8000,10000]
    valorFijo = 5000
    caso = "Caso General"
    return lista, valorFijo, caso


# Lista, valor fijo y nombre para el caso 1
# Con el método { pruebaTamaniofijo } :
#       Lista para caso     n < m
#       Es decir, cuando la entrada de datos (n) es mucho menor al tamaño 
#       de la tabla (m)
#
# Con el método { pruebaEntradaFija } :
#       Lista para caso     n > m
#       Es decir, cuando la entrada de datos (n) es mucho mayor al tamaño
#       de la tabla (m)
def caso1():
    lista = [150,300,450,600,750,900,1050,1200,1350,1500]
    valorFijo = 5000
    caso = "Caso 1"
    return lista, valorFijo, caso


# Lista, valor fijo y nombre para el caso 2
#   Para ambos métodos utilizados: { pruebaTamaniofijo } y { pruebaEntradaFija }
#   se considera el caso n ~ m , es decir, cuando la entrada de datos (n)
#   es aproximadamente igual al tamaño de la tabla (m)
def caso2():
    lista = [4000,4200,4400,4600,4800,5000,5200,5400,5600,5800]
    valorFijo = 5000
    caso = "Caso 2"
    return lista, valorFijo, caso


# Lista, valor fijo y nombre para el caso 3
# Con el método { pruebaTamaniofijo } :
#       Lista para caso     n > m
#       Es decir, cuando la entrada de datos (n) es mucho mayor al tamaño 
#       de la tabla (m)
#
# Con el método { pruebaEntradaFija } :
#       Lista para caso     n < m
#       Es decir, cuando la entrada de datos (n) es mucho menor al tamaño
#       de la tabla (m)
def caso3():
    lista = [8650,8800,8950,9100,9250,9400,9550,9700,9850,10000]
    valorFijo = 5000
    caso = "Caso 3"
    return lista, valorFijo, caso




#%% Métodos obtención de datos

""" 
    MÉTODOS DE PRUEBA --------------------------------------------------------
"""

def pruebaParticular(n, m, tope):
    titulos = listaTitulos(n)
    h = HashTable(m)
    ins = []
    for i in range(0,n):
        promIns = []
        for j in range(0,30):
            t_inicio = time.time_ns()
            h.inserta(titulos[i])
            t_fin = time.time_ns()
            t = t_fin - t_inicio
            promIns.append(t)
            h.borra(titulos[i])
        p = prom(promIns)
        if p > tope:
            tiempo = tope
        else:
            tiempo = p
        ins.append(tiempo)
        h.inserta(titulos[i])  

    bus = []
    for i in range(0,n):
        promBus = []
        for j in range(0,30):
            t_inicio = time.time_ns()
            h.busca(titulos[i])
            t_fin = time.time_ns()
            t = t_fin - t_inicio
            promBus.append(t)
        p = prom(promBus)
        if p > tope:
            tiempo = tope
        else:
            tiempo = p
        bus.append(tiempo)
        
    borr = []
    # NOTA IMPORTANTE: Dado que los elementos están "ordenados" o "acomodados"
    # en la tabla de hash debido al orden de inserción, solamente podemos borrar
    # una vez al elemento en la tabla para considerar el tiempo del proceso
    # Por lo tanto, no se tendrá una lista con promedios particulares
    for i in range(0,n):
        t_inicio = time.time_ns()
        h.borra(titulos[i])
        t_fin = time.time_ns()
        t = t_fin - t_inicio
        p = t
        if p > tope:
            tiempo = tope
        else:
            tiempo = p
        borr.append(tiempo)
        h.borra(titulos[i])
        

    print("")
    print("-------------------------------")
    print("Promedio de inserción en tiempo:")
    print(prom(ins))
    print("")
    print("-------------------------------")
    print("Promedio de búsqueda en tiempo:")
    print(prom(bus))
    print("")
    print("-------------------------------")
    print("Promedio de borrado en tiempo:")
    print(prom(borr))
    print("")
    
    return ins, bus, borr


# Método de prueba relacionado al análisis de la cantidad de datos almacenados
# en cada casilla de la tabla, el número de ellas que están vacías y el
# promedio de la cantidad de datos que hay en las listas.
#
#   Esta prueba es llamada en el método { graficasFuncionamiento }
def pruebasDatos(n,m):
    
    titulos = listaTitulos(n)
    h = HashTable(m)
    
    for i in range(0,n):
        h.inserta(titulos[i])

    datosXCasilla = h.numDatosXCasilla()
    numVacias = h.numCasillasVacias()
    promDatos = h.promDatosXCasilla()
    
    print("")
    print("-------------------------------")
    print("Número de casillas vacías:")
    print(numVacias)
    print("")
    print("-------------------------------")
    print("Promedio de datos por casilla:")
    print(promDatos)

    return datosXCasilla


# Método de prueba relacionado a la comparación del desempeño de la inserción
# con dos diferentes métodos de hash: el método de la división y el de la 
# multiplicación. En esta prueba se obtienen los datos necesarios para el
# análisis de la cantidad de datos almacenados en cada casilla de la tabla, 
# el número de ellas que están vacías y el promedio de la cantidad de datos 
# que hay en las listas después de haber la inserción correspondiente.
#
#   Esta prueba es llamada en el método { graficasComparacion }
def pruebaComparacion(n,m,tope):
    
    titulos = listaTitulos(n)
    h1 = HashTable(m) # H1 para el método de la división
    h2 = HashTable(m) # H2 para el método de la multiplicación.
    
    insDiv = []
    for i in range(0,n):
        t_inicio = time.time_ns()
        h1.inserta(titulos[i])
        t_fin = time.time_ns()
        t = t_fin - t_inicio
        p = t
        if p > tope:
            tiempo = tope
        else:
            tiempo = p
        insDiv.append(tiempo)
    

    insMult = []
    for i in range(0,n):
        t_inicio = time.time_ns()
        h2.insertaM(titulos[i])
        t_fin = time.time_ns()
        t = t_fin - t_inicio
        p = t
        if p > tope:
            tiempo = tope
        else:
            tiempo = p
        insMult.append(tiempo)
        
    datosDiv = h1.numDatosXCasilla()
    datosMult = h2.numDatosXCasilla()
    
    print("")
    print("-------------------------------")
    print("Número vacías por (División)")
    numVaciasDiv = h1.numCasillasVacias()
    print(numVaciasDiv)
    print("")
    print("-------------------------------")
    print("Número vacías por (Multiplicación)")
    numVaciasMult = h2.numCasillasVacias()
    print(numVaciasMult)
    
    print("")
    print("-------------------------------")
    print("Promedio datos por casilla (División)")
    promDatosDiv = h1.promDatosXCasilla()
    print(promDatosDiv)
    print("")
    print("-------------------------------")
    print("PromDatosXCasilla (Multiplicación)")
    promDatosMult = h2.promDatosXCasilla()
    print(promDatosMult)
    
    print("")
    print("-------------------------------")
    print("Promedio de inserción función división en tiempo:")
    print(prom(insDiv))
    print("")
    print("-------------------------------")
    print("Promedio de búsqueda función multiplicación en tiempo:")
    print(prom(insMult))
    
    return insDiv, insMult, datosDiv, datosMult

    def pruebaComparacion2(n, m, tope, listaTitulos):
        import time
        promIns = []
        promBus = []
        promBorr = []
        t1 =  HashTable(m)
        for i in range(0,20):
            tiempoInicio = time.time()
            for k in range(0,len(listaTitulos)):
                t1.insertaM(listaTitulos[k], listaTitulos[k].getKey())
            tiempoFin = time.time()
            tiempo = tiempoFin - tiempoInicio
            promIns.append(tiempo)
            
            tiempoInicio = time.time()
            for k in range(0,len(listaTitulos)):
                t1.buscaM(listaTitulos[k], listaTitulos[k].getKey())
            tiempoFin = time.time()
            tiempo = tiempoFin - tiempoInicio
            promBus.append(tiempo)
            
            tiempoInicio = time.time()
            for k in range(0,len(listaTitulos)):
                t1.borraM(listaTitulos[k], listaTitulos[k].getKey())
            tiempoFin = time.time()
            tiempo = tiempoFin - tiempoInicio
            promBorr.append(tiempo)
        import statistics as st
        print("Tiempo insertar multiplicacion ",st.mean(promIns))
        print("Tiempo buscar multiplicacion ",st.mean(promBus))
        print("Tiempo borrar multiplicacion ",st.mean(promBorr))
        
        promIns = []
        promBus = []
        promBorr = []
        t2 =  HashTable(m)
        for i in range(0,20):
            tiempoInicio = time.time()
            for k in range(0,len(listaTitulos)):
                t2.inserta(listaTitulos[k], listaTitulos[k].getKey())
            tiempoFin = time.time()
            tiempo = tiempoFin - tiempoInicio
            promIns.append(tiempo)
            
            tiempoInicio = time.time()
            for k in range(0,len(listaTitulos)):
                t2.busca(listaTitulos[k], listaTitulos[k].getKey())
            tiempoFin = time.time()
            tiempo = tiempoFin - tiempoInicio
            promBus.append(tiempo)
            
            tiempoInicio = time.time()
            for k in range(0,len(listaTitulos)):
                t2.borra(listaTitulos[k], listaTitulos[k].getKey())
            tiempoFin = time.time()
            tiempo = tiempoFin - tiempoInicio
            promBorr.append(tiempo)
            
        print("Tiempo insertar division ",st.mean(promIns))
        print("Tiempo buscar division ",st.mean(promBus))
        print("Tiempo borrar division ",st.mean(promBorr))


#%% Gráficas

"""
    CREACIÓN Y OBTENCIÓN DE GRÁFICAS -----------------------------------------
"""



# Creación de gráficas relacionadas al funcionamiento.
# Parámetros:
#  - signo: hace la diferenciación entre los casos posibles. Las opciones 
#           son:
#           1. "<" : n < m
#           2. "=" : n = m
#           3. ">" : n > m
#  - cantidad: determina si se desea analizar el caso para un dataset pequeño
#              o más grande. Las opciones son:
#              1. 0 : datos pequeños
#              1. 1 : datos grandes
def graficasFuncionamiento(signo,cantidad):
    
    # Se decide el tamaño de entrada de datos y el tamaño de la tabla de hash
    # dependiendo de los parámetros
    if cantidad == 0:
        if signo == "<":
            n = 100
            m = 1000
            # Recomendado 8,000.00
            tope = 8000.00
        elif signo == "=":
            n = 1000
            m = 1000
            # Recomendado 12,000.00
            tope = 12000.00
        else:
            n = 1000
            m = 100
            # Recomendado 12,000.00
            tope = 12000.00
    else:
        if signo == "<":
            n = 500
            m = 5000
            # Recomendado 12,000.00
            tope = 12000.00
        elif signo == "=":
            n = 5000
            m = 5000
            # Recomendado 17,000.00
            tope = 17000.00
        else:
            n = 5000
            m = 500
            # Recomendado 15,000.00
            tope = 15000.00
    
    # Gráfica sobre el número de datos por casilla de la tabla
    # Obtención de los valores necesarios
    numCasillas = list(range(0,m))
    datosXCasilla = pruebasDatos(n, m)
    
    # Inserción de los datos en gráfica
    pyplot.bar(numCasillas,datosXCasilla,1.0,color='mediumvioletred')
    
    # Asignación del título, nombres de los ejes y leyendas
    pyplot.title("Cantidad de elementos por casilla")
    pyplot.xlabel("No. Casilla")
    pyplot.ylabel("No. Elementos")
   
    # Muesta la gráfica en la pestaña 'Plots'
    pyplot.show()
    
    
    # Gráfica sobre tiempos de ejecución
    # Obtención de los valores necesarios
    valoresTiempo = pruebaParticular(n, m, tope)
    cantDatos = list(range(0,n))
    ins = valoresTiempo[0]
    bus = valoresTiempo[1]
    borr = valoresTiempo[2]
    
    # Inserción de los datos en gráfica
    pyplot.plot(cantDatos,ins,'tab:blue')
    pyplot.plot(cantDatos,bus,'tab:orange')
    pyplot.plot(cantDatos,borr,'tab:green')
    
    # Asignación del título, nombres de los ejes y leyendas
    pyplot.title("Desempeño en tiempos")
    pyplot.xlabel("No. Datos")
    pyplot.ylabel("Tiempo de ejecución (ns)")
    pyplot.legend(["inserta()","busca()","borra()"])
    
    # Muesta la gráfica en la pestaña 'Plots'
    pyplot.show()
    


# Creación de gráficas relacionadas a comparaciones de las funciones hash
# por el método de la división y por el de la multiplicación.
# Parámetros:
#  - n : cantidad de entrada de datos; el tope máximo es 10,000
#  - m : tamaño de la tabla de hash
#  - tope : tope para una mejor visualización de las mediciones de tiempo
def graficasComparacion(n, m, tope):
    
    # Obtención de los datos necesarios para las gráficas 1 y 2
    datos = pruebaComparacion(n, m, tope)
    numCasillas = list(range(0,m))
    datosDiv = datos[2]
    datosMult = datos[3]
    
    # Inserción de los datos en gráfica 1 sobre cantidad de elementos 
    # por casilla
    pyplot.bar(numCasillas,datosDiv,1.0,color='mediumvioletred')
    pyplot.bar(numCasillas,datosMult,1.0,color='mediumpurple')
    # Asignación del título, nombres de los ejes y leyendas
    pyplot.title("Cantidad de elementos por casilla Mult sobre Div")
    pyplot.xlabel("No. Casilla")
    pyplot.ylabel("No. Elementos")
    pyplot.legend(["Div Hash","Mult Hash"])
    # Muesta la gráfica 1 en la pestaña 'Plots'
    pyplot.show()
    
    
    # Inserción de los datos en gráfica 2 sobre cantidad de elementos 
    # por casilla
    pyplot.bar(numCasillas,datosMult,1.0,color='mediumpurple')
    pyplot.bar(numCasillas,datosDiv,1.0,color='mediumvioletred')
    # Asignación del título, nombres de los ejes y leyendas
    pyplot.title("Cantidad de elementos por casilla Div sobre Mult")
    pyplot.xlabel("No. Casilla")
    pyplot.ylabel("No. Elementos")
    pyplot.legend(["Mult Hash","Div Hash"])
    # Muesta la gráfica 2 en la pestaña 'Plots'
    pyplot.show()
    
    
    # Obtención de los datos necesarios para la gráfica 3
    cantDatos = list(range(0,n))
    insDiv = datos[0]
    insMult = datos[1]
    # Inserción de los datos en gráfica 3 sobre los tiempos de ejecución
    pyplot.plot(cantDatos,insDiv,color='mediumvioletred')
    pyplot.plot(cantDatos,insMult,color='mediumpurple')
    # Asignación del título, nombres de los ejes y leyendas
    pyplot.title("Desempeño en tiempos")
    pyplot.xlabel("No. Datos")
    pyplot.ylabel("Tiempo de ejecución (ns)")
    pyplot.legend(["Div Hash","Mult Hash"])
    # Muesta la gráfica en la pestaña 'Plots'
    pyplot.show()


#%% Llamados generales

"""
    LLAMADAS A MÉTODOS FINALES -----------------------------------------------
"""


# Llamada a creación y obtención de gráficas sobre funcionamiento
signo = "<"
cantidad = 0
#graficasFuncionamiento(signo, cantidad)


# llamada a creación y obtención de gráficas para comparar desempeño de las
# funciones de hash de división y de multiplicación
graficasComparacion(100,100,8000)

t = listaTitulos(8000)
import math
pruebaComparacion2(100,100,8000, t)
pruebasDatos(100,100,t)
    
    
    
    
    