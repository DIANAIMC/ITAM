/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conjuntos;

import conjuntos.BingoBall;
import conjuntos.ArraySet;
import java.util.*;

/**
 *
 * @author agomezdg
 */
public class Main {
    public static void main(String args[]){
        final int NUM_BALLS=75;
        final int NUM_PULLS=10;
        //arreglo en el que se agrupará los datos del conjunto
        ArraySet<BingoBall> bingoSet=new ArraySet<BingoBall>();
        BingoBall ball;

        for(int num=1;num<=NUM_BALLS;num++) {
            ball=new BingoBall(num);
            bingoSet.add(ball);
        }

        System.out.println("Conjunto contiene 1: "+bingoSet.contains(new BingoBall(1)));
        System.out.println("Tamaño del conjunto: "+bingoSet.size()+"\n");

        System.out.println("Bolas seleccionadas y removidas:");
        for(int num=1;num<=NUM_PULLS;num++) {
            ball=bingoSet.removeRandom();
            System.out.println(ball);
        }

        // Se puede usar el toString de la clase ArraySet para ver qué
        // contiene el conjunto al final:
        System.out.println("\nBolas restantes usando toString:");
        System.out.println(bingoSet.toString());

        // Se podría usar un 'for' tradicional para "visitar" cada objeto
        // del conjunto y luego verlo (usando el toString de la clase
        // BingoBall)...pero esto termina eliminando los objetos del
        // conjunto, ya que tenemos un método removeRandom pero no tenemos
        // nada equivalente a peek, así es que hay que restaurarlo al final:
        System.out.println("\nBolas restantes usando 'for' tradicional:");
        BingoBall pelotita;
        ArraySet<BingoBall> aux=new ArraySet<BingoBall>();
        int j=bingoSet.size();
        for(int i=0;i<j;i++) {
            pelotita=bingoSet.removeRandom();
            System.out.println(pelotita);
            aux.add(pelotita);
        }
        bingoSet=aux;

        // Se puede usar esta otra forma del 'for' para visitar los
        // diversos elementos del conjunto e imprimirlos sin eliminarlos:
        System.out.println("\nBolas restantes usando 'for' nuevo:");
        for(BingoBall pelota:bingoSet)
            System.out.println(pelota);

        // O se puede usar un iterador para visitar los diversos elementos
        // del conjunto e imprimirlos sin eliminarlos:
        System.out.println("\nBolas restantes usando iterador");
        Iterator<BingoBall> it = bingoSet.iterator();
        while(it.hasNext()) {
            ball=it.next();
            System.out.println(ball);
        }
    }
}
