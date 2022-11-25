package libreria;

public class Pedido {
	private static int cont=196;
	private int numU;
	private int numA;
	private char horario;
	private int zona;
	private String pago;
	private boolean extra;
	
	public Pedido(){
		numU=cont;
		cont++;
	}
	public Pedido (int numA, char horario, int zona, String pago, boolean extra) {
		this.numA=numA;
		this.horario=horario;
		this.zona=zona;
		this.pago=pago;
		this.extra=extra;
		numU=cont;
		cont++;
	}
	public int getNumU() {
		return numU;
	}
	public void setNumA(int a) {
		numA=a;
	}
	public double calculaMontoPagar() {
		double res=+35;
		if (horario=='D' && extra==true)
			res=res+35+35;
		else
			if(horario=='C'|| horario=='N' && extra==true)
				res=res+20+35;
			break;
		if (pago=="PayPal"||pago=="tarjeta de crédito"&& zona>=4 && zona<=8)
			res=res*1.035+35+30;
		else
			(horario=='N' && zona<=4)
			res=res+5;
		return res;
	}
	public int calculaCubiertos() {
		int res;
		res= (numA)/2;
		return res;
	}
	public boolean equals(Pedido p) {
		boolean res=false;
		if (numU==p.numU)
			res=true;
			return res;	
	}
	public int compareTo(Pedido p) {
		int res=-1;
		if(numU==p.numU)
			res=0;
		else
			if(numU>p.numU)
				res=1;
		return res;
	}
	public String toString () {
		String res;
		res="el número de pedido es:"+numU+" el número de artículos es: "+numA+" el horario es: "+horario+" la zona es: "+zona+" el tipo de pago es: "+pago;
		return res;
	}
	
}
