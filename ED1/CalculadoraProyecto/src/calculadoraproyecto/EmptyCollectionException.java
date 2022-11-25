/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraproyecto;

/**
 *
 * @author dianam
 */
public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException(){
        super("La colección está vacía");
    }

    public EmptyCollectionException(String mensaje){
        super("La colección está vacía: "+mensaje);
    }
    
}