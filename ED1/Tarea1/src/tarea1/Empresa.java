/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author Diana Muñoz, Yuliana Padilla, Camila Fernández
 */

public class Empresa {
    
    private String nombre;
    private CamionVolteo cam1[];
    private CamionPasajero cam2[];
    private final int MAX=10;
    private static int cont1;
    private static int cont2;
    
    public Empresa (String n){
        
        nombre=n;
        cam1=new CamionVolteo [MAX];
        cam2=new CamionPasajero [MAX];
        cont1=0;
        cont2=0;
    }
    //a) b) imprimir todos los camiones de un tipo (volteo 'v' o pasajeros 'p')
    public String imprimeCamVol(){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<cont1;i++){
            sb.append(" Datos del camión de volteo: "+ (i+1)+cam1[i].toString());
        }
         return sb.toString();   
    }
    
    public String imprimeCamPas(){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<cont2;i++){
            sb.append(" Datos del camión de pasajeros: "+ (i+1)+cam2[i].toString());
        }
         return sb.toString();   
    }
    

    
    public boolean altaCpasajeros(String m, String nm, String p, int cp){
        boolean res=false;
        CamionPasajero c;
        int flag=cont2;
        if(cont2<=MAX){
            int pos=cont2;
            c=new CamionPasajero(m, nm, p, cp);
            cam2[pos]=c;
            cont2++;
        }
        if(flag<cont2)
            res=true;
        return res;
    }
    
    public boolean altaCVoleto(String m, String nm, String p, double ct){
        boolean res=false;
        CamionVolteo c;
        int flag=cont1;
        if(cont1<=MAX){
            int pos=cont1;
            c=new CamionVolteo(m, nm, p, ct);
            cam1[pos]=c;
            cont1++;
        }
        if(flag<cont1)
            res=true;
        return res;
    }
    
     //actualizar capacidad de transporte
    public boolean actualizaTon(String placa, double nuevo){
        boolean res=false;
        int i=0;
        while(cam1[i].getPlacas() != null && placa != cam1[i].getPlacas() )
            i++;
        cam1[i].setCapTon(nuevo);
        if(cam1[i].getCapTon() == nuevo);
            res=true;
        return res;
    }
   
    //cantidad de camiones de una marca específica
    public int CamionXMarca(String marca){
        int res=0;
        for(int i=0; i<cont1; i++)
            if(cam1[i].getMarca().equals(marca))
                res++;
        for(int i=0; i<cont2; i++)
            if(cam2[i].getMarca().equals(marca))
                res++;
        return res;
    }
    //regresa el total de toneladas que se pueden transportar
    public double totalTon(){
        double suma=0;
        for(int i=0; i<cont1; i++)
           suma+=cam1[i].getCapTon();
        return suma;
    }
    

    
}
