package librerias;

import java.util.ArrayList;

public class Vivero {
	private String nombre;
	private Planta[] arreglo;
	private int totalP;
	private final int MAX=100;
	
	
	public Vivero(String nombre) {
		this.nombre = nombre;
		arreglo=new Planta[MAX];
		totalP=0;
	}
	
	public boolean altaPlanta(String nombre, String color, int epoca, int total) {
		boolean res=false;
		Planta p;
		if(totalP<MAX) {
			p=new Planta(nombre, color, epoca, total);
			arreglo[totalP]=p;
			totalP++;
			res=true;
		}
		return res;
	}
	
	public boolean verificaNombreColor(String nombre, String color) {
		boolean res=false;
		int i=0;
		while(i<totalP  && arreglo[i].getNombre().compareTo(nombre)!=0
				&& arreglo[i].getColor().compareTo(color)!=0)
			i++;
		if(i!=totalP && arreglo[i].getNombre().compareTo(nombre)==0
				&& arreglo[i].getColor().equals(color))
			res=true;
		return res;
	}
	
	public ArrayList<String> epocaFloracion(int epoca){
		ArrayList<String>lista=new ArrayList<String>();
		for(int i=0; i<totalP;i++)
			if(arreglo[i].getEpoca()==epoca)
				lista.add(arreglo[i].getNombre());
		return lista;
	}
	
}
