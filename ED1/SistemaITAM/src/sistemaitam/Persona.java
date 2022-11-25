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
public class Persona {
    private String nombre;
    private int edad;
    private int CU;
    
    
    //constructor publico para poder usarlo en más clases
    //en java constructor con el mismo nombre
    public Persona( String n, int edad, int c){
        nombre=n;
        this.edad=edad;
        CU=c;
        
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
        StringBuilder sb=new StringBuilder(" ");
        sb.append("Nombre: "+nombre+"Edad "+edad+"Clave unica"+CU);
        return sb.toString();
        
    }
    
}
