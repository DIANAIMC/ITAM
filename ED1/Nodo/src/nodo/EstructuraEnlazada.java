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
public class EstructuraEnlazada<T> {
    private Nodo<T> primero;
    public EstructuraEnlazada() {
        primero=null;
    }
    public Nodo<T> getPrimero() {
        return primero;
    }
// Agrega un nuevo nodo con el dato especificado como argumento al inicio // de la secuencia de nodos de una estructura enlazada:
    public void agregaAlInicio(T dato) { 
        Nodo<T> prim=new Nodo(dato);
        prim.setSig(primero);
        primero=prim;
    }
    
    public void agregaAlFinal(T dato){
        if(primero!=null){
            Nodo<T> siguiente=primero.getSig();
            while(siguiente.getSig()!=null){
                siguiente=siguiente.getSig();
            }
            Nodo<T> nuevo= new Nodo(dato);
            siguiente.setSig(nuevo);
        }else{
            primero=new Nodo(dato);
        } 
    }
    
    //versión recursiva
    public void agregaAlFina(T dato){
        Nodo<T> nuevo=new Nodo(dato);
        if(primero==null)
            primero=nuevo;
        else
            agregaAlFinaR(primero, nuevo);
    }
    
    public void agregaAlFinaR(Nodo<T> aux, Nodo<T> nuevo){
        if(aux.getSig()==null)
            aux.setSig(nuevo);
        else
            agregaAlFinaR(aux.getSig(), nuevo);
    }
    
    public T eliminaUltimo(){
        T res=null;
        Nodo<T> aux=primero;
        if(aux!=null){
            // Si el último dato resulta también ser el primero (y único):
            if(aux.getSig()==null)
                
        }
    }
}
