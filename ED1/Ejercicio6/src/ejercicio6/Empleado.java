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
public class Empleado {
    
    private static int serie=100;
    private int claveEmpleado;
    private String nombreEmpleado; 
    protected double sueldoBase;
    
    protected Empleado(){
    }
    
    protected Empleado ( String ne, double sb){
        nombreEmpleado=ne;
        sueldoBase=sb;
    }
    
    public double getSueldoBase(){
        return sueldoBase;
    } 
    
    public String getNombreEmpleado(){
        return nombreEmpleado;
    }
    
    public void setSueldoBase(double s){
        sueldoBase=s;
    }
    
    public String toString(){
         StringBuilder sb=new StringBuilder("");
         sb.append(super.toString()+"Serie: "+serie);
         sb.append(super.toString()+"Clave Empleado: "+claveEmpleado);
         sb.append(super.toString()+"Nombre Empleado: "+nombreEmpleado);
         sb.append(super.toString()+"Sueldo Base: "+sueldoBase);
         return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.claveEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.claveEmpleado != other.claveEmpleado) {
            return false;
        }
        return true;
    }
    
    public double calculaSalario(double prestac, double deduc){
        Empleado aux;
        double res;
        res=sueldoBase+prestac-deduc;
        return res;
    }
        
}
