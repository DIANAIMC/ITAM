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
public class Ejecuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BaseDatosEstacionamiento b = new BaseDatosEstacionamiento("Estacionamiento ITAM");
        CochesPermitidos c1 = new CochesPermitidos("Yuliana Padilla", 188037, "Y12JAJ");
        CochesPermitidos c2 = new CochesPermitidos("Camila Fernádez", 194655, "J34HJL");
        CochesPermitidos c3 = new CochesPermitidos("Diana Muñoz", 196914, "H78DYU");
        CochesPermitidos c4 = new CochesPermitidos("Chris Hemsworth", 128396, "N89RWE");
        CochesPermitidos c5 = new CochesPermitidos("Henry Cavill", 482822, "N70VBN");
        CochesPermitidos c6 = new CochesPermitidos("Ian Somerhalder", 945977, "K12XCV");
        CochesPermitidos c7 = new CochesPermitidos("Ana Lidia", 182343, "P31XYZ");
        CochesPermitidos c8 = new CochesPermitidos("Fernado Esponda", 146372, "R45ADC");
        CochesPermitidos c9 = new CochesPermitidos("Bruno Velazquez", 736522, "C98FRT");
        CochesPermitidos c10 = new CochesPermitidos("Wanda", 908721, "L35HJK");
        
        String res;
        res=b.altaCoches(c1);
        System.out.println(res);
        res=b.altaCoches(c2);
        System.out.println(res);
        res=b.altaCoches(c3);
        System.out.println(res);
        res=b.altaCoches(c4);
        System.out.println(res);
        res=b.altaCoches(c5);
        System.out.println(res);
        res=b.altaCoches(c6);
        System.out.println(res);
        res=b.altaCoches(c7);
        System.out.println(res);
        res=b.altaCoches(c8);
        System.out.println(res);
        res=b.altaCoches(c9);
        System.out.println(res);
        res=b.altaCoches(c10);
        System.out.println(res);
        
        System.out.println("//prueba en la que las placas estén mal");
        CochesPermitidos c11 = new CochesPermitidos("Mauricio", 834384, "R456HJ");
        res=b.altaCoches(c11);
        System.out.println(res);
        
        System.out.println("prueba en la que el cu esté mal");
        CochesPermitidos c12 = new CochesPermitidos("Mauricio", -834384, "R456HJ");
        res=b.altaCoches(c12);
        System.out.println(res);
        
        System.out.println("Vamos a agregar coches a la fila ");
        System.out.println(b.insertaCoche(c1));
        System.out.println(b.insertaCoche(c2));
        System.out.println(b.insertaCoche(c3));
        System.out.println(b.insertaCoche(c4));
        System.out.println(b.insertaCoche(c5));
        
        System.out.println("vamos a sacar un coche de en medio");
        System.out.println(b.sacaCoche(c3));
        System.out.println("vamos a intentar sacar un coche que no se encuentra en la fila");
        System.out.println(b.sacaCoche(c6));
        
        
    }
    
}
