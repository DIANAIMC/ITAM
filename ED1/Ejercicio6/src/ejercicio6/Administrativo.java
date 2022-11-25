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
public class Administrativo extends Empleado {
    private String departamento;
    private String telefono;
    
    public Administrativo(){    
    }
    
    public Administrativo(String ne, double sb, String dp, String tel){
        super(ne,sb);
        departamento=dp;
        telefono=tel;
    }
    
    public void setDepartamento(String nuevo){
        departamento=nuevo;
    }
    
    public String toString(){
         StringBuilder sb=new StringBuilder("");
         sb.append(super.toString()+"Sueldo Base: "+sueldoBase);
         sb.append(super.toString()+"Departamento: "+departamento);
         sb.append(super.toString()+"Teléfono: "+telefono);
         return sb.toString();
    }
}
