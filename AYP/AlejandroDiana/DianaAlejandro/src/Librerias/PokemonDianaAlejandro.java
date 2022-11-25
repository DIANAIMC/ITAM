package Librerias;

public class PokemonDianaAlejandro {
	private String nombre;
	private char tipo;
	private String especie;
	private int valorAtaque;
	private int valorDefensa;
	private int numAtaques;
	private int clave;
	private int folio;
	
	public PokemonDianaAlejandro(String nombre, char tipo, String especie, int valorAtaque, int valorDefensa) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.especie=especie;
		this.valorAtaque=valorAtaque;
		this.valorDefensa=valorDefensa;
	}
	public String getNombre() {
		return nombre;
	}
	public char getTipo() {
		return tipo;
	}
	public int getAtaque() {
		return valorAtaque;
	}
	public int getDefensa() {
		return valorDefensa;
	}
	public int getClave() {
		return clave;
	}
	public void setNumAtaques(int n) {
		numAtaques=n;
	}
	public int compareTo(PokemonDianaAlejandro p) {
		int res;
		if(clave==p.clave)
			res=0;
		else
			if(clave>p.clave)
				res=1;
			else
				res=-1;
		return res;
	}
	public boolean equals(PokemonDianaAlejandro p) {
		boolean res;
		if(p.clave==clave)
			res=true;
		else
			res=false;
		return res;
	}
	public String toString() {
		StringBuilder cad= new StringBuilder();
		cad.append("el nombre es: " + nombre ); 
		cad.append("el tipo es: " + tipo ); 
		cad.append("la especie es: " + especie ); 
		cad.append("el valor del ataque es: " + valorAtaque ); 
		cad.append("el valor del defensa es: " + valorDefensa ); 
		cad.append("el numero de ataques es: " + numAtaques ); 
		cad.append("la clave es: " + clave ); 
		cad.append("el folio es: " + folio ); 
		return cad.toString();
	}
}
