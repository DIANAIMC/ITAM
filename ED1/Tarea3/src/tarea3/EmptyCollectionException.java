/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

/**
 *
 * @author dianam
 */
public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException() {
        super("The collection is empty.");
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
