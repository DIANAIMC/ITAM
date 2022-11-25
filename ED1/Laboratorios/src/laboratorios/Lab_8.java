/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

import Extras.ConjuntoA;
import Extras.ConjuntoADT;
import Extras.PilaA;
import Extras.PilaADT;
import Extras.ColaADT;
import Extras.ColaA;
import java.util.Iterator;

/**
 *
 * @author AChavero
 */
public class Lab_8 {
    
    /**
     * COLAS (QUEUE)
     * Son una estructura que funciona con la metodologia "first in first out (FIFO)"
     * lo cual implica que el primer elemento es el primero que sale
     * Ejemplo: la fila en un banco
     * Los metodos que utiliza son los siguentes 
     * public void add(T dato): añade el dato a la cola 
     * public T remove(): elimina el elemento en la primera posicion (dequeue)
     * public boolean isEmpty(): denota si la cola esta vacia o no 
     * public T first(): regresa el elemento en la primera posicion sin eliminarlo de la cola (analogo al peek de pilas)
     * Para moverse a traves de una estructura tipo cola se debe utilizar la condicion !isEmpty()
     * Igual que con las pilas, los datos se pierden, por lo que se recomienda utilizar estructuras auxiliares para 
     * no perder los datos (puede ser una cola auxiliar o incluso, en caso de ser necesario, una pila auxiliar)
     */
    
    /**
     *EJERCICIO_1 
     *Escribe un metodo recursivo que imprima un conjunto
     */
    public static <T> void imprimeConjuntoR(ConjuntoADT<T> set){
        imprimeConjuntoR(set.iterator());
    }
    
    private static <T> void imprimeConjuntoR(Iterator<T> it){
        if(it.hasNext()){
            System.out.println(it.next().toString());
            imprimeConjuntoR(it);
        }
    }
    
    
    /**
     * EJERCICIO_2
     * Escribe un metodo el cual realiza el algoritmo siguente, 
     * Dados tres conjuntos A,B,C 
     * A={a,b,c,d,e}
     * B={n,f,c,h,i,m}
     * C={m,c,a,z,e,j,l}
     * Por medio de operaciones entre conjuntos, regrese un conjunto conformado por los siguientes elementos 
     * R={b,d,n,f,h,i,z,j,l}
     * Esto quiere decir que el conjunto de resultados debe contener los elementos que unicamente se encuentren en 
     * uno de los conjuntos 
     * A-B-C=(A-B)-C
     * DA+DB+DC
     */
    
    public static <T> ConjuntoADT<T> oper3sets(ConjuntoADT<T> setA, ConjuntoADT<T> setB, ConjuntoADT<T> setC){
        ConjuntoADT<T> setR= new ConjuntoA();
        ConjuntoADT<T> setDA= new ConjuntoA();
        ConjuntoADT<T> setDB= new ConjuntoA();
        ConjuntoADT<T> setDC= new ConjuntoA();
        
        
        //Primer sub conjunto A-B-C
        setDA= setA.diferR(setB); //A-B
        setDA= setDA.diferR(setC); //A-B-C
        
        //Segundo sub connjunto B-A-C
        setDB=setB.diferR(setA); //B-A
        setDB=setDB.diferR(setC); //B-A-C
        
        //Tercer sub conjunto C-A-B
        setDC= setC.diferR(setA); //C-A 
        setDC=setDC.diferR(setB); //C-A-B
        
        //(DA+DB)+DC
        setR=setDA.union(setDB); //DA+DB
        setR=setR.union(setDC); //DA+DB+DC
        
        return setR;
    }
    
    /**
     * EJERCICIO_3
     * Escribe un metodo que imprima todos los elementos de una cola
     * El metodo no puede ser destructivo
     * 1, 2, 3, 4 //original
     * => 1, 2, 3, 4 //aux
     * 1, 2, 3, 4 //original
     */
    
    public static <T> void imprimeQueue(ColaADT<T> queue){ //[1, 2, 3, 4]
        ColaADT<T> aux=new ColaA();
        
        while(!queue.isEmpty()){ //original => aux
            System.out.print(queue.first().toString()+ " ");
            aux.add(queue.remove());
        }
        
        System.out.println("\n");
        
        while(!aux.isEmpty()){ //aux => original
            queue.add(aux.remove());
        }
    }
    

    
    
    /**
     * EJERCICIO_4
     * Escribe un metodo que quite todos los elementos repetidos de una estructura tipo cola
     * Los elementos repetidos se encuentran en posiciones consecutivas
     * queue = {4,7,7,7,9,45} => {4,7,9,45}
     */
    
