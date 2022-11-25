package ejecutables;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import librerias.Vivero;
public class pruebaVivero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vivero v;
		v=new Vivero("margarita");
		int na;
		boolean res;
		ArrayList<String>listaRes;
		Scanner archivo;
		try {
			archivo=new Scanner(new File("numeros.txt"));
			na=archivo.nextInt();
			for(int i=0;i<na;i++) {
				res=v.altaPlanta(archivo.next(), archivo.next(), archivo.nextInt(), archivo.nextInt());
				if(res)
					System.out.println("planta dada de alta");
		}
		}catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.exit(-1);
		}
		res=v.verificaNombreColor("Pensamiento", "azul");
		if(res)
			System.out.println("si hay plantas de pensamiento azul");
		else
			System.out.println("no hay plantas de pensamiento azul");
		listaRes=v.epocaFloracion(1);
		System.out.println(listaRes.toString());
		
		
	}

}
