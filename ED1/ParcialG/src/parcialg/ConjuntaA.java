/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialg;

/**
 *
 * @author dianam
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;


public class ConjuntaA<T> implements ConjuntoADT<T>{
    private T[] coleccion;
    private int cardinalidad;
    private final int MAXIMO=50;
    
    public ConjuntoA(){
        coleccion= (T[]) new Object[MAXIMO];
        cardinalidad=0;
    }
    
    public ConjuntoA(int maximo){
        coleccion= (T[]) new Object[maximo];
        cardinalidad=0;
    }
    
    public boolean estaVacio(){
        return cardinalidad==0;
    }
    
    public int getCardinalidad(){
        return cardinalidad;
    }
    
    public Iterator<T>iterator(){
        return new IteradorArreglo(coleccion, cardinalidad);
        
    }
    
    public boolean contiene(T elemento){
        Iterator<T> it= this.iterator();
        boolean resp=false;
        
        while(it.hasNext() && !resp)
            resp= it.next().equals(elemento);
        return resp;
        
        
    }
    
    public boolean agrega(T nuevo){
        boolean resp=false;
        
        if(!contiene(nuevo)){
            if(cardinalidad==coleccion.length)
                expande();
            coleccion[cardinalidad]=nuevo;
            cardinalidad++;
            resp=true;
        }
        return resp;
    }
    
    private void expande(){
        T[]masGrande= (T[]) new Object[coleccion.length*2];
        
        for(int i=0; i<cardinalidad;i++)
            masGrande[i]=coleccion[i];
        coleccion=masGrande;
    }
    
    public String toString(){
        StringBuilder sB= new StringBuilder();
        for(int i=0;i<cardinalidad;i++)
            sB.append(coleccion[i]).append(" ");
        return sB.toString();
            
    }
    
    public int buscaElemento(T dato){
        int i;
        
        i=0;
        while(i<cardinalidad && !coleccion[i].equals(dato))
            i++;
        if(i==cardinalidad)
            i=-1;
        return i;   
    }
    
    public T quita(T elemento){
        int pos;
        T resultado;
        pos= buscaElemento(elemento);
        if(pos>=0){
            resultado=coleccion[pos];
            coleccion[pos]=coleccion[cardinalidad-1];
            coleccion[cardinalidad-1]= null;
            cardinalidad--;         
    }
        throw new ExcepcionColeccionVacia(); 
}
    
    public ConjuntoADT<T>interseccion(ConjuntoADT<T> conjunto){
        ConjuntoADT<T>conjAux= new ConjuntoA();
        
        for(int i=0;i<cardinalidad;i++){
            if(conjunto.contiene(coleccion[i]))
                conjAux.agrega(coleccion[i]);
        }
        return conjAux;
        
    }
    
    public ConjuntoADT<T>union(ConjuntoADT<T> conjunto){
        ConjuntoADT<T>conjAux= new ConjuntoA();
        Iterator<T> it=conjunto.iterator();
        
        for(int i=0;i<cardinalidad;i++)
            conjAux.agrega(coleccion[i]);
        
        while(it.hasNext())
            conjAux.agrega(it.next());
        
        return conjAux;  
    }
    
    public ConjuntoADT<T> unionConjuntoR(ConjuntoADT<T> conjunto){
        if(conjunto==null)
            throw new ExcepcionColeccionVacia("Conjunto nulo");
        else{   
        ConjuntoADT<T>conjAux= new ConjuntoA();
        Iterator<T> it=conjunto.iterator();
        return unionConjuntoR(conjunto, conjAux, it, 0);
        }
            
    }
    
    private ConjuntoADT<T> unionConjuntoR(ConjuntoADT<T> conjunto, ConjuntoADT<T> aux, Iterator<T> it, int i){
        if(i==cardinalidad){
            if(it.hasNext()){
                aux.agrega(it.next());
                return unionConjuntoR(conjunto, aux, it, i);
            }
            else
                return aux;
            
            
        }        
        else{      
        aux.agrega(coleccion[i]);
        return unionConjuntoR(conjunto, aux, it, i+1);
        }    
    }
    
    public ConjuntoADT<T> interseccionRec(ConjuntoADT<T> conjunto){
        if(conjunto!=null){
            ConjuntoADT<T> aux= new ConjuntoA();
            interseccionRec(conjunto, aux, 0);
            return aux;
        }
                else{
                        throw new NullPointerException();
                        }
            }
       
        
    public ConjuntoADT<T> interseccionRec(ConjuntoADT<T> conjunto, ConjuntoADT<T> aux, int i){
        if(i!=cardinalidad){
            if(conjunto.contiene(coleccion[i])){
                aux.agrega(coleccion[i]);
        }
        interseccionRec(conjunto, aux, i+1);
    }
        return null;
}

    
    
    
    
    
    public ConjuntoADT<T>diferencia(ConjuntoADT<T> conjuntoB){
        ConjuntoADT<T> auxA= new ConjuntoA();
        
        for(int i=0; i<cardinalidad; i++)
            if(!conjuntoB.contiene(coleccion[i]))
                auxA.agrega(coleccion[i]);
        
        return auxA;
    }
    
    
    
    
    
    
