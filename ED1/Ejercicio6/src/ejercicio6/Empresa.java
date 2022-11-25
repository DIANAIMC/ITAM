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
public class Empresa {
    
    private String nombre;
    private String direccion;
    private Empleado []datos;
    private int total;
    private static int MAX=100;
    
    public Empresa(String nm, String dc){
        nombre=nm;
        direccion=dc;
        total=0;
        datos= new Empleado[MAX]; 
    }
    
    public boolean altaEmpleado(String ne, double sb) {
        boolean res=false;
        Empleado e;
        if(total<MAX) {
                e=new Empleado(ne, sb);
                datos[total]=e;
                total++;
                res=true;
        }
        return res;
    }
    
    public StringBuilder GeneraReporteAdm(){
        Empleado aux;
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<total;i++){
            aux=datos[i];
            if(aux instanceof Administrativo){
                sb.append(aux.toString());   
            }    
        }
          return sb;   
    }
    
    public StringBuilder GeneraReporteOper(){
        Empleado aux;
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<total;i++){
            aux=datos[i];
            if(aux instanceof Operario){
                sb.append(aux.toString());   
            }    
        }
          return sb;   
    }
    
    public boolean Aumento(int cu, double por){
        boolean res=false;
        for(int i=0;i<total;i++){
            if(datos[i].hashCode() == cu){
                res=true;
                datos[i].setSueldoBase(datos[i].sueldoBase*por);
            }
        }
        return res;
    }
    
    public boolean CambioDep(int cu, String nuevo){
        boolean res=false;
        Empleado aux;
        for(int i=0;i<total;i++){
            aux=datos[i];
            if(aux instanceof Administrativo && aux.hashCode() == cu){
                res=true;
                datos[i].;
            }
        }
        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    }
    
}
