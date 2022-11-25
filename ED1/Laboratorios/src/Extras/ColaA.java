/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

/**
 *
 * @author Yulia
 */
import Extras.EmptyCollectionException;
/**
 *
 * @author jerusa
 */
public class ColaA<T> implements ColaADT<T>{
    private int in;
    private int fin;
    private T[] coleccion;
    private final int MAX=50;

    public ColaA() {
        coleccion=(T[]) new Object[MAX]; 
        fin=-1;
        in=-1;
    }

    public int getIn() {
        return in;
    }

    public int getFin() {
        return fin;
    }
    
    
    
    public boolean isEmpty(){
        return in==-1;
    }
    
    public T first(){
        if(!isEmpty())
            return coleccion[in];
        throw new EmptyCollectionException("");
    }
    
    public void expand(){
        T[] nuevo=(T[]) new Object[coleccion.length*2];
        int j=0, i;
        
        for(i=in;i<coleccion.length;i++){
            nuevo[j]=coleccion[i];
            j++;
        }
        
        for(i=0;i<in;i++){
            nuevo[j]=coleccion[i];
            j++;
        }
        
        in=0;
        fin=j-1;
        coleccion=nuevo;
    } 
    
    public void add(T dato){
        if((fin+1)%coleccion.length==in)
            expand();
            fin=(fin+1)%coleccion.length;
            coleccion[fin]=dato;
            if(in==-1)
                in=0;
        
    }
    
    public T remove(){
        T result;
        if(isEmpty()){
            throw new EmptyCollectionException("");
        }
        else{
            result=coleccion[in];
            if(in==fin){
                in=-1;
                fin=-1;
            }
            else
                in=(in+1)%coleccion.length;
        }
        return result;
    }
    
    
    
}

