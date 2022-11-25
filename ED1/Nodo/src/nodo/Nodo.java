/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodo;

/**
 *
 * @author dianam
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> sig;
    
    public Nodo() {
        dato=null;
        sig=null; 
    }
    
    public Nodo(T dato) {
        this.dato=dato;
        sig=null; 
    }
    
    public T getDato() {
        return dato;
    }
    
    public void setDato(T dato) {
        this.dato=dato;
    }
    
    public Nodo<T> getSig() {
        return sig;
    }
    
    public void setSig(Nodo<T> n) {
    this.sig=n;
    }
    
    public String toString() {
    return dato.toString();
    }
}
