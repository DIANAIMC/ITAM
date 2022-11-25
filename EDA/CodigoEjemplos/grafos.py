 #!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jan 11 10:43:20 2022

@author: dianam
"""

import numpy as np
import heapdict as hd 

class Grafo:
  def __init__(self):
    self.G={}
    self.visitado={}
  
  def inserta_dirigido(self,v1,v2=None,peso=None):
    if v1 not in self.G.keys():
      self.G[v1]={}
      if v2 is not None:
        self.G[v1][v2]=peso
    else:
      if v2 is not None and v2 not in self.G[v1]:
        self.G[v1][v2]=peso

  def inserta(self,v1,v2,peso=None):
    self.inserta_dirigido(v1,v2,peso)
    self.inserta_dirigido(v2,v1,peso)

  
  def __recorridoProfundidad(self,actual,lista):
    if actual is None:
      return
    if self.visitado[actual]:
      return
    self.visitado[actual]=True
    lista+=[actual]
    for vecino in self.G[actual]:
      self.__recorridoProfundidad(vecino,lista)

##  def DFS(self):
## self.visitado = [False for v in self.G]
  ##  for v in self.G:
    ##  self.visitado[v]=False
    ##lista=[]
    ##for v in self.visitado:
##      if not self.visitado[v]:
        ##self.__recorridoProfundidad(v,lista)
    ##return lista

  def BFS(self):
    for v in self.G: #grafo 
      self.visitado[v]=False
    lista=[]
    cola=[]
    for v in self.visitado:
      if not self.visitado[v]:
        self.visitado[v]=True
        lista+=[v]
        for nodo in self.G[v]:
          if not self.visitado[nodo]:
            cola.append(nodo)
        while cola!=[]:
          visita=cola.pop(0)  ##nos va a ayudar a eliminar el primero        
          self.visitado[visita]=True
          lista+=[visita]
          for nodo in self.G[visita]:
            if not self.visitado[nodo]:
              cola.append(nodo)      
    return lista

  def DFS(self):
    for v in self.G:
      self.visitado[v]=False
    lista=[]
    pila=[]
    for v in self.visitado:
      if not self.visitado[v]:
        self.visitado[v]=True
        lista+=[v]
        for nodo in self.G[v]:
          if not self.visitado[nodo]:
            pila.append(nodo)
        while pila!=[]:
          visita=pila.pop()
          self.visitado[visita]=True
          lista+=[visita]
          for nodo in self.G[visita]:
            if not self.visitado[nodo]:
              pila.append(nodo)      
    return lista

  def Prim(self,v_ini):
    key=hd.heapdict()
    papa={}
    for v in self.G:
      key[v]=np.inf
      papa[v]=None
    key[v_ini]=0

    while len(key.keys())>0:
      nodo=key.popitem()[0]
      for vecino in self.G[nodo].keys():
        if vecino in key.keys() and self.G[nodo][vecino] < key[vecino]:
          key[vecino]=self.G[nodo][vecino]
          papa[vecino]=nodo
    return papa

  def Dijkstra(self,v_ini):
    key=hd.heapdict()
    papa={}
    for v in self.G:
      key[v]=np.inf
      papa[v]=None
    key[v_ini]=0

    while len(key.keys())>0:
      temp=key.popitem()
      nodo=temp[0]
      valor_ruta=temp[1]
      for vecino in self.G[nodo].keys():
        if vecino in key.keys() and valor_ruta+self.G[nodo][vecino] < key[vecino]:
          key[vecino]=valor_ruta+self.G[nodo][vecino]
          papa[vecino]=nodo
    return papa