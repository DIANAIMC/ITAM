/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import Estructuras.EmptyCollectionException;
import Estructuras.StackADT;

/**
 *
 * @author dianam
 */
public class PilaE <T> implements StackADT<T>{
    private Nodo<T> tope;
    
    public PilaE(){
        tope=null;
    }
    
    @Override
    public void push(T dato) {
        Nodo<T> nuevo= new Nodo(dato);
        nuevo.setSig(tope);
        tope=nuevo;
    }

    @Override
    public T pop() {
        if(this.isEmpty())
            throw new EmptyCollectionException("No hay datos en la pila");
        Nodo<T> aux=tope;
        T dato = tope.getDato();
        aux.setSig(null);
        return aux.getDato();    
    }

    @Override
    public boolean isEmpty() {
        return tope==null;
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new EmptyCollectionException("No hay datos en la pila");
        return tope.getDato();
            
    }
    
}

