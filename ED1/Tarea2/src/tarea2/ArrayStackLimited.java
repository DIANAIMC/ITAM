/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * @author Diana Muñoz, Yuliana Padilla, Camila Fernández
 */
public class ArrayStackLimited <T> extends ArrayStack{
   
    public ArrayStackLimited(int capacidad){
        super(capacidad);
    }
    
    public boolean isFull(){
        return stack.length==top;
    }
    
}
