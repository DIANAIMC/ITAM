/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import java.util.Iterator;
/**
 *
 * @author yuliana
 */
public interface ConjuntoADT<T> extends Iterable<T> {
    public boolean contains(T dato);
    public boolean isEmpty();
    public boolean add(T dato);
    public T remove(T dato);
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> inter(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    public int getCardinalidad();
    public String toString();
    public boolean equals(ConjuntoADT <T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
    public ConjuntoADT<T> unionR(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interR(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferR(ConjuntoADT<T> otro);
    
}