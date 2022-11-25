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
public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException() {
        super("Coleccion vacia");
    }
    
    public EmptyCollectionException(String mensaje) {
        super(mensaje);
    }
}