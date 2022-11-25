/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author dianam
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr={94,7,36,8,-2,9823,120};
        imprimirIzqADerR(arr);
    }
    
    public static void imprimirIzqADerR(int[] a) {
        imprimirIzqADerR(a,0);
        System.out.println("");
    }
    
    private static void imprimirIzqADerR(int[] a,int i) {
        if(i==a.length)
            return;
        else {
            System.out.print(a[i]+" ");
            imprimirIzqADerR(a,i+1);
        }
    }
}