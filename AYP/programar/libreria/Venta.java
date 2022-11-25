package libreria;

public class Venta {
	//atributos
	private double monto;
	private String nombre;
	//constructor
	public Venta() {
	}
	public Venta(double monto,String n) {
		this.monto=monto;
		nombre=n; 
	}
	//get y set
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto){
		this.monto=monto;
	}
	public String getNombre() {
		return nombre;
	}
	//métodos y funciones propias de la clase
	public double calculaComicion() {
		double res;
		if (monto<1000)
			res=monto*.03;
		else 
			res=monto*.05;
		return res;
	}
	
	//funciones obligatorias
	public boolean equals(Venta v) {
		return nombre.equals(v.nombre);
	}
	public int compareTo(Venta v) {
		return nombre.compareTo(v.nombre);
	}
	public String toString() {
		String res;
		res="nombre de la venta es" + nombre + "monto de la venta es" + monto;
		return res;
	}
}
