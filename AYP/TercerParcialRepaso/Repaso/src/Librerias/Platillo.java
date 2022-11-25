package Librerias;

public class Platillo {
	private String nombre;
	private double precio;
	private int numIngredientes;
	private boolean esVegetariano;
	private static int cont=200;
	private int claveU;
	
	public Platillo(String nombre, double precio, int numIngredientes,
			boolean esVegetariano) {
		this.nombre = nombre;
		this.precio = precio;
		this.numIngredientes = numIngredientes;
		this.esVegetariano = esVegetariano;
		this.claveU=cont;
		cont+=10;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumIngredientes() {
		return numIngredientes;
	}

	public boolean isEsVegetariano() {
		return esVegetariano;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}	

	public void setNumIngredientes(int numIngredientes) {
		this.numIngredientes = numIngredientes;
	}

	public void setEsVegetariano(boolean esVegetariano) {
		this.esVegetariano = esVegetariano;
	}
	public int compareTo(Platillo p) {
		return claveU=p.claveU;
	}
	
	public String toString(){
		StringBuilder cad=new StringBuilder();
		cad.append("\nPlatillo de         clave única: "+claveU);
		cad.append("\nPlatillo de         nombre: "+nombre);
		cad.append("\n                    precio: "+precio);
		cad.append("\n    n˙mero de ingredientes: "+numIngredientes);
		cad.append("\n            es vegetariano: "+esVegetariano);
		return cad.toString();
	}

	public int getClaveU() {
		// TODO Auto-generated method stub
		return 0;
	}
}

