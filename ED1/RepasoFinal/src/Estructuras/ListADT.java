/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author dianam
 */
public interface ListADT<T> extends Iterable<T> {
    public T removeFirst();
    public T removeLast();
    public T remove(T dato) throws NoSuchElementException; 
    public T first();
    public T last();
    public boolean isEmpty();
    public int size();
    public Iterator<T> iterator();
    public String toString();
    public boolean contains(T dato);
    public void clear();
}
