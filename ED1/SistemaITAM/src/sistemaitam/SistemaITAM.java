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
public class SistemaITAM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Empleado[]empleados=new Empleado[100];
        Alumno[]alumnos=new Alumno[100];
        empleados[0]=new Empleado("Hann Solo", 35, 0, false, 1.0);
        empleados[1]=new Empleado("Camilo", 17, 4,true, 1000000);
        empleados[2]=new Empleado("snowball", 18, 1880, true, 1000001);
        try{
            alumnos[0]=new Alumno("Chandrika Bandaranaike Kumurutanga",301,19,10.0);
        }
        catch(PromedidadorInvalidoException e){
            
        }
        
        alumnos[1]=new Alumno("H",403,20,9.0);
        
        //para imprimir los nombre de todas las personas relacionadas con el iTAM:
        
        for(int i=0;i<empleados.length;i++)
            System.out.println(empleados[i].getNombre());
        for(int i=0;i<alumnos.length;i++)
            System.out.println(alumnos[i].getNombre());
        //para imprimir los salarios de los trabajadors de tiempo completo;
        for(int i=0;i<alumnos.length;i++){
            if(empleados[i].getTiempoCompleto())
                System.out.println(empleados[i].getSalario());
        }
        //VERSION CON POLIMORFISMO
        Persona [] personas=new Persona [100];
        personas[0]=new Empleado("Hann Solo", 35, 0, false, 1.0);
        personas[1]=new Empleado("Camilo", 17, 4,true, 1000000);
        personas[2]=new Empleado("snowball", 18, 1880, true, 1000001);
        personas[3]=new Alumno("Chandrika Bandaranaike Kumurutanga",301,19,10.0);
        personas[4]=new Alumno("H",403,20,9.0);
        //Para imprimir los nombres de todas las personas relacionadas con el ITAM
        for(int i=0;i<personas.length;i++)
            System.out.println(personas[i].getNombre());
        // Para imprimir los salarios de los empleados de tiempo completo
        for(int i=0;i<personas.length;i++){
            if(personas[i] instanceof Empleado)
                if(((Empleado)personas[i]).getTiempoCompleto());
                    System.out.println(((Empleado)personas[i]).getSalario());
      
        }
    
    }
}    