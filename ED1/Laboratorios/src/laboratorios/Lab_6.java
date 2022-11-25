/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yulia
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

/**
 *
 * @author AChavero
 */
public class Lab_6 {
    
    /**
     * Recuerda en cada método tomar en cuenta los tres elementos de un planteamiento recursivo 
     * 1. Estado base
     * 2. Estado recursivo 
     * 3. Acercamiento al estado base
     */
    
    /**
     * EJERCICIO_1
     * Escribe un método recursivo que sume los primeros n enteros 
     * n=9 => suma=9+8+7+6+5+4+3+2+1=45
     * n+(n-1).....
     * n+(n-i), i=1,2...
     * Estado base n==0
     * 
     * sN(n):
     * n=4
     * De ida
     * sN(4)= 4+sN(3)
     * sN(3)= 3+sN(2)
     * sN(2)= 2+sN(1)
     * sN(1)= 1+sN(0)
     * sN(0)= 0
     * ___________
     * 
     * De regreso
     * 
     * sN(0)=0
     * sN(1)= 1+0=1
     * sN(2)= 2+1=3
     * sN(3)= 3+3=6
     * sN(4)= 4+6=10
     * 
     * res=sN(4)=10
     * 
     */
    
    
    
    public static int sumaNaturales(int n){
        if(n==0){//Estado Base
            return 0;
        }else{//Estado recursivo
            return n+sumaNaturales(n-1);//Acercamiento al estado base
        }
    }
    
    /**
     * EJERCICIO_2
     * Escribe un método recursivo que calcule el factorial de un número [n(n-1)!]
     * 
     * n=4
     * f(n)
     * De ida
     * f(4)=4*f(3)
     * f(3)=3*f(2)
     * f(2)=2*f(1)
     * f(1)=1
     * __________
     * 
     * De regreso
     * f(1)=1
     * f(2)=2*1=2
     * f(3)=3*2=6
     * f(4)=4*6=24
     * 
     * res=f(4)=24
     */
    
    public static int factorial(int n){
        if(n==0 || n==1){//Estado Base
            //como hay 2, significa que teenmos 2 formas de llegar al estado base
            return 1;
        }else{//Estado Recursivo
            return n*factorial(n-1);//Acercameinto al estado base
        }
    }
    
    
    /**
     * EJERCICIO_3
     * Escribe un metodo que sume todos los elementos de un arreglo dado el arreglo y el numero de elementos 
     *Existen casos en los que no te dan el valor del elemento
     * i[(4-1)=3]+i[(3-1)=2]+...
     * array={8,5,7,2}, n=4
     * a[(4-1)]+a...+a[(1-1)]
     * sA(n)
     * sA(4)= 2+sA(3)
     * sA(3)= 7+sA(2)
     * sA(2)= 5+sA(1)
     * sA(1)= 8+sA(0)
     * sA(0)= 0
     * _________________
     * 
     * sA(0)=0
     * sA(1)= 8+0=8
     * sA(2)= 5+8=13
     * sA(3)= 7+13=20
     * sA(4)= 2+20=22
     * res = sA(4)= 22
     */
    
    public static int sumaArregloDe(int [] array, int n){
       //en una suma siempre que llegas al estado base, regresas cero.
        if(n==0){ //estado recursivo
            return 0;
        }else{
            return array[n-1]+sumaArregloDe(array,n-1); //AEB
            //en recursividad no usar i++ o i--, suplir por n-1 o n+1
        }
    }
    
      /**
     * array={8,5,7,2}, n=4
     * _________________
     * 
     * sA(0)=8+sA(1)
     * sA(1)= 5+sA(2)
     * sA(2)= 7+sA(3)
     * sA(3)= 2+sA(4)
     * sA(4)= 0
     * ________________
     * sA(4)= 0
     * sA(3)= 2+0=2
     * sA(2)= 7+2=9
     * sA(1)= 5+9=14
     * sA(0)= 8+14=22
     * 
     * res=sA(0)=22
     */
    
    
    // i=0
    public static int sumaArregloIz(int [] array, int i){
        if(i==array.length-1){
            return 0;
        }else{
            return array[i]+sumaArregloIz(array,i+1);   
        }
    }
    
    
    
    
    /**
     * EJERCICIO_4 
     *Escribe un método recursivo que invierta los dígitos de un número
     * nmod10=residuo
     * 5738mod10=8
     * 5738/10=573
     * 573mod10=3
     * 573/10= 57
     * 57mod10=7
     * 57/10=5
     * 8*mil+3*100+7*10+5*1=8375
     * iN(n)
     * iN(5738)=8*10^3+iN(573)
     * 
     */
    
    public static int invertN(int n){
        if(n<10) {//EB
            return n;
        }else{
            return n%10*(int)Math.pow(10, (int)Math.log10(n))+invertN(n/10); //AEB
        //es super importante no olvidar la aproximacion al estado base
    }
}

    
    /**
     *EJERCICIO_5
     * Escribe un método recursivo que pase de decimal a binario 
     * 
     * nmod2
     * n=27
     * 27mod2=1
     * 27/2=13
     * 13mod2=1
     * 13/2=6
     * 6mod2=0
     * 6/2=3
     * 3mod2=1
     * 3/2=1
     * b(n);
     * b(27)=1+10*b(13)
     * b(13)=1+10*b(6)
     * b(6)=0+10*b(3)
     * b(3)=1+10*b(1)
     * b(1)=1+10*b(0)
     * b(0)=0
     * ___________________________________
     * b(0)=0
     * b(1)=1+0=1
     * b(3)=1+10=11
     * b(27)=1+110=1110
     * b(13)=1+1100=11100
     * b(6)=0+11010=11
    
     */
    
  public static int binario(int d){
       if(d==0){ //estado base
          return 0;
          
       }else{ //estado recursivo
           return d%2+10*binario(d/2);
           
       }
  }

   
    
    
    public static void main(String[] args) {
        int [] array={8,5,7,2};
        
        System.out.println("EJERCICIO_1");
        System.out.println(sumaNaturales(4));
        
        System.out.println("EJERCICIO_2");
        System.out.println(factorial(4));
        
        System.out.println("EJERCICIO_3");
        System.out.println(sumaArregloIz(array, array.length));

        System.out.println("Función importante");
        System.out.println((int) Math.log10(10000));
        
        System.out.println("EJERCICIO_4");
        System.out.println(invertN(5738));
//
       System.out.println("EJERCICIO_5");
        System.out.println(binario(27));


        
    }
    
    
    
    
}

