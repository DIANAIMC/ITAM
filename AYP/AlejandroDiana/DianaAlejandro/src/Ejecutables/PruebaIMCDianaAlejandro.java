package Ejecutables;

import java.util.ArrayList;

public class PruebaIMCDianaAlejandro {
	public static ArrayList<String> CalculaIMC(String [] nombre, double [] peso, double  [] altura, int numA){
		ArrayList<String> lista;
		lista= new ArrayList<String>();
		String llena;
		System.out.println("Las personas con sobrepeso son: "+"\n");
		for(int i=0; i<numA; i++)
			if((peso[i]/Math.pow(altura[i], 2))>25) {
				llena=(nombre[i]+ " su IMC es de: " +(peso[i]/Math.pow(altura[i], 2)) + "\n");
				lista.add(llena);
			}
		return lista;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numA=6;
		String nombre [] = {"Juan", "Sofia", "Ana", "Beatriz", "Carlos", "Isabel"};
		double peso [] = {120,70,55,60,75,62};
		double altura [] = {1.65, 1.70, 1.65, 1.58, 1.65, 1.50};
		
		System.out.println(CalculaIMC(nombre, peso, altura, numA));

	}
}
	
