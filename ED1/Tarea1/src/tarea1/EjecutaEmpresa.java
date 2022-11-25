/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author dianam
 */
public class EjecutaEmpresa {
    
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa e= new Empresa ("Bichota");
        
        //Alta de camiones
        boolean res;
        String res1;
        res=e.altaCVoleto("Mercedes Benz", "000123", "abc", 1.5);
        if(res)
            System.out.println("Alta Exitosa");
        else
            System.out.println("Error");
        res=e.altaCVoleto("Chevrolet", "000124", "def", 3.0);
        if(res)
            System.out.println("Alta Exitosa");
        else
            System.out.println("Error");
        res=e.altaCpasajeros("Mercedes Benz", "000125", "ghi", 20);
        if(res)
            System.out.println("Alta Exitosa");
        else
            System.out.println("Error");
        res=e.altaCpasajeros("Mercedes Benz", "000126", "jkl", 35);
        if(res)
            System.out.println("Alta Exitosa");
        else
            System.out.println("Error");
        
        //Imprime Camiones de Volteo
        System.out.println(e.imprimeCamVol());
        //Imprime Camiones de Pasajeros
        System.out.println(e.imprimeCamPas());
        //Cambiar la capacidad de un camión de volteo por placa
        res=e.actualizaTon("def", 4.0);
        if(res)
            System.out.println("Cambio Exitoso");
        else
            System.out.println("Error");
        //Total de toneladas que pueden mover los camniones de volteo
        System.out.println(e.totalTon());
        //Total de camiones por marca
        System.out.println(e.CamionXMarca("Mercedes Benz"));
 
    }
  
}
