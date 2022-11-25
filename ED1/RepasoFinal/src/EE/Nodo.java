/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

/**
 *
 * @author dianam
 */
public class Nodo <T> {
    private T dato;
    private Nodo<T> siguiente;
    
    public Nodo(){
        siguiente=null;
    }
    
     public Nodo(T dato){
        this.dato=dato;
        this.siguiente= null;
        
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSig() {
        return siguiente;
    }

    public void setSig(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
//    public Nodo <T> getDireccion(){
//        return direccion;
//    }
//    
//    public 

    @Override
    public String toString() {
        return dato + "\n";
    }
     
     
    
}

