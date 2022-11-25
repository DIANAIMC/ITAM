/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author dianam
 */
public interface Pila <T> {
    
    public boolean push(T newElement);
    public T pop();
    public T peek();
}
