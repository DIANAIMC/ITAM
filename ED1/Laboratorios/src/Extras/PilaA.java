/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;


/**
 *
 * @author Yulia
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

    @Override
    public T pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean equals (PilaADT<T> otra){
        PilaADT <T>aux = new PilaA<T>();
        PilaADT<T>aux2 = new PilaA<T>();
        return true;
    }
}

