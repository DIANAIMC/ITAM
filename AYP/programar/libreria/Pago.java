package libreria;

public class Pago {
	private static int claveUnica=1;
	private double monto;
	private String tipoPago;
	private double descuento;
	private int claveCliente;
	private boolean status;
	
	public Pago(double monto, String tp, double d, int cc, boolean s) {
		claveUnica ++;
		this.monto=monto;
		tipoPago=tp;
		descuento=d;
		claveCliente=cc;
		status=s;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double m) {
		monto=m;
	}
	public double calculaDescuento(boolean bandera) {
		double res;
		if(bandera)
			if (monto>200 && monto < 500)
				res=monto*.02;
			else 
				if (monto>=500 && monto<1000)
				res=monto*0.025;
				else 
				res=monto*0.03;
		else
			res=0;
		return res;
	}
	public double calculaComision() {
		double res = 0;
		switch(tipoPago) {
			case "PP": res=monto*0.034;
			break;
			case "TC": res=monto*0.036;
			break;
			case "TD": res=monto*0.025;
			break;
		}
		return res;
	}
	public double calculaIva(){
		double res;
		res=monto*.16;
		return res;
				
	}
	public double montoTotal() {
		double res;
		res=monto-calculaDescuento(true)+calculaComision()+calculaIva();
		return res;
	}
	public boolean equals(Pago p) {
		boolean res=false;
		if (claveUnica==p.claveUnica)
			res=true;
		return res;
	}
	public int compareTo(Pago p) {
		int res=-1;
		if(claveUnica==p.claveUnica)
			res=0;
		else
			if(claveUnica>p.claveUnica)
				res=1;
			return res;
	}
	public String toString() {
		String res;
		res="la clave unica es"+claveUnica+"el monto es"+monto+"el tipo de pago es"+tipoPago+"el descuento es"+descuento;
		return res;
	}
}
