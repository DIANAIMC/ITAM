class ArbolE:

    def __init__(self, c):
        self.elemento = c
        self.iz = None
        self.der = None
 
# Function to create new node
def Nodo(elem):
    n = ArbolE(elem)
    return n
 
class ExcepcionColeccionVacia(RuntimeError):
  def __init__(self, arg): 
    self.args = arg   

class Pila:
  def __init__(self):
    self.datos=[]

  def is_empty(self):
    return self.datos==[]

  def push(self,dato):
    self.datos.append(dato)

  def pop(self):
    if( self.is_empty() ):
      raise ExcepcionColeccionVacia("La pila está vacía")
    return self.datos.pop()

  def peek(self):
    if(not self.is_empty()):
      return self.datos[-1]
    else:
      raise ExcepcionColeccionVacia("La pila está vacía")



def construyeArbolExpresion(expresion):
    if not revisa(expresion):
      return 
    else:
      infija = divide(expresion)
      #Pila que tiene los operandos y parentesis
      pilaB= Pila()
  
      #Pila que tiene los operadores
      pilaA = Pila()
  
      #Prioritiza los operadores
      p = [0]*(123)
      p[ord('+')] = p[ord('-')] = 1
      p[ord('/')] = p[ord('*')] = 2
      p[ord('^')] = 3
      p[ord(')')] = 0
  
      for i in range(0, len(infija)-1):
        if infija[i].isdigit():
          t = Nodo(infija[i])
          pilaB.push(t) 
        elif infija[i] == "(":
          pilaA.push(infija[i])
        elif infija[i] == ")":
              while pilaA.size() != 0 and pilaA.peek() != '(':
                n = Nodo(pilaA.pop())
                hijoD = pilaB.pop()
                hijoI = pilaB.pop()
                n.iz = hijoI
                n.der = hijoD
                pilaB.push(n)
              pilaA.pop()
        else:
              while pilaA.size() != 0 and pilaA.peek() != '(' and p[ord(pilaA.peek())] > p[ord(expresion[i])]:
                n = Nodo(pilaA.pop())
                hijoD = pilaB.pop()
                hijoI = pilaB.pop()
                n.iz = hijoI
                n.der = hijoD
                pilaB.push(n)
              pilaA.push(infija[i])
  
    if not pilaA.is_empty():
        n = Nodo(pilaA.pop())
        hijoD = pilaB.pop()
        hijoI = pilaB.pop()
        n.iz = hijoI
        n.der = hijoD
        pilaB.push(n)

    arbolFinal = pilaB.peek()
    return arbolFinal
 
def revisa(ecuacion):
    #lista = ecuacion.split()
    lista = divide(ecuacion)
    x=0
    d=1
    m=len(lista)-2
    i=1
    prim=False
    sec=False
    res=True
    print("La ecuación dada es: ",ecuacion)
    #Considera el caso en el que la ecuación no esté bien balanceada en sus paréntesis
    if not balanceoParentesis(ecuacion):
       res = False
       print("Sintaxis incorrecta, mal balanceo de paréntesis")
    #Considera el caso en el que no se usen números u operadores (+,-,*,/)  
    elif not soloOperadores(ecuacion):
        res = False
        print("Sintaxis incorrecta, estas utilizando otro signo que no es un operador (-,+,*,/, si son operadores)")
    #Considera el caso en que el primer termino de la ecuación o el último sean operadores.
    elif(lista[d]==("+") or lista[d]==("*") or lista[d]=="/" or lista[m]=="+" or lista[m]=="-" or lista[m]=="*" or lista[m]=="/"):
      res = False
      print("Sintaxis incorrecta, no se puede comenzar o terminar una expresión con un operador")
    else:
      #Se recorre el arreglo y si se encuentra algun caso en que se encuentren 2 operadores juntos se sale del ciclo.
      while i<len(lista) and (not prim) and (not sec):
        #Se comienza el ciclo en la segunda posicion del arreglo, checando si el anterior elemento es un operador y si esto se cumple 
        #cambia la variable auxiliar a true.
        if(lista[x]==("+") or lista[x]==("-") or lista[x]==("*") or lista[x]==("/")):
          prim=True;
        if(lista[i]==("+") or lista[i]==("-") or lista[i]==("*") or lista[i]==("/")):
          sec=True;
        if lista[x]==("(") and (lista[x+1]==("*") or lista[x+1]==("/")):
          prim=True
        if lista[x]==(")") and (lista[x-1]==("*") or lista[x-1]==("/") or lista[x-1]==("+") or lista[x-1]==("-")):
          prim=True
        #En caso de que alguna de las dos sea falsa se reinician las auxiliares en falso, sino se sale del ciclo.
        if(prim==False or sec==False):
          prim=False;
          sec=False;
        i=i+1        
        x=x+1
      #Por último se comprueba si se salio antes de terminar de recorrer el arreglo para modificar o no el boolean.
      if i<len(lista):
        res=False
        print("Sintaxis incorrecta, revisa tus operadores, recuerda que solo puedes usar uno a la vez")
    return res

#Verifica que el dato sea un operador, únicamente los solicitados para la práctica(+,-,*,/)
def esOperador(dato):
    if (dato == '+' or dato == '-' or dato == '*'
        or dato == '/'):
        return True
    else:
        return False

#Verifica que los paréntesis de la ecuación estén balanceados
def balanceoParentesis(ecuacion):
    p = Pila()
    balanceados = True
    indice = 0
    while indice < len(ecuacion) and balanceados:
        simbolo = ecuacion[indice]
        if simbolo == '(' or simbolo == ')':
            if simbolo == "(" :
                p.push(simbolo)
            else:
                if p.is_empty():
                    balanceados = False
                else:
                    p.pop()

        indice = indice + 1

    if balanceados and p.is_empty():
        return True
    else:
        return False  

