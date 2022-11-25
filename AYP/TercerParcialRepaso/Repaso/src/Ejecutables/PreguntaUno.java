package Ejecutables;
import java.util.ArrayList;

public class PreguntaUno {
	
	public static int modificaArregloYLista(ArrayList<String> lista, String []a, int n2) {
		int n = 0;
		int res=n;
		int i=0;
		while(i<res) {
			if(lista.contains(a[i])) {
				for(int j=i;j<res-1;j++)
					a[j]=a[j+1];
				res--;
		}
		else {
			lista.add(a[i]);
			i++;
			}
		}
		return res;
	}
	
	public static void imprimeArreglo(String[]a, int n) {
		for(int i=0;i<n;i++)
			System.out.println(" "+ a[i]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=11;
		String a[]= {"este","es","un","ejemplo","de","arreglo","cuyo","contenido","ES","tipo","String"};
		ArrayList<String>l= new ArrayList<String>();
		l.add("manzanas");
		l.add("este");
		l.add("ejemplo");
		l.add("cuyo");
		l.add("flores");
		l.add("contenido");
		l.add("de");
		l.add("ES");
		l.add("peras");
		
		n=modificaArregloYLista(l,a,n);
		
		System.out.println("el arreglo modificado es: ");
		imprimeArreglo(a,n);
		
		System.out.println("la lista modificada es: ");
		System.out.println(l.toString());
	}
}
