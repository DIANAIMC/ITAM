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
public interface Cola<T>  {
    
    public boolean enqueue(T newElement);
    public T dequeue ();
    public T first ();
    public T last ();
    public T[] multiDequeue(int n);
    
}
