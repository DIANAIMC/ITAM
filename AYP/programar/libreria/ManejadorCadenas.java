package libreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManejadorCadenas {

	public static boolean igual(String c1, String c2) {
		boolean res=false;
		if(c1.equals(c2))
			res=true;
		return res;
	}
	
	public static boolean igual2(String c1, String c2) {
		return c1.equals(c2);
	}
	
	public static String igual3(String c1, String c2) {
		String res="las cadenas no son iguales";
		if(c1.equals(c2))
			res="las cadenas son iguales";
		return res;
	}
	
	//anita lava la tina
	public static boolean palindroma(String c1) {
		boolean res=false;
		int i=0;
		int n=c1.length();
		while(i<n/2 && c1.charAt(i)==c1.charAt(n-1-i))
			i++;
		if(i==n/2)
			res=true;
		return res;
	}
	
	//TAREA: inventar 5 funciones estáticas con Strings
	public static Integer leerArchivo(String[] a, String nombre) {
		int j=0;
		Scanner archivo;
		try {
			archivo=new Scanner(new File(nombre));
			j=archivo.nextInt();
			for(int i=0;i<j;i++)
				a[i]=archivo.next();
		}catch(FileNotFoundException fnfe) {
			System.exit(-1);
		}
		return j;
	}
	
	//existe una palabra
	public static boolean existePalabra(String c, String palabra ) {
		boolean res=false;
		if(c.indexOf(palabra)>=0)
			res=true;
		return res;
	}
	//compara cual es mas larga
	public static String masLarga(String c, String c1) {
		int lon1, lon2;
		String res;
		lon1=c.length();
		lon2=c1.length();
		if(lon1<lon2)
			res=c1;
		else
			res=c;
		return res;
	}
	//elimina todas las palabras de una frase
	public static String eliminaLetraPalabra(String c, String eliminar) {
		String res;
		res=c.replace(eliminar, "");
		return res;
	}
	//llenar un formulario
	public static String llenaForma(String c, String cambiar, String palabra) {
		String res;
		res=c.replace(cambiar, palabra);
		return res;
	}
	//elimina todos los espacios
	public static String eliminaEspacios(String c) {
		String res=" ";
		res=c.replace(" ", "");
		return res;
	}
}
