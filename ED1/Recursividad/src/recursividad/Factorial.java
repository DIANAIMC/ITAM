/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad;

/**
 *
 * @author dianam
 */
public class Factorial {
    public static void main(String[] args) {
        double x=factIter(5);
        double y=fact(5);
        System.out.println(x);
        System.out.println(y);
    }
//sin recursividad, usando ciclos normales
    public static double factIter(int n) {
        double prod=1;
        if(n<0) {
            prod=-1;
            System.out.println("No está definido el factorial para valores negativos.");
        }
        else
            for(int i=n; i>0 ; i--)
                prod=prod*i;
        return prod;
    }
    //con recursividad
    public static int fact(int n) {
        if(n<0) {
            System.out.println("No está definido el factorial para valores negativos.");
            return -1;
        }
        else
            return factR(n);
    }
    
    private static int factR(int n) {
        if(n==0)
            return 1;
        else
            return n*factR(n-1);
    }
}
