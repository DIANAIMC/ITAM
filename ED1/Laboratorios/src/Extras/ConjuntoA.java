/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import java.util.Iterator;
import java.util.*;
/**
 *
 * @author Yuliana
 */
public class ConjuntoA<T> implements ConjuntoADT<T> {
    private T[] conjunto;
    private int cardinalidad;
    private final int MAX=50;
    
    
    public ConjuntoA(){
        conjunto=(T[])new Object[MAX];
        cardinalidad=0;
    } 
   
    public ConjuntoA(int max){
        max=MAX;
        conjunto=(T[])new Object[max];
        cardinalidad=0;
    } 
    
    public int getCardinalidad(){
        return cardinalidad;
    }
    
    public boolean isEmpty(){
        return cardinalidad==0;
    }
    

    public T remove(T dato){
        T result;
        int i=0;
        result=null;
        while(i<cardinalidad && !dato.equals(conjunto[i])){
            i++;
        }
        if(i<cardinalidad){//si no lo encontro
            result=conjunto[i];
            conjunto[i]=conjunto[cardinalidad-1];
            conjunto[cardinalidad-1]=null;
            cardinalidad--;
    }
        return result;
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
    }
    
    
    public void expandCapacity(){
        T[] nuevo=(T[]) new Object[conjunto.length*2];
        for(int i=0;i<conjunto.length;i++)
            nuevo[i]=conjunto[i];
        conjunto=nuevo;
    }
    
    
    public boolean add(T dato){
        int i=0;
        boolean resp;
       
        resp=contains(dato);
        if(!resp){
            if(cardinalidad<=conjunto.length){
                expandCapacity();
                conjunto[cardinalidad]=dato;
            cardinalidad++;
            }
        }

        return !resp;
        
    }
    
    

    

    /**
     * EJERICICIO_1 
     * Escribe un método booleano que regrese sin un conjunto contiene cierto elemento (Utiliza un iterador)
    */
    public boolean contains(T dato){
        Iterator<T> it=this.iterator();
        boolean resp=false;
        
        while(it.hasNext() && !resp){
            resp=it.next().equals(dato);
        }
        
        return resp;  
    }
    


    
     /**
     * EJERCICIO_2.0
     *Escribe un método iterativo que regrese la union de dos conjuntos
     * Recordar que uno de los conjuntos es el this ya que estamos en la clase ConjuntoA (Utiliza un iterador)
     */
      
    public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        Iterator<T> itT=this.iterator(), itO=otro.iterator();
        ConjuntoADT<T> un=new ConjuntoA();
        T dato;
        
//        while(itT.hasNext()){//Todos los elementos del conjunto A
//            dato=itT.next();
//            if(!otro.contains(dato)){
//                un.add(dato);
//            }
//        }

    while(itT.hasNext()){//Todos los elementos del conjunto A
            un.add(itT.next());
        }
        
        while(itO.hasNext()){//Todos los datos del conjunto B (sin los que estan repetidos en ambos)
            un.add(itO.next());
        }
        
        return un;
        
        
    }
    
    /**
     * EJERICICIO_2.1
     * Retoma el ejercicio 2.0 y implementalo de manera recursiva (Utiliza un iterador)
    */  
    
    public ConjuntoADT<T> unionR(ConjuntoADT otro){
        Iterator<T> itT=this.iterator(), itO=otro.iterator();
        ConjuntoADT<T> un=new ConjuntoA();
        
        unionR(un, itT);
        unionR(un, itO);
        return un; 
        
    }
    
    private void unionR(ConjuntoADT<T> union, Iterator<T> it){
        if(it.hasNext()){//ER
            union.add(it.next());//AEB
            unionR(union,it); 
        }
        //EB
        
    }
    
    


    
    /**
     * 
     * EJERCICIO_3.0
     * Escribe un método iterativo que regrese la intersección de dos conjuntos
     * Recordar que uno de los conjuntos es el .this ya que estamos en la clase ConjuntoA (Utiliza un iterador)
     * A <- this
     * B <- otro
     * 
     */
     
       
    public ConjuntoADT<T> inter(ConjuntoADT<T> otro){
        Iterator<T> it=this.iterator();
        ConjuntoADT<T> inter=new ConjuntoA();
        T dato;
        
        while(it.hasNext()){
            dato=it.next();
            if(otro.contains(dato)){
                inter.add(dato);
            }
        }
        
        return inter;
    }
    
    
    /**
     * EJERICICIO_3.1
     * Retoma el ejercicio 3.0 y implementalo de manera recursiva (Utiliza un iterador)
    */  

    public ConjuntoADT<T> interR(ConjuntoADT<T> otro){
        ConjuntoADT<T> inter=new ConjuntoA();
        
        interR(inter, otro.iterator());
        return inter;
    }
    
    private void interR(ConjuntoADT<T> inter, Iterator<T> it){
        T dato;
        
        if(it.hasNext()){//ER
            dato=it.next();//AEB
            if(this.contains(dato)){
                inter.add(dato);
            }
            interR(inter, it);
        }
        //EB
    }

    
    
    
    


    /**
     * EJERCICIO_4.0
     * Escribe un método iterativo que regrese la diferencia entre dos conjuntos
     * Recordar que uno de los conjuntos es el .this ya que estamos en la clase ConjuntoA (Utiliza un iterador)
     */

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        Iterator<T> it=this.iterator();
        ConjuntoADT<T> dif=new ConjuntoA();
        T dato;
        
        while(it.hasNext()){
            dato=it.next();
            if(!otro.contains(dato)){
                dif.add(dato);
            }
        }
        
        return dif;
    }
    
    /**
     * EJERICICIO_4.1
     * Retoma el ejercicio 4.0 y implementalo de manera recursiva (Utiliza un iterador)
    */  
    

    public ConjuntoADT<T> diferR(ConjuntoADT<T> otro){
        ConjuntoADT<T> dif =new ConjuntoA();
        diferR(dif, this.iterator(), otro);
        return dif;
    }
    
    private void diferR(ConjuntoADT<T> dif, Iterator<T> it, ConjuntoADT<T> otro){
        if(it.hasNext()){
            T dato=it.next();
            if(!otro.contains(dato)){
                dif.add(dato);
            }
            diferR(dif, it, otro);
        }
    }
    


    
    /**
     * EJERCICIO_5
     * Escribe un método recursivo que determine si un conjunto es igual a otro
     * {1,2,3,4} = {1,2,3,4} o {2,3,4,1}
     */
    
    
    public boolean equals(ConjuntoADT<T> otro){
        if(this.getCardinalidad() != otro.getCardinalidad()){//EB
            return false;
        }else{
            return equals(otro.iterator());
        }
    }
    
    
    private boolean equals(Iterator<T> it){
        if(it.hasNext()){//ER
            if(this.contains(it.next())){//AEB
                return equals(it);
            }else{//EB
                return false;
            }
        }//EB
        return true;
    }

    private static class IteradorArreglo implements Iterator<T> {

        
 
    }
}