    public static <T> void eliminaRepetidos(ColaADT<T> queue){
        ColaADT<T> aux= new ColaA();
        T dato;
        
        while(!queue.isEmpty()){ //{4,7,9,45} aux
            dato=queue.remove();
            aux.add(dato);
                while(!queue.isEmpty() && dato.equals(queue.first())){
                    queue.remove();
                }
        }
        
        
        while(!aux.isEmpty()){ // {4,7,9,45} original
            queue.add(aux.remove());
        }
        
        
        
    }
    
    /**
     * EJERCICIO_5
     * Escribe un metodo estatico que quite todas las ocurrencias de un cierto objeto de una estructura
     * tipo cola. Es decir, dado un objeto, si se encuentra en la cola, se deben eliminar todas sus
     * ocurrencias.
     * dato=4
     * {4,7,9,45,4}  => {7,9,45}
     */

    
    public static <T> void eliminaOcurrencias(ColaADT<T> queue, T dato){
        ColaADT<T> aux=new ColaA();
        
        while(!queue.isEmpty()){
            if(queue.first().equals(dato)){
                queue.remove();
            }else{
                aux.add(queue.remove());
            }
        }
        
//        while(!queue.isEmpty()){
//            if(!queue.first().equals(dato))
//               aux.add(queue.remove());     
//        }


        while(!aux.isEmpty()){
            queue.add(aux.remove());
        }
        
    }
    
    /**
     * EJERCICIO_6
     * Escribe un metodo que cambie el lugar de cada uno de los elementos de una cola 
     * de la siguiente manera 
     * {1,2,3,4} => {2,1,4,3} 
     * En caso de que el numero de elementos sea impar, el ultimo elemento no debe cambiar de posicion
     * {1,2,3,4,5} => {2,1,4,3,5}
     */
    
     public static <T> void cada2Queue(ColaADT<T> queue){
         ColaADT<T> aux=new ColaA();
         T dato;
         
         while(!queue.isEmpty()){ //{2,1,4,3,5} aux
             dato=queue.remove();
             if(!queue.isEmpty()){
                 aux.add(queue.remove());
             }
             aux.add(dato);
         }
         
         while(!aux.isEmpty()){// {2,1,4,3,5} original
             queue.add(aux.remove());
         }
         
         
    }
    
    /**
     * EJERCICIO_Extra
     * Invierte una cola sin utilizar un arreglo 
     * {1,2,3,4,5}
     * => 
     * 5
     * 4
     * 3
     * 2
     * 1
     * ___
     * 
     * => {5,4,3,2,1}
     */
     
     public static <T> void invCola(ColaADT<T> cola){
         PilaADT<T> aux=new PilaA();
         
         while(!cola.isEmpty()){
             aux.push(cola.remove());
         }
         
         while(!aux.isEmpty()){
             cola.add(aux.pop());
         }
         
     }
     
    
    public static void main(String[] args) {
        ConjuntoADT<String> setA=new ConjuntoA(); //{a,b,c,d,e}
        ConjuntoADT<String> setB=new ConjuntoA(); //{n,f,c,h,i,m}
        ConjuntoADT<String> setC=new ConjuntoA(); //{m,c,a,z,e,j,l}
        ColaADT<Integer> queue=new ColaA(); //{4,7,7,7,9,45}
        
        
        setA.add("a");
        setA.add("b");
        setA.add("c");
        setA.add("d");
        setA.add("e");
        //imprimeConjuntoR(setA);
        
        setB.add("n");
        setB.add("f");
        setB.add("c");
        setB.add("h");
        setB.add("i");
        setB.add("m");
        //imprimeConjuntoR(setB);
        
        setC.add("m");
        setC.add("c");
        setC.add("a");
        setC.add("z");
        setC.add("e");
        setC.add("j");
        setC.add("l");
        //imprimeConjuntoR(setC);
        
        queue.add(4);
        queue.add(7);
        queue.add(7);
        queue.add(7);
        queue.add(9);
        queue.add(45);
        
        System.out.println("EJERCICIO_1-2");
       imprimeConjuntoR(oper3sets(setA,setB,setC));
        
       System.out.println("EJERCICIO_3-4");
        eliminaRepetidos(queue);
        imprimeQueue(queue);

       System.out.println("EJERCICIO_5");
        eliminaOcurrencias(queue, 7);
        imprimeQueue(queue);
        
        System.out.println("EJERICIO_6");
        cada2Queue(queue);
         imprimeQueue(queue);
        
        
    }
}