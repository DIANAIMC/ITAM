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
public class EmptyColectionException extends    RuntimeException {
    public EmptyColectionException(){
        super("coleccion vacia");
    }

    public EmptyColectionException(String pila_Vacía) {
        super(pila_Vacía);
    }
    
}
