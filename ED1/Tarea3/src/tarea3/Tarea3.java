/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

/**
 *
 * @author dianam
 */
public class Tarea3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         /////////////////////////////////
        String mensajeDePrueba2 = "CESAR";
        //////////////////////////////////
        
        
        int [] corrimientosLlave = {17, 6, 25, -13, -8, 4};
        ArrayQueue<Integer> llave;
        String mensajeDePrueba = "ITAM", temp;
        temp = "Me gustan las Estructuras de datos";
       
        /////////////////////////////
        System.out.println("PRUEBA 1");
        //////////////////////////////
        
        llave = inicializaLlave(corrimientosLlave);
        temp=cifrar(mensajeDePrueba,llave);
        System.out.println("La frase " + mensajeDePrueba + " cifrada es: " + temp);
        /*
        Hay que asegurarse de que la llave se regrese a su estaco inicial
        antes de empezar el proceso de descifrado:
        */
        
        llave = inicializaLlave(corrimientosLlave);
        mensajeDePrueba = temp;
        temp=descifrar(mensajeDePrueba, llave);
        System.out.println("La frase " + mensajeDePrueba+ " descifrada es: " + temp);
        
        
        ////////////////////////////
        System.out.println("PRUEBA 2");
        ////////////////////////////
        
        llave = inicializaLlave(corrimientosLlave);
        temp=cifrar(mensajeDePrueba2, llave);
        System.out.println("La frase " +  mensajeDePrueba2 + " cifrada es: " + temp);
         /*
        Hay que asegurarse de que la llave se regrese a su estado inicial
        antes de empezar el proceso de descifrado:
        */
        llave = inicializaLlave(corrimientosLlave);
        mensajeDePrueba2=temp;
        temp=descifrar(mensajeDePrueba2, llave);
        System.out.println("La frase " +  mensajeDePrueba2 + " descifrada es: " + temp);
        
        
        /*
        Pruebas adicionales para comprobar el funcionamiento correcto de la 
        "circularidad" de la zona de la tabla ASCII entre 'A' y 'Z' aun cuando
        los corrimientos rebasan el tamaño de dicha zona por mucho:
        */
        
        ///////////////////
        System.out.println("PRUEBA 3");
        ///////////////////
        
        int [] corrimientosLlave2 = {54};
        llave = inicializaLlave(corrimientosLlave2);
        String mensajeDePrueba3 = "B";
        temp = cifrar(mensajeDePrueba3, llave);
        System.out.println("La frase " + mensajeDePrueba3+" cifrada es: "+temp);
        /*
        Hay que asegurarse de que la llave se regrese a su estado inicial
        antes de empezar el proceso de descifrado:
        */
        llave = inicializaLlave(corrimientosLlave2);
        mensajeDePrueba3 = temp;
        temp = descifrar(mensajeDePrueba3, llave);
        System.out.println("La frase " +  mensajeDePrueba3 + " descifrada es: " + temp);
        
        //////////////////
        System.out.println("PRUEBA 4");
        ///////////////////
        
        corrimientosLlave[0] = 28;
        llave = inicializaLlave(corrimientosLlave2);
        String mensajeDePrueba4 = "B";
        temp=cifrar(mensajeDePrueba4, llave);
        System.out.println("La frase " + mensajeDePrueba4+ " cifrada es: " + temp);
        /*
        Hay que asegurarse de que la llave se regrese a su estado inicial
        antes de empezar el proceso de descifrado:
        */
        llave = inicializaLlave(corrimientosLlave2);
        mensajeDePrueba4=temp;
        temp=descifrar(mensajeDePrueba4, llave);
        System.out.println("La frase " +  mensajeDePrueba4 + " descifrada es: " + temp); 
    }
    
    private static ArrayQueue<Integer> inicializaLlave(int [] corrimientos){
        ArrayQueue<Integer> llave = new ArrayQueue<Integer>();
        int i;
        
        for(i=0; i<corrimientos.length; i++)
            llave.add(new Integer(corrimientos[i]));
        
        return llave;
    }
    
   private static String cifrar(String frase, ArrayQueue<Integer> llave){
       int i, sigCorrimiento, asciiOriginal, nuevoAscii;
       StringBuilder resultado = new StringBuilder("");
       
       for( i=0 ; i<frase.length() ; i++ ) {
           if(frase.charAt(i) == ' ')
               resultado = resultado.append(frase.charAt(i));
           else {
               sigCorrimiento = llave.remove().intValue();
               asciiOriginal = (int)frase.charAt(i);
               /*
               Restarle el ASCII de 'A' al ASCII de 'Z' y sumarle 1 nos da
               la cantidad de letras que hay en el alfabeto inglés (26);
               */
               nuevoAscii =  asciiOriginal + sigCorrimiento%((int)'Z' - (int)'A' +1 );
               /*
               Aquí el nuevo ASCII no puede estar más a la izquierda de la 'A'
               ni más a la derecha de la 'Z' por más dde 26 posiciones debido al
               resultado del módilo en la oporación anterior al calcular us valor:
               */
               if(nuevoAscii<(int)'A')
                   nuevoAscii=(int)'Z'+1-((int)'A'-nuevoAscii);
               else if(nuevoAscii>(int)'Z')
                   nuevoAscii = (int)'A'-1+(nuevoAscii-(int)'Z');
               
               resultado = resultado.append((char)nuevoAscii);
               llave.add(new Integer(sigCorrimiento));
           }
       }
       
       return resultado.toString();
   }
   
   private static String descifrar(String frase, ArrayQueue<Integer> llave){
       int i, sigCorrimiento, asciiOriginal, nuevoAscii;
       StringBuilder resultado = new StringBuilder("");
       
       for( i=0 ; i<frase.length() ; i++ ) {
           if(frase.charAt(i) == ' ')
               resultado = resultado.append(frase.charAt(i));
           else {
               sigCorrimiento = llave.remove().intValue();
               asciiOriginal = (int)frase.charAt(i);
               /*
               Restarle el ASCII de 'A' al ASCII de 'Z' y sumarle 1 nos da
               la cantidad de letras que hay en el alfabeto inglés (26);
               */
               nuevoAscii =  asciiOriginal - sigCorrimiento%((int)'Z' - (int)'A' +1 );
               /*
               Aquí el nuevo ASCII no puede estar más a la izquierda de la 'A'
               ni más a la derecha de la 'Z' por más dde 26 posiciones debido al
               resultado del módilo en la oporación anterior al calcular us valor:
               */
               if(nuevoAscii<(int)'A')
                   nuevoAscii=(int)'Z'+1-((int)'A'-nuevoAscii);
               else if(nuevoAscii>(int)'Z')
                   nuevoAscii = (int)'A'-1+(nuevoAscii-(int)'Z');
               
               resultado = resultado.append((char)nuevoAscii);
               llave.add(new Integer(sigCorrimiento));
           }
       }
       
       return resultado.toString();
   }
}
