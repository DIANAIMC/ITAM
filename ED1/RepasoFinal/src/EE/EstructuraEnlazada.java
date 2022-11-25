/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

/**
 *
 * @author dianam
 * version de clase Andrés
 */
public class EstructuraEnlazada<T> {
    private Nodo<T> primero;
    
    public EstructuraEnlazada() {
        primero=null;
    }
    
    public Nodo<T> getPrimero() {
        return primero;
    }
    
    public void agregaAlInicio(T dato) {
        Nodo<T> nuevo=new Nodo(dato);
        nuevo.setSig(primero);
        primero=nuevo;
    }
    //forma iterativa
    public void agregaAlFinal(T dato){
        Nodo<T> nuevo=new Nodo(dato);
        if(primero==null)
            primero=nuevo;
        else {
            Nodo<T> aux=primero;
            while(aux.getSig()!=null)
                aux=aux.getSig();
            aux.setSig(nuevo);
        }
    }
    //forma recursiva
    public void agregaAlFinalR(T dato) {
        Nodo<T> nuevo=new Nodo(dato);
        if(primero==null)
            primero=nuevo;
        else
            agregaAlFinalR(primero,nuevo);
}
    private void agregaAlFinalR(Nodo<T> aux,Nodo<T> nuevo) { 
        if(aux.getSig()==null)
            aux.setSig(nuevo);
        else
            agregaAlFinalR(aux.getSig(),nuevo);
    }
    
    public void agregaDespuesDe(T datoNvo,T datoAnt) { 
        Nodo<T> nuevo=new Nodo<T>(datoNvo);
        Nodo<T> aux=primero;
        if(aux==null)
            primero=nuevo;
        else { 
            while(aux.getSig()!=null&&!aux.getDato().equals(datoAnt)) 
                aux=aux.getSig();
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
        }
    }
    
//    public void agregaAntesDe(T dato, T refer){
//        if(primero.getDato().equals(refer)){
//            agregaAlInicio(dato);   
//        } else {
//            Nodo<T> nuevo=new Nodo<T>(dato);
//            Nodo<T> actual=primero;
//            while(actual.getSig()!=null && !actual.getSig().getDato().equals(refer))
//                actual = actual.getDir();
//        }
//            if(actual.getSig()!= null){
//                nuevo.setSig(actual.getSig);
//                actual.setSig(nuevo);
//        } 
//    }
    
    public T eliminaPrimero() {
        T res=null;
        Nodo<T> aux=primero;
        if(aux!=null) {
            primero=primero.getSig();
            res=aux.getDato();
            // Optativo:
            aux.setSig(null);
        }
        return res; 
    }
    
    public T eliminaUltimo() {
        T res=null;
        Nodo<T> aux=primero;
        if(aux!=null) {
        // Si el último dato resulta ser también el primero (y único): if(aux.getSig()==null) {
            if(aux.getSig()==null) {
            res=aux.getDato();
            primero=null;
            }
        // En caso contrario:
            else {
            // Se mueve "aux" hasta que apunte al nodo previo al último: 
                while(aux.getSig().getSig()!=null)
                    aux=aux.getSig();
                res=aux.getSig().getDato();
                aux.setSig(null);
            } 
        }
        return res; 
    }
     public T eliminaDato(T dato) {
        T res=null;
        Nodo<T> aux=primero;
        if(aux!=null) {
            // Si resulta que hay un solo nodo en la estructura enlazada: 
            if(aux.getSig()==null) {
                // Entonces elimina dicho nodo sólo si contiene el dato que se 
                // pidió eliminar, y en caso contrario no hace nada: 
                if(aux.getDato().equals(dato)) {
                    res=aux.getDato();
                    primero=null;
                }
            }
            // En caso contrario:
            else {
            // Si el primer nodo contiene el dato que se pidió eliminar: 
                if(aux.getDato().equals(dato)) {
                        res=aux.getDato();
                        primero=primero.getSig();
                        aux.setSig(null);
                    }
                    // En caso contrario:
                    else {
                        // Se mueve "aux" hasta que apunte al nodo previo al
                        // primer nodo que contenga el dato que se buscaba, o
                        // hasta que apunte al último nodo de la estructura 
                        // enlazada:
                        while(aux.getSig()!=null&&!aux.getSig().getDato().equals(dato)) 
                            aux=aux.getSig();
                        // En caso de que "aux" se haya detenido en un nodo que 
                        // tiene un nodo subsecuente, se elimina el nodo
                        // de la secuencia:
                        if(aux.getSig()!=null) {
                            Nodo<T> aux2=aux.getSig();
                            res=aux2.getDato();
                            aux.setSig(aux2.getSig());
                            aux2.setSig(null);
                        }
                    }    
            }
        }
        return res;
     }
} 
