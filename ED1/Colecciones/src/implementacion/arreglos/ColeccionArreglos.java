/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion.arreglos;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author dianam
 */
public abstract class ColeccionArreglos <T> implements Collection<T> {

    protected T[] arr;
    protected int lastIndex;
    protected float growthFactor;
    
    public ColeccionArreglos(int initialSize, float growthFactor) {
        if(initialSize<1 || growthFactor<=1){
            throw new IllegalArgumentException("No mames, no puede haber índice negativo");
        }
        arr = (T[]) new Object[initialSize];
        
        lastIndex=-1;
        this.growthFactor = growthFactor;
    }

    
    public ColeccionArreglos (int initialSize) {
        this(initialSize,2);
    }
    
    public ColeccionArreglos(){
        this(10,0);
    }
    
    @Override
    public boolean isEmpty() {
        return lastIndex==1;
    }
    
    @Override
    public int size() {
    }

    @Override
    public boolean contains(Object o) {
        T e=(T) o;
        for(int i=0; i<=lastIndex; i++){
            if(arr[i].equals(e))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * The iterable index.
             */
            private int index=lastIndex;
            /**
            * {@inheritDoc}
            */
            @Override
            public boolean hasNext() {
                return index>=0;
            }
            /**
            * {@inheritDoc}
            */
            @Override
            public T next() {
                if(index>0){
                    throw new NoSuchElementException("The stack has no more elements");
                }
                index--;
                return arr[index];
            }


       };
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] o=c.toArray();
        for(int i=0; i<o.length; i++){
            
        }
    }
    
    
    
}
