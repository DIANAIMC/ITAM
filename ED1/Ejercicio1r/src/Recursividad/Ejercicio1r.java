/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

/**
 *
 * @author dianam
 */
public class Ejercicio1r {
   
    //iterable
    public static int IzquierdaDer(int arreglo[], int length){
        for(int i=0;i<length;i++){
            int res=arreglo[i];
            System.out.println(res); 
        }
        return 1;
    }
        
//recursvio ejercicio 1
    public static void IzqDer(int a[], int i){    //[]a= {1,2,3}; IzqDer(a, 0)
        if(i==a.length)
            return;
        else{
            System.out.println(a[i]);;
            IzqDer(a,i+1);
        } 
       
    }
    
    public static void IzqDer(int a[]){
        IzqDer(a,0);
        System.out.println("ya hay mas elementos");
    }
/*
    2) Imprimir los valores almacenados en un arreglo (no lleno) de enteros de izquierda a derecha 
    (es decir, empezando por imprimir el valor que está en el índice 0 y terminando por imprimir el 
    valor que está en algún índice n, donde n<tam y tam es la cantidad de casillas que contiene el arreglo) 
    (máximo dos variables).
    */

    public static void IzqDer2(int a[], int i){
        if(i== a.length)
            return;
        if(a[i] == 0){
            IzqDer2(a,i+1);
        } 
        else{
            System.out.println(a[i]);
            IzqDer2(a,i+1);
        }
       
    }
    
    public static void IzqDer2(int a[]){
        IzqDer2(a,0);
        System.out.println("");
    }
    
    /*
    3) Imprimir los valores almacenados en un arreglo (no lleno) de enteros de derecha 
    a izquierda (del valor que está en algún índice n al valor que está en el índice 0...
    ver notas en el ejercicio 2 arriba) (máximo dos variables).
    */
    
     public static void DerIzq3(int a[], int i){ //i=0
        if(i== 0)
            return;
        if(a[i] == 0){
             DerIzq3(a,i-1);
        } 
        else{
            System.out.println(a[i]);
            DerIzq3(a,i-1);
        }
       
    }
    
    public static void IzqDer3(int a[]){
        DerIzq3(a,a.length);
        System.out.println("");
    }
    
    //Sumar los valores almacenados en un arreglo (no lleno) de enteros (máximo dos variables).
    public static int no(int a[], int i){
        if(i == a.length-1)                  //for(int i=0;i<a.length;i++)
            return 0;
        else         
            return a[i]+no(a,i+1);
    }
    
    public static void no(int a[]){
        no(a,0);
        System.out.println("");
    }
    
    //5) Contar cuántos valores impares hay en un arreglo (no lleno) de enteros (máximo dos variables).
    
    public static int impares(int []a,int i){
        if(i<a.length){
            if(a[i]%2!=0)
                return 1+impares(a,i+1);
            else
                return 0+impares(a,i+1);
            }
        return 0;
        }
    
    //6) Encontrar el valor máximo de los valores almacenados en un arreglo (no lleno) de enteros (máximo tres variables).
    public static int max(int a[], int i, int aux){ //i=0
        System.out.println(aux);
        if(i== a.length-1)
            return 0;
        else{  
        if(a[i] > aux)
            aux=a[i];
        }
        max(a,i+1,aux);
        System.out.println(aux);
       return aux;
    }
    
    public static void max(int a[]){
        max(a,0,0);
        System.out.println("");
    }
    
    /*
    7) Calcular (sin hacer uso del método predefinido Math.pow) el valor de xn, 
    donde x es un número real y n es un número entero mayor o igual a cero (máximo dos variables).
    x=número
    n=potencia
    */
    public static int potencia(int x, int n){
        if(n<0){
            System.out.println("no estamos en cálculo bye");
            return -1;
        }
        else
            return potenciaR(x,n);
    }
    
    public static int potenciaR(int x, int n){
        if(n==0)
            return 1;
        else
            return x*potenciaR(x,n-1);
    }
    
    /*
    8) Contar cuántos dígitos tiene un número entero positivo sin convertirlo en un String equivalente (máximo una variable).
    */
    // usar /
    public static int digitos(int dig){
        if(dig<0)
            return -1;                               //1678, 167, 16, 1
        else
            return digitosR(dig);
    }
    
    public static int digitosR(int dig){
        if(dig<10)
            return 1;
        else
            return 1+digitosR(dig/10);
    }
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int []a= {1,2,3};
    int []c= {1,2,3,0,5,7,0};
    int []b= new int[4]; //b{0,1,3,0}  indice=0.1.2.3   length=4;
    b[1]=1;
    b[2]=3;
    IzquierdaDer(a,3);
    System.out.println("ejercicio1 ");
    IzqDer(a, 0);
    System.out.println("ejercicio2 ");
    IzqDer2(b, 0);
    System.out.println("ejercicio3 ");
    DerIzq3(b, b.length-1);
    System.out.println("ejercicio4 "+no(b,0));
    System.out.println("ejercicio5 "+impares(c,0));
    System.out.println("ejercicio6 "+max(c,0,0));
    System.out.println("ejercicio7 "+potencia(2,4));
    System.out.println("ejercicio8 "+digitos(786));
    }
}
