package libreria;

public class Servicio {
	private static int cont=0;
	private int numU;
	private int numC;
	private int numV;
	private int numP;
	private char turno;
	private int zona;
	private double km;
	private boolean pool;
	
	public Servicio(){
		cont++;
		numU=cont;
	}
	public Servicio(int numC, int numV, int numP, char turno, int zona, double km, boolean pool){
		cont++;
		numU=cont;
		this.numC=numC;
		this.numV=numV;
		this.numP=numP;
		this.turno=turno;
		this.zona=zona;
		this.km=km;
		this.pool=pool;
	}
	public boolean getPool() {
		return pool;
	}
	public double calculaMontoPagar(){
		double res;
		if (pool==true)
			res=km*6+12;
		else
			res=km*12+12;
		if (turno='N' && zona>=4 && zona<=8)
			res=res+80;
		else
			if (turno='M' && zona>=1 && zona<=4 && km>15)
				res=res+30;
		return res;
	}
	public boolean servicioExtenso() {
		boolean res=true;
		if (pool==false && km>30)
			res=false;
		return res;
	}
	public boolean equals(Servicio s){
		boolean res=false;
		if (numU==s.numU)
			res=true;
		return res;
	}
	public int compareTo(Servicio s) {
		int res=-1;
		if (numU==s.numU)
			res=0;
		else
			if (numU>s.numU)
				res=1;
		return res;
	}
	public String StringTo() {
		String res;
		res="número único: "+numU+" número de conductor: "+numC+" número de vehículo: "+numV+" número de pasajero: "+numP+" turno: "+turno+" zona: "+zona+" km recorridos: "+km+" pool: "+pool;
		return res;
	}
}
