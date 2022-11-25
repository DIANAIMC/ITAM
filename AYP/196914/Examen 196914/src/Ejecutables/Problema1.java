package Ejecutables;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problema1 {

	public static int eliminaInsertaRepetidos(ArrayList<String>l, String []a){
		int res=0;
		String aux="";
		for(int i=0; i<l.size();i++) {
			for(int j=0; j<l.size();j++) {
				if(l.get(i).equals(l.get(j))) {
					aux=l.get(j);
					l.remove(j);
					a[i]=aux;
				}
			}
		}
		res=a.length;	
		return res;
	}
	
	public static void imprimeArreglo(String []a, int na) {
		for(int i=0;i<na;i++)
			System.out.println("El dato "+i+" es: "+a[i]);
	}
	
	public static Integer leerArchivo(ArrayList<String>l) {
		int j=0;
		Scanner archivo;
		try {
			archivo=new Scanner(new File("datosB.txt"));
			j=archivo.nextInt();
			for(int i=0;i<j;i++)
				l.add(archivo.next());
		}catch(FileNotFoundException fnfe) {
			System.exit(-1);
		}
		return j;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>lres=new ArrayList<String>();
		int na;
		int res;
		String[]arre=new String[50];
		na=leerArchivo(lres);
		res=eliminaInsertaRepetidos(lres,arre);
		imprimeArreglo(arre, res);
		System.out.println("el número de elemntos total del arreglo es: "+res);
	}

}
