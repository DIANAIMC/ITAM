package libreria;

public class Tarjeta {
	//atributos//
	private String tipo;
	private int categoria;
	private static int numCuenta=1;
	private int cuenta;
	private static int numTar=1;
	private int tarjeta;
	private int año;
	private int vence;
	private int pin;
	private int limite;
	private int saldo;
	
	
	public Tarjeta(int categoria, String tipo, int pin, int año ) {
		this.categoria=categoria;
		this.tipo=tipo;
		this.pin=pin;
		this.año=año;
		
		tarjeta=numTar;
		numTar++;
		cuenta=numCuenta;
		numCuenta+=100;
		vence=año+5;
		
		switch(categoria) {
		case 0:
			limite=20000;
			break;
		case 1:
			limite=30000;
			break;
		case 2:
			limite=50000;
			break;
		}	
	}
	//gets y sets
	public int getTarjeta() {
		return tarjeta;
	}
	public String getTipo() {
		return tipo;
	}
	public int getCategoria() {
		return categoria;
	}
	public int getcuenta() {
		return cuenta;
	}
	public int getAño() {
		return año;
	}
	public int getVence() {
		return vence;
	}
	public int getlimite() {
		return limite;
	}
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	public void setCategoria(int categoria) {
		this.categoria=categoria;
	}
	//funciones de la clase//
	public boolean activaTarjeta(int pin1) {
		boolean res=false;
		if(pin==pin1)
			res=true;
		return res;
	}
	
	public double calculacredito() {
		double credito;
		credito=saldo+limite;
		return credito;
		}
	public double calculaComision() {
		double comision;
		if(tipo.equals("Titular")) {
			if(categoria==2)
				comision=limite*0.01;
			else
				comision=limite*0.005;
		}
		else {
			if(categoria==2)
				comision=limite*0.005;
			else
				if(categoria==1)
					comision=limite*0.002;
				else
					comision=limite*0.001;
		}
		return comision;
	//funciones obligatorias//			
	}
	public int compareTo(Tarjeta t) {
		int res;
		if(tarjeta==t.tarjeta)
			res=0;
		else
			if(tarjeta<t.tarjeta)
				res=-1;
			else
				res=1;
		return res;	
	}
	public boolean equals (Tarjeta t) {
		boolean res;
		if(tarjeta==t.tarjeta)
			res=true;
		else 
			res=false;
		return res;
	}
	public String toString() {
		String res;
		res="Tarjeta: "+tarjeta+"Tipo: "+tipo+"Categoría: "+categoria+"Cuenta: "+cuenta+"Año de expedición: "+año+"Año de vencimiento: "+vence+"Límite de crédito: "+limite+"Saldo; "+saldo;
		return res;
	}
}