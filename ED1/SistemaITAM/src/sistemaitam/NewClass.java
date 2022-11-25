/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaitam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 *
 * @author dianam
 */


public class NewClass {
    
 
    
    public double deportista(){
       double [] km;
       Scanner lee;
       System.out.println("Cuantos días corriste?");
       lee=new Scanner(System.in);
       int n=lee.nextInt();
       km = new double [n];
       for(int i=0;i<n;i++){
           System.out.println("Cuantos km corriste en el día "+(i+1)+" ?");
           lee=new Scanner(System.in);
           km[i]= lee.nextDouble();         
       }
       double suma=0;
       for(int i=0;i<n;i++)
           suma+=km[i];
       double prom;
       prom=suma/n;
       if(prom >= 5.5)
            System.out.println("Felicidades campeona en promedio corriste mas de 5.5 km");
       return prom;
              
        
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
     
       NewClass n=new NewClass();
       
       n.deportista();
    }
  
}
