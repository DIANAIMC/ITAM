/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caratulacalculadora;

/**
 *
 * @author Diana, Yuliana, Camila, Alejandra
 */
public interface StackADT<X> {
    public void push(X objeto);

    public X peek();

    public X pop();

    public boolean isEmpty();
    
}
