package Librerias;

public class Medicamento {
	private String nombre;
	private double costo;
	private int cantidad;
	private boolean receta;
	private int clave;
	private static int claveU=100;
	
	public Medicamento() {
		clave=claveU;
		claveU+=3;
	}
	
	public Medicamento(String nombre, double costo, int cantidad, boolean receta) {
		this.nombre = nombre;
		this.costo = costo;
		this.cantidad = cantidad;
		this.receta = receta;
		clave=claveU;
		claveU+=3;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public boolean isReceta() {
		return receta;
	}
	public void setReceta(boolean receta) {
		this.receta = receta;
	}
	public String getNombre() {
		return nombre;
	}

	
	
	public int getClave() {
		return clave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clave;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (clave != other.clave)
			return false;
		return true;
	}
	
	public int compareTo(Medicamento m) {
		return claveU-m.claveU;
	}

	public String toString(){
		StringBuilder cad=new StringBuilder();
		cad.append("\nnombre: "+nombre);
		cad.append("\ncosto: "+costo);
		cad.append("\ncantidad: "+cantidad);
		if(receta)
			cad.append("\nSÌ necesita receta");
		else
			cad.append("\nNo necesita receta");
		return cad.toString();
	}
}
