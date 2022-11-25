/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * @author Diana Muñoz, Yuliana Padilla, Camila Fernández
 */
public class CochesPermitidos {
    
    private String nombre; //nombre del propietario
    private int clave; //clave única del dueño
    private String placas;
    
    public CochesPermitidos(String nombre, int cu, String placas ){
        
      
        String cu1=""+cu;
        if (cu1.length()==6 && cu>0 && placas.length() == 6 && Character.isUpperCase(placas.charAt(0)) && placas.charAt(0) != 'O' && placas.charAt(0) != 'I'
                && Character.isDigit(placas.charAt(1)) && Character.isDigit(placas.charAt(2))){
            int flag=3;
            while (flag<6 && Character.isUpperCase(placas.charAt(flag)) && placas.charAt(flag) != 'O' && placas.charAt(flag) != 'I')
                flag ++;
            if(flag==6){
                this.nombre=nombre;
                clave=cu;
                this.placas=placas; 
            }
        
        
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
    
}
