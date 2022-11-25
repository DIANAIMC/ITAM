/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author Diana Muñoz, Yuliana Padilla, Camila Fernández
 *
 */
public class CamionPasajero extends Camión{
    
    private int capPasajeros;
    
    public CamionPasajero(String m, String nm, String p,  int cp){
        
        super(m, nm, p);
        capPasajeros=cp;
    }
    
    public double getCapPer(){
        return capPasajeros;
    }
    
    public String toString(){
         StringBuilder sb=new StringBuilder("");
         sb.append(super.toString()+" Capacidad de Pasajeros: "+capPasajeros);
         return sb.toString();
         
     }
    
}
