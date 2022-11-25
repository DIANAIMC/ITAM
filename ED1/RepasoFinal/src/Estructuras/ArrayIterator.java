package Estructuras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author dianam
 */
public class ArrayIterator<T> implements Iterator<T> {
    private int count;    // the number of elements in the collection
    private int current;  // the current position in the iteration
    private T[] items;

    public ArrayIterator(T[] collection,int size) {
        items=collection;
        count=size;
        current=0;
    }

    public boolean hasNext() {
        return current<count;
    }

    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        else {
            current++;
            return items[current-1];
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

