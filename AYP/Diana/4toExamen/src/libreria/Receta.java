package libreria;

public class Receta {
	private int id;
	private String tipo; // vegetariano vegano carnivoro
	private int numIngredientes; 
	private double costoEstimado;
	private static int contador=0;
	
	
	public Receta(String tipo, int numIngredientes, double costoEstimado) {
		this.tipo = tipo;
		this.numIngredientes = numIngredientes;
		this.costoEstimado = costoEstimado;
		id=contador;
		contador++;
	}


	public int getNumIngredientes() {
		return numIngredientes;
	}


	public void setNumIngredientes(int numIngredientes) {
		this.numIngredientes = numIngredientes;
	}


	public double getCostoEstimado() {
		return costoEstimado;
	}


	public void setCostoEstimado(double costoEstimado) {
		this.costoEstimado = costoEstimado;
	}


	public String getTipo() {
		return tipo;
	}
	
	public double getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Receta other = (Receta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int compareTo(Receta r) {
		return id-r.id;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", tipo=" + tipo + ", numIngredientes=" + numIngredientes + ", costoEstimado="
				+ costoEstimado + "]";
	}
}
	
	
	
	
	
	
	
