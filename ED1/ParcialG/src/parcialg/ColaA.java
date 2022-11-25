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
public class ColaA <T> implements ColaADT<T> {
    private T[] datos;
    private int fin;
    private int frente;
    private final int MAXIMO = 20;

    public ColaA() {
        datos = (T[]) new Object[MAXIMO];
        frente = -1;
        fin = -1;
    }
    
    public ColaA(int maximo) {
        datos = (T[]) new Object[maximo];
        frente = -1;
        fin = -1;
    }
    
    @Override
    public boolean estaVacia(){
        return frente == -1;
    }
    
    @Override
    public T consultaPrimero(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("Cola sin elementos");
        return datos[frente];
    }
    
    @Override
    public void agrega(T nuevo){
        if ((fin + 1) % datos.length == frente)    
            expandeCapacidad();
        fin = (fin + 1) % datos.length;
        datos[fin] = nuevo;
        if (frente == -1)
            frente = 0;
    }
    
    @Override
    public T quita(){
       if (estaVacia())
           throw new ExcepcionColeccionVacia("Cola sin elementos");
       T resultado = datos[frente];
       datos[frente] = null;
       if (frente == fin) {
           frente = -1;    
           fin = -1;
       }
       else
           frente = (frente + 1) % datos.length;
       return resultado;
    }
    
    private void expandeCapacidad(){
        T [] nuevo = (T[]) new Object[datos.length * 2];
        int i, tam;
        
        tam = datos.length;
        for (i= 0; i < tam; i++)
            nuevo[i] = datos[(frente + i) % tam];
        frente = 0;
        fin = tam - 1;
        datos = nuevo;
    }
    
    @Override
    public String imprimeCola(){
        StringBuilder res = new StringBuilder();
        
        if (!estaVacia()){
            int i;

            i = frente;
            while (i % datos.length != fin % datos.length){
                res.append(datos[i % datos.length]).append(" ");
                i++;
            }
            res.append(datos[i % datos.length]).append("\n");
        }
        return res.toString();
    }
}
