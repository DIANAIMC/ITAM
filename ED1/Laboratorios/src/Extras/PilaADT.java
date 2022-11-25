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
public interface PilaADT <T>{
    public void push(T dato); 
    public T pop();//sacar el dato de arriba (se borra)
    public T peek();// ver el dato de arriba (no se borra)
    public boolean isEmpty(); //si hay un dato o mas => true | false 
    //public boolean equals(PilaADT<T> otra);
    
    
}