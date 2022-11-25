package librerias;

public class Planta {
	private int clave;
	private int cont=100;
	private String nombre;
	private String color;
	private int epoca;
	private int total;
	
	
	public Planta(String nombre, String color, int epoca, int total) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.epoca = epoca;
		this.total = total;
		clave=cont;
		cont+=2;
	}

	public int getClave() {
		return clave;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getEpoca() {
		return epoca;
	}


	public void setEpoca(int epoca) {
		this.epoca = epoca;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
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
		Planta other = (Planta) obj;
		if (clave != other.clave)
			return false;
		return true;
	}
	
	public int compareTo(Planta p) {
		return clave=p.clave;
	}

	public String toString(){
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nnombre: "+nombre);
		cad.append("\ncolor: "+color);
		cad.append("\nepoca: "+epoca);
		cad.append("\ntotal: "+total);
		return cad.toString();
	}
	
	

}
