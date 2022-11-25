/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialg;

/**
 *
 * @author dianam
 */
public interface ColaADT <T> {
    public void agrega(T nuevo);
    public T quita();
    public T consultaPrimero();
    public boolean estaVacia();
    public String imprimeCola();
}

