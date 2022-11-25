/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;
import Extras.PilaA;
import Extras.PilaADT;

public class Lab_7 {
    
    /**
     * EJERCICIO_1
     * Escribe un método estático que reciba un arreglo de enteros e imprima cada uno de sus
        componentes: a) de izquierda a derecha y b) de derecha a izquierda. Debes usar recursión.
        Prueba tu solución.
     */
    
    
    public static void imprimeIzqDer(int[] array){
        imprimeIzqDer(array, 0);
    }
    
    private static void imprimeIzqDer(int[] array, int i){
        if(i<array.length){//ER
            System.out.print(" "+array[i]); 
            imprimeIzqDer(array, i+1);//AEB 
        }
        System.out.println("\n");
        //EB
    }
    
    
    // {1,2,3,4} a[3] => a[2] 
    public static void imprimeDerIzq(int [] array){
        imprimeDerIzq(array, array.length-1);
    }
    
    private static void imprimeDerIzq(int [] array, int n){
        if(n>=0){//ER
            System.out.print(" " +array[n]);
            imprimeDerIzq(array, n-1);//AEB
        }
        System.out.println("\n");
        //EB
    }
    

    

    
    /**
     * EJERCICIO_2
     * Calcular el valor de x^n sin hacer uso de Math.pow(). Max. dos variables
     * x^n=x1*x2*...*xn
     * x^3=1*x*x*x
     * 
     * n=1 => x
     * n=0 => 1
     */
    
    public static int elevarNumero(int x, int n){
        if(n==1){
            return x;
        }else{
           return x*elevarNumero(x, n-1);
        }
    }
    
    
    /**
     * EJERCICIO_3
     * Suma los elementos de un arrgelo de forma recursiva
     */
    
    public static int sumaArray(int [] array){
        return sumaArray(array, 0);
    }
    
    private static int sumaArray(int [] array, int i){
        if(i==array.length-1){//EB
            return array[i];
        }else{//ER
            return array[i]+sumaArray(array, i+1);//AEB
        }
    }



    
    /**
     * EJERCICIO_4
     * Haga un algoritmo recursivo que regrese TRUE si una cadena es palindromo y FALSE en caso contrario
     * anna
     * anna
     * hola
     * aloh
     * 
     * cad(0)[a] vs cad(3)[a] 
     * cad(1)[n] vs cad(2)[n]
     * 
     * cad(0)[h] vs cad(3)[a] 
     * cad(1)[o] vs cad(2)[l]
     * 
     * i=0, n=a.length-1
     * cad(i) vs cad(n-i) 
     */
    
    public static boolean esPalindromo(String cad){
        return esPalindromo(cad, 0);
    }
    
    private static boolean esPalindromo(String cad, int i){
        if(i<cad.length()/2 && cad.charAt(i)!=cad.charAt(cad.length()-1-i)){//EB
            return false;
        }else{
            if(i<cad.length()/2){//EB
                return true;
            }else{//ER
                return esPalindromo(cad, i+1);//AEB
            }
        }
    }
    


   
    /**
     * EJERCICIO_5
     * Escribe un metodo estatico recursivo que reciba un vector como parametro, y regrese un vector 
     * con el siguente algoritmo. Utiliza la cantidad de metodos que creas necesarios
     * 1. Suma los elementos del arreglo dado 
     * 2. El arreglo resultante contendra la suma en la primer casilla, la suma+1 en la seguna, y asi sucesivamente
     * [2|5|3|1|4]=> [15|16|17|18|19]
     */
    
    public static int [] vectorSuma(int [] array){//metodo principal
        int suma;
        suma=vectorSuma(array, 0);//1. Suma arreglo
        return vectorSuma(new int [array.length], 0, suma);
        
    }
    
    private static int  vectorSuma(int [] array, int i){//suma de los elementos
        if(i==array.length-1){
            return array[i];
        }else{
            return array[i]+vectorSuma(array, i+1);
        }
    }
    
    private static int [] vectorSuma(int [] newVec, int i, int suma){//arreglo modificado
        if(i<newVec.length){//ER
            newVec[i]=suma+i; //suma
            return vectorSuma(newVec, i+1, suma); //AEB (i+1) suma+1
        }
        //EB
        return newVec;
    }

    

    
    /**
     * EJERCICIO_6
     * Torres de Hanoi
     * 1. Mover los n-1 discos a de origen la torre auxiliar, posteriormente  
     * 2. Mover el disco n de origen a destino (n=1)
     * 3. Mover los n-1 discos de auxiliar a destino 
     * El numero de pasos necesario para mover n discos es 
     * O(n)=2^n-1
     * Referencias:
     * Guardati B., S.(2016). Estructuras de Datos Básicas. Alfaomega.
     * https://www.youtube.com/watch?v=lilBGvaOSy8 
     */
    
    public static int torresHanoi(int n){
        return torresHanoi(n, "Origen", "Destino", "Aux");
    }
    
    private static int torresHanoi(int n, String tO, String tD, String tA){
        if(n==1){
            System.out.println("Mueve de "+ tO+ " a "+tD);
            return 1;
        }else{
            int resp;
            resp=torresHanoi(n-1, tO, tA, tD);
            System.out.println("Mueve de "+ tO+ " a "+tD);
            resp=resp+1+torresHanoi(n-1, tA, tD, tO);
            return resp;
        }
    }
    
    
    

     
    
    
    public static void main(String[] args) {
        int [] array={1,2,3,4};
        Double [] randomArray={Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random()};
        int [] arrSum={2,5,3,1,4}; //15
        String cad="anna";
        
        System.out.println("EJERCICIO_1A");
         imprimeIzqDer(array);
        
        System.out.println("EJERCICIO_1B");
        imprimeDerIzq(array);

       System.out.println("EJERCICIO_2");
        System.out.println(elevarNumero(3,3));

        System.out.println("EJERCICIO_3");
        System.out.println(sumaArray(arrSum));

       System.out.println("EJERCICIO_4");
        System.out.println(esPalindromo(cad));

        System.out.println("EJERCICIO_5");
        imprimeIzqDer(vectorSuma(arrSum));
        
        System.out.println("EJERCICIO_6");
        System.out.println("Numero de movimientos: "+torresHanoi(7));


    }
    
}