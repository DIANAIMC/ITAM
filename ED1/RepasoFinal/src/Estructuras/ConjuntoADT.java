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
public interface ConjuntoADT<T> extends Iterable<T> {
    public Iterator<T> iterator();
    public boolean agrega(T nuevo);
    public T quita(T dato);
    public boolean contiene(T elemento);
    public int getCardinalidad();
    public boolean estaVacio();
    public String toString();
//    public ConjuntoADT<T> interseccion(ConjuntoADT<T> conjunto);
//    public ConjuntoADT<T> union(ConjuntoADT<T> conjunto);
//    public ConjuntoADT<T> diferencia(ConjuntoADT<T> conjunto);
//    public ConjuntoADT<T> unionConjuntoR(ConjuntoADT<T> conjunto);
    
    
}
