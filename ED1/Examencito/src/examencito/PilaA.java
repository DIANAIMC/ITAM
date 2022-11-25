/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencito;

/**
 *
 * @author dianam
 */
public class PilaA  <T> implements PilaADT<T>{
    private T[] coleccion;
    private int tope;
    private static int MAX=20;
    
    public PilaA(){
        coleccion=(T[]) new Object[MAX];
        tope=-1;
    }
    public PilaA(int max){
        coleccion=(T[]) new Object[max];
        tope=-1;
    }
    
    public int getTope(){
        return this.tope;
    }
    
    public boolean isEmpty(){
        return tope==-1;
    }
    
    public void push(T dato){
        if(tope==coleccion.length-1)//es length no sabes si ya habia pasado por ahi
            expandCapacity();
        tope++;
        coleccion[tope]=dato;
    }
    
    public void expandCapacity(){//or maybe private
        T[] nuevo=(T[]) new Object[coleccion.length*2];
        for(int i=0;i<coleccion.length;i++)
            nuevo[i]=coleccion[i];
        coleccion=nuevo;
    }
    
   /* public boolean equals(PilaADT<T> otra){
        PilaADT<T> aux=new PilaA<T>();
        PilaADT<T> aux2=new PilaA<T>();
        
        while(!this.coleccion.isEmpty()&& !otra.isEmpty())
    }*/
    
    /*public T pop(){
        T result;
        if(isEmpty())
            result=null;
        else{
            result=coleccion[tope];
            coleccion[tope]=null;
            tope--;
        }
        return result;
    }*/
    
    public T pop(){
          T result;
        if(isEmpty())
            throw new EmptyCollectionException("Pila vacia");//esto aborta el programa al iterrumpir un error la excepcion te saca

        else{
            result=coleccion[tope];
            coleccion[tope]=null;
            tope--;
                return result;
        }
        
    }
    
    /*public T peek(){
        T result;
        result=null;
        if(!isEmpty())
            result=coleccion[tope];
        return result;
    }*/
    
    public T peek(){
        
        if(!isEmpty())
            return coleccion[tope];//pasa el control de la maquina por lo que no se necesita el y porque ya se sale dado a que es un solo if
        //else
            throw new EmptyCollectionException("Pila vacia");
    }
    
}
