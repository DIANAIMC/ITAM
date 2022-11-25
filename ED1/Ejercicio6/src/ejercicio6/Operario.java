/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author dianam
 */
public class Operario extends Empleado{
    private int horasExtra;
    
    public Operario(){
    }
    
    Operario(String ne, double sb, int he){
        super(ne,sb);
        horasExtra=he;
    }
    
    public String toString(){
         StringBuilder sb=new StringBuilder("");
         sb.append(super.toString()+"Sueldo Base: "+sueldoBase);
         sb.append(super.toString()+"Horas Extra: "+horasExtra);
         return sb.toString();
    }
    
    public double calculaSalario(double prestac, double deduc, double precioHE){
        double res;
        res=sueldoBase+prestac+(horasExtra*precioHE)-deduc;
        return res;

    }
    
}
