/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaitam;

/**
 *
 * @author dianam
 */
public class Empleado extends Persona {
    private boolean tiempocompleto;
    private double salario;
    
    public Empleado(String n, int edad, int c, boolean t, double s){
        super(n,edad,c); //invoca al constructor de la superclase
        tiempocompleto=t;
        salario=s;
        
    }
    
    public boolean getTiempoCompleto(){
        return tiempocompleto;
    }
    
    public double getSalario(){
        return salario;
    }
    
     public String toString(){
         StringBuilder sb=new StringBuilder("");
         sb.append(super.toString()+"TC "+tiempocompleto+"S"+salario);
         return sb.toString();
         
     }
 }