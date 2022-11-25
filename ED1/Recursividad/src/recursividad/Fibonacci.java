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
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x=fibR(5);
        int y=fib(5);
        System.out.println(x);
        System.out.println(y);
    }

    public static int fibR(int n) {
	if(n<0) {
            System.out.println("No está definida la sucesión de Fibonacci para valores negativos.");
            return -1;
	}
        else
            return fibR2(n);
    }
    
    private static int fibR2(int n) {
	if(n==0)
            return 0;
	else if(n==1)
            return 1;
	else
            return fibR(n-1)+fibR(n-2);
    }

    public static int fib(int n) {
	int fib=-1;
	if(n<0)
            System.out.println("La sucesión de Fibonacci no tiene términos negativos.");
	else {
            if(n<=1)
		fib=n;
            else {
		fib=1;
		int prevFib=1;
		int temp;
		
		for(int i=2;i<n;i++) {
                    temp=fib;
                    fib=fib+prevFib;
                    prevFib=temp;
		}
            }
	}
	return fib;
    }
}