#Verifica que sólo se estén usando números y los operadores considerados en la práctica
def soloOperadores(ecuacion):
    i = 0
    e = divide(ecuacion)
    while i<len(e) and (e[i].isdigit() or esOperador(e[i]) or e[i] == '(' or e[i] == ')'):
        i = i + 1
    if (i<len(e)):
        return False
    else:
        return True


#Evalúa el árbol de expresión para finalemnte obtener el resultado de la ecuación
def evaluarArbolExpresion(raiz):
    if raiz is None:
        return 0
    if (raiz.iz is None and raiz.der is None):
        return int(raiz.elemento)
    
    ladoIz = evaluarArbolExpresion(raiz.iz)
    ladoDer = evaluarArbolExpresion(raiz.der)

    if raiz.elemento == '+':
        return ladoIz + ladoDer
    elif raiz.elemento == '-':
        return ladoIz - ladoDer
    elif raiz.elemento == '*':
        return ladoIz * ladoDer
    else:
        return ladoIz / ladoDer
       
#Está comentada porque solo la usamos para confirmar que los arboles de expresión se construyeron correctamente durante en las pruebas
"""
def postorder(raiz):
    if (raiz != None):
        postorder(raiz.iz)
        postorder(raiz.der)
        print(raiz.elemento, end = "")
"""

#Divide en tokens la ecuacion
import re 
def divide(cosa):
    ecuacion = list(cosa)
    i=0
    res = True
    while i<len(ecuacion)-1 and res:
        if(ecuacion[i] == "-" and ecuacion[i-1] == "("):
            res = False           
        else:
            res = True
        i = i + 1
    if (not res):
        lista = [i for i in re.split(r'([\d.-]+|[\W+])', cosa) if i]
    else:
        lista = [i for i in re.split(r'([\d.]+|[\W+])', cosa) if i]
    return lista  




print('Inicio')


print('1. Ecuaciones sintácticamente incorrectas')

#Operador al inicio
ecuacion1 = "(/7+45+8)"
raiz1 = construyeArbolExpresion(ecuacion1)
print("El resultado es: ",evaluarArbolExpresion(raiz1))

#Operador al final
ecuacion2 = "(6673+829-435*)"
raiz2 = construyeArbolExpresion(ecuacion2)
print("El resultado es: ",evaluarArbolExpresion(raiz2))

#Operadores dobles
ecuacion3 = "(945/-28+59)"
raiz3 = construyeArbolExpresion(ecuacion3)
print("El resultado es: ",evaluarArbolExpresion(raiz3))

#Paréntesis desbalanceados
ecuacion4 = '((42-35*978)'
raiz4 = construyeArbolExpresion(ecuacion4)
print("El resultado es: ",evaluarArbolExpresion(raiz4))

#Signo que no es un operador
ecuacion5 = '(323$565+989)' 
raiz5 = construyeArbolExpresion(ecuacion5)
print("El resultado es: ",evaluarArbolExpresion(raiz5))

print('2. Ecuaciones con paréntesis')

#Usando paréntesis que no influyan en el resultado
ecuacion6 = '(81+(42-63))'
raiz6 = construyeArbolExpresion(ecuacion6)
print("El resultado es: ",evaluarArbolExpresion(raiz6))

#Sin paréntesis
ecuacion7 = '(81+42-63)'
raiz7 = construyeArbolExpresion(ecuacion7)
print("El resultado es: ",evaluarArbolExpresion(raiz7))

#Con paréntesis que si  influya en el resultado
ecuacion8 = '((71+9)*36+(6*7))'
raiz8 = construyeArbolExpresion(ecuacion8)
print("El resultado es: ",evaluarArbolExpresion(raiz8))

#Sin paréntesis
ecuacion9 = '(71+9*36+6*7)'
raiz9= construyeArbolExpresion(ecuacion9)
print("El resultado es: ",evaluarArbolExpresion(raiz9))

#Con varios paréntesis anidados
ecuacion_9 = '((71+9)*((36+6)*7))'
raiz_9= construyeArbolExpresion(ecuacion_9)
print("El resultado es: ", evaluarArbolExpresion(raiz_9))

print('3. Usando números positivos y negativos')

expresion = "(1-(4*4))"
raiz = construyeArbolExpresion(expresion)
print("El resultado es: ",evaluarArbolExpresion(raiz))
ecuacion10 = '((-43)+238)'
raiz10 = construyeArbolExpresion(ecuacion10)
print("El resultado es: ",evaluarArbolExpresion(raiz10))
ecuacion11 = '((-100)+(-93))'
raiz11 = construyeArbolExpresion(ecuacion11)
print("El resultado es: ",evaluarArbolExpresion(raiz11))
ecuacion12 = '(13-64)'
raiz12 = construyeArbolExpresion(ecuacion12)
print("El resultado es: ",evaluarArbolExpresion(raiz12))

print('4. Usando operadores de misma jerarquía')

ecuacion13 = '(50/5*5)'
raiz13 = construyeArbolExpresion(ecuacion13)
print("El resultado es: ",evaluarArbolExpresion(raiz13))
ecuacion14 = '(3+1-1)'
raiz14 = construyeArbolExpresion(ecuacion14)
print("El resultado es: ",evaluarArbolExpresion(raiz14))


print("Ingresa una expresion en forma infija, recuerda indicarla entre paréntesis")
respuesta = input()
if revisa(respuesta):
  raiz15 = construyeArbolExpresion(respuesta)
  print("El resultado es: ",evaluarArbolExpresion(raiz15))
  
else:
  print("La expresión es incorrecta")
