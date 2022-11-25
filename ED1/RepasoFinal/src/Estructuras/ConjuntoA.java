/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.Iterator;

/**
 *
 * @author dianam
 */
public class ConjuntoA<T> implements ConjuntoADT<T>{
    private T[] coleccion;
    private int cardinalidad;
    private final int MAXIMO=50;
    
    public ConjuntoA(){
        coleccion= (T[]) new Object[MAXIMO];
        cardinalidad=0;
    }
    
    public ConjuntoA(int maximo){
        coleccion= (T[]) new Object[maximo];
        cardinalidad=0;
    }
    
    public boolean estaVacio(){
        return cardinalidad==0;
    }
    
    public int getCardinalidad(){
        return cardinalidad;
    }
    
    public Iterator<T>iterator(){
        return new ArrayIterator(coleccion, cardinalidad);
        
    }
    
    public boolean contiene(T elemento){
        Iterator<T> it= this.iterator();
        boolean resp=false;
        
        while(it.hasNext() && !resp)
            resp= it.next().equals(elemento);
        return resp;
        
        
    }
    
    public boolean agrega(T nuevo){
        boolean resp=false;
        
        if(!contiene(nuevo)){
            if(cardinalidad==coleccion.length)
                expande();
            coleccion[cardinalidad]=nuevo;
            cardinalidad++;
            resp=true;
        }
        return resp;
    }
    
    private void expande(){
        T[]masGrande= (T[]) new Object[coleccion.length*2];
        
        for(int i=0; i<cardinalidad;i++)
            masGrande[i]=coleccion[i];
        coleccion=masGrande;
    }
    
    public String toString(){
        StringBuilder sB= new StringBuilder();
        for(int i=0;i<cardinalidad;i++)
            sB.append(coleccion[i]).append(" ");
        return sB.toString();
            
    }
    
    public int buscaElemento(T dato){
        int i;
        
        i=0;
        while(i<cardinalidad && !coleccion[i].equals(dato))
            i++;
        if(i==cardinalidad)
            i=-1;
        return i;   
    }
    
    public T quita(T elemento){
        int pos;
        T resultado;
        pos= buscaElemento(elemento);
        if(pos>=0){
            resultado=coleccion[pos];
            coleccion[pos]=coleccion[cardinalidad-1];
            coleccion[cardinalidad-1]= null;
            cardinalidad--;         
    }
        throw new EmptyCollectionException(); 
}
    
    public ConjuntoA<T> union(ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
    
        for(int i=0;i<cardinalidad;i++)
            aux.agrega(coleccion[i]);
        
        Iterator<T> it= conjunto.iterator();
        
        while(it.hasNext())
            aux.agrega(it.next());
        
        return aux;        
    }
    
    public ConjuntoA<T> unionRecursivo(ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
        Iterator<T>it= conjunto.iterator();
        return unionRecursivo(conjunto, aux, it, 0);
        
    }
    
    private ConjuntoA<T> unionRecursivo(ConjuntoADT<T> conjunto, ConjuntoA<T> aux, Iterator<T>it, int i){
        if(i==cardinalidad){
            if(it.hasNext()){
                aux.agrega(it.next());
                return unionRecursivo(conjunto,aux,it,i);
            }
            else
                return aux;
        }
            else{
                aux.agrega(coleccion[i]);
                return unionRecursivo(conjunto, aux , it, i+1);
    }  
    }
    
    public ConjuntoA<T> interseccion(ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
        
        for(int i=0; i<cardinalidad; i++) //cardinalidad es cuantos datos hay en el conjunto
            if(conjunto.contiene(coleccion[i]))
                aux.agrega(coleccion[i]);
        
        return aux;   
    }
    
    public ConjuntoA<T> interseccionR(ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
        return interseccionR(conjunto, aux, 0);
        
        
    }
    
    private ConjuntoA<T> interseccionR(ConjuntoADT<T> conjunto, ConjuntoA<T> aux, int i){
        if(i>=cardinalidad)
            return aux;
        
        if(conjunto.contiene(coleccion[i]))
            aux.agrega(coleccion[i]);
        
        
        return interseccionR(conjunto, aux, i+1);        
    }
    
     public ConjuntoA<T> diferencia(ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
        
        for(int i=0; i<cardinalidad; i++) //cardinalidad es cuantos datos hay en el conjunto
            if(!conjunto.contiene(coleccion[i]))
                aux.agrega(coleccion[i]);
        
        return aux;   
    }
     
     
     public ConjuntoA<T> diferenciaR(ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
        return diferenciaR(conjunto, aux, 0);
        
        
    }
    
    private ConjuntoA<T> diferenciaR(ConjuntoADT<T> conjunto, ConjuntoA<T> aux, int i){
        if(i==cardinalidad)
            return aux;
        else{
        if(!conjunto.contiene(coleccion[i])){
            aux.agrega(coleccion[i]);
        }
        }
        return diferenciaR(conjunto, aux, i+1);        
    }
    
    //todo menos la intersección
    public ConjuntoA<T> contieneAoB (ConjuntoADT<T> conjunto){
        ConjuntoA<T>aux= new ConjuntoA();
        return union(conjunto).diferencia(interseccion(conjunto));
    }
    
    public boolean subConjunto(ConjuntoADT<T> conjunto){
        int i=0;
        boolean resp=true;
        while(i !=cardinalidad && !resp){
            if(!conjunto.contiene(coleccion[i]))
                resp=false;
            i++;
        }
        return resp;
    }
    
    public boolean iguales(ConjuntoADT<T> conjunto){
        int i=0;
        boolean resp=true;
        Iterator it = conjunto.iterator();
        if(conjunto.getCardinalidad()!=cardinalidad){
            while(it.hasNext() && !resp){
                if(it.next()!=coleccion[i])
                    resp=false;
                i++;
            }
        } else {
            resp=false;
        }
        return resp;
    }
    
    //next te da el siguiente, hasNext te dice si hay siguiente
   
     
}

    
    

