package Librerias;

public class Pokemon {
	private String nombre;
	private char tipo;
	private String especie;
	private int valorAtaque;
	private int valorDefensa;
	private int numAtaque;
	private int clave;
	private static int folio;
	
	
	public Pokemon(String nombre, char tipo, String especie, int valorAtaque, int valorDefensa,int numAtaque, int clave) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.especie = especie;
		this.valorAtaque = valorAtaque;
		this.valorDefensa = valorDefensa;
		this.clave = clave;
		this.numAtaque=numAtaque;
	}
	public String getNombre() {
		return nombre;
	}
	public char getTipo() {
		return tipo;
	}
	public String getEspecie() {
		return especie;
	}
	public int getValorAtaque() {
		return valorAtaque;
	}
	public int getValorDefensa() {
		return valorDefensa;
	}
	public int getClave() {
		return clave;
	}
	public static int getFolio() {
		return folio;
	}
	public int getNumAtaque() {
		return numAtaque;
	}
	public void setNumAtaque(int numAtaque) {
		this.numAtaque = numAtaque;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	public int compareTo(Pokemon obj) {
		return nombre.compareTo(obj.nombre);
	}
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", tipo=" + tipo + ", especie=" + especie + ", valorAtaque=" + valorAtaque
				+ ", valorDefensa=" + valorDefensa + ", numAtaque=" + numAtaque + ", clave=" + clave + "]";
	}
	
	

}
