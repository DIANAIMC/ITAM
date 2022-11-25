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
public class Alumno extends Persona {
    
    private double promedio;
    
    public Alumno(String n, int edad, int c, double p){
        super(n,edad,c);
        int i=0;
        promedio=p;
    }
    
    
    public Alumno (int edad){
        this("NombreInventado",edad,-4,78.5);
       // super(n,edad,c);
    }
}
