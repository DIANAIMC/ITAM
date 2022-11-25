/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

import Extras.PilaADT;
import Extras.PilaA;
import Extras.ColaA;
import Extras.ColaADT;
import java.util.ArrayList;


/**
 *
 * @author Yuliana
 */
public class Lab_9 {
    
    /**
     * EJERCICIO_Extra
     */

    public static <T> void imprimeQueue(ColaADT<T> queue){
        ColaADT<T> aux=new ColaA();
        
        while(!queue.isEmpty()){
            System.out.print(queue.first().toString()+" ");
            aux.add(queue.remove());
        }
        
        while(!aux.isEmpty()){
            queue.add(aux.remove());
        }
        
        System.out.println("\n");
    }
    
    /**
     * EJERCICIO_1
     * Escribe un metodo que regrese el total de elementos almacenados en la cola
     */
    
    public static <T> int cuentaElementos(ColaADT<T> queue){
        ColaADT<T> aux=new ColaA();
        int num = cuentaElementos(queue, aux, 0);
        return cuentaElementos(aux, queue, 0);
    }
    
    private static <T> int cuentaElementos(ColaADT<T> queue, ColaADT<T> aux, int i){
        if(!queue.isEmpty()){
            aux.add(queue.remove());
            i++;
            return cuentaElementos(queue, aux, i);
        }else{
            return i;
        }
        
        
    }
    
    /**
     * EJERCICIO_2
     * Escribe un metodo que regrese el último elemento almacenado en la cola, sin quitarlo.
     */
    
    public static <T> T ultimoQueue(ColaADT<T> queue){
        ColaADT<T> aux=new ColaA();
        T dato=queue.first();
        
        if(queue.isEmpty()){
            dato=null;
            
        }else{
        dato=queue.first();
        while(!queue.isEmpty()){
            dato=queue.first(); 
            aux.add(queue.remove());
        }
        
        while(!aux.isEmpty()){
            queue.add(aux.remove());
        }
        }
        return dato;
        
    }
    
    /**
     * EJERCICIO_3
     * Escribe un metodo que regresae un ArrayList almacenando los n elementos quitados de la cola. 
     */
    
    public static <T> ArrayList nQueue(ColaADT<T> queue, int n){
        ArrayList<T> al=new ArrayList();
        ColaADT<T> aux=new ColaA();
        
        while(!queue.isEmpty()  && n>0){
            al.add(queue.first());
            aux.add(queue.remove());
            n--;
        }
        
        while(!queue.isEmpty()){
            aux.add(queue.remove());
        }
        
        while(!aux.isEmpty()){
            queue.add(aux.remove());
        }
        
        return al;
    }
        
    /**
     * EJERCICIO_4 (Extra del lab pasado)
     * Invierte una cola sin utilizar un arreglo 
     */
        
    public static <T> void invierteQueue(ColaADT<T> queue){ // {4,2,8,1,9}
        PilaADT<T> aux=new PilaA();
        
        while(!queue.isEmpty()){
            aux.push(queue.remove()); // {9,1,8,2,4}
        }
        
        while(!aux.isEmpty()){//          <=          
            queue.add(aux.pop()); // {9,1,8,2,4}
        }
    }
    
    /**
     * EJERCICIO_5
     * Escribe un metodo estatico que reciba una cola como parametro, y regrese una cola
     * con el siguente algoritmo
     * 1. Suma los elementos de la cola 
     * 2. La cola resultante tendra la suma en la ultima posicion la suma y suma-i en las posiciones previas, es decir, el minimo 
     * debe estar al principio
     * Debe ser un metodo no destructivo
     * {4,2,8,1,9} => {20,21,22,23,24} => {24,25,26,27,28} => {24,23,22,21,20}
     */
    
    
    public static ColaADT<Integer> sumaQueue(ColaADT<Integer> queue){
        ColaADT<Integer> queueR=new ColaA();
        PilaADT<Integer> pila=new PilaA();
        int suma=0, i=0; 
        
        while(!queue.isEmpty()){ //private sumaQueueR(ColaADT<Integer> queue, ColaADT<Integer> queue, 0)
            suma=suma+queue.first();
            queueR.add(queue.remove()); //{4,2,8,1,9} suma= 24
        }
        // queueR {4,2,8,1,9}
        // queue {}
        
        while(!queueR.isEmpty()){ //private       
            queue.add(queueR.remove());
            pila.push(suma-i);
            i++;
        }
        
        // queue {4,2,8,1,9} 
        // queueR {}
        // (20,21,22,23,24)
        
        while(!pila.isEmpty()){ //private
            queueR.add(pila.pop()); // queueR {20,21,22,23,24}
        }
        
        
        return queueR;
        
    }
    
    public static ColaADT<Integer> sumaQueueR(ColaADT<Integer> queue){
        ColaADT<Integer> queueR=new ColaA();
        PilaADT<Integer> pila=new PilaA();
        int suma=0;
        
        suma=sumaQueueR(queue, queueR, 0); // while1 
        sumaQueueR(queue, queueR, suma, pila, 0); //while 2
        sumaQueueR(queueR, pila); //while3
        
        return queueR;
    }
    
    private static int sumaQueueR(ColaADT<Integer> queue, ColaADT<Integer> queueR, int suma){
        
        if(!queue.isEmpty()){
            suma=suma+queue.first();
            queueR.add(queue.remove()); 
            return suma=sumaQueueR(queue, queueR, suma);
        }else{
            return suma;
        }
        
    }
    
    
    
    private static void sumaQueueR(ColaADT<Integer> queue, ColaADT<Integer> queueR, int suma, PilaADT<Integer> pila, int i){
        if(!queueR.isEmpty()){
            queue.add(queueR.remove());
            pila.push(suma-i);
            i++;
            sumaQueueR(queue, queueR, suma, pila, i);
        }
    }
    
    private static void sumaQueueR(ColaADT<Integer> queueR, PilaADT<Integer> pila){
        if(!pila.isEmpty()){
            queueR.add(pila.pop());
            sumaQueueR(queueR, pila);
        }
    }
    
    public static void main(String[] args) {//    <=
        ColaADT<Integer> queue=new ColaA(); //{4,2,8,1,9}  (24)
        
        queue.add(4);
        queue.add(2);
        queue.add(8);
        queue.add(1);
        queue.add(9);
        
        System.out.println("EJERCICIO_1");
        System.out.println(cuentaElementos(queue));
        
       System.out.println("EJERCICIO_2");
        System.out.println(ultimoQueue(queue));
       
        System.out.println("EJERCICIO_3");
        System.out.println(nQueue(queue,3).toString());
        
        System.out.println("EJERCICIO_4");
        System.out.println("Antes");
        imprimeQueue(queue);
        invierteQueue(queue);
        System.out.println("Despues");
        imprimeQueue(queue);

        System.out.println("EJERCICIO_5");
        imprimeQueue(sumaQueue(queue));
        
    }


    

}
