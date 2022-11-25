package libreria;

public class CuentaBancaria {
	//atributos
	private static int numCuenta=1;
	private int cuenta;
	private String nombre;
	private double saldo;
	//Constructores
	public CuentaBancaria() {	
	}
	public CuentaBancaria(String nombre,double saldo) {
		this.nombre=nombre;
		this.saldo=saldo;
		cuenta=numCuenta;
		numCuenta++;
	}
	//gets
	public int getCuenta() {
		return cuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public String getNombre() {
		return nombre;
	}
	//funciones y métodos propias de la clase
	public boolean deposito(double monto) {
		boolean res=false;
		if(monto>0) {
			saldo=saldo+monto;
		}
			res=true;
		return res;
	}
	public boolean retiro(double monto){
		boolean res=false;
		if(saldo>=monto) 	
			saldo=saldo-monto;
			res=true;
		return res;	
	}
	//funciones obligatorias
	public int compareTo(CuentaBancaria c) {
		int res;
		if(cuenta==c.cuenta)
			res=0;
		else
			if(cuenta>c.cuenta)
				res=1;
			else
				res=-1;
		return res;
	}
	public boolean equals(CuentaBancaria c) {
		boolean res;
		if(c.cuenta==cuenta)
			res=true;
		else
			res=false;
		return res;
	}
	public String toString() {
		String res;
		res="Cuenta: "+cuenta+" Nombre "+nombre+" Saldo: "+ saldo;
		return res;
	}
}