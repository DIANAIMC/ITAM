package ejecutables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problema1 {
	
	public static int leeArregloArchivo(int[]a) {
		int na=0;
		Scanner archivo;
		try {
			archivo=new Scanner(new File("numeros.txt"));
			na=archivo.nextInt();
			for(int i=0;i<na;i++)
				a[i]=archivo.nextInt();
		}catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.exit(-1);
		}
		return na;
	}
	
	public static ArrayList<Integer> primeraMitadMayor(int []a, int na){
		ArrayList<Integer> lista=new ArrayList<Integer>();	
		int i=0;
		while(i<na/2 && a[i]>a[na-1-i]) {
			lista.add(a[i]);
			i++;
		}
		if(i!=na/2)
			lista=null;
		return lista;
	}
	
	public static void imprimeArreglo(int[]a, int na) {
		for(int i=0; i<na;i++)
			System.out.println("el dato"+i+" es: "+a[i]);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> listaResp=new ArrayList<Integer>();
		int na;
		int []arreglo= new int [20];
		na=leeArregloArchivo(arreglo);
		imprimeArreglo(arreglo, na);
		if(listaResp!=null)
			System.out.println("los datos de la lista son: "+listaResp.toString());
		else
			System.out.println("no cumple");
	}

}
