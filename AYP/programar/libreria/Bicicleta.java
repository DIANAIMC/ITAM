package libreria;

public class Bicicleta {
	private static int cont=200;
	private int numI;
	private char tipo;
	private int numA;
	private String matF;
	
	public Bicicleta(char tipo, int numA, String matF) {
		this.tipo=tipo;
		this.numA=numA;
		this.matF=matF;
		cont=cont++;
		numI=cont;
	}
	public Bicicleta(char tipo, String matF) {
		this.tipo=tipo;
		this.matF=matF;
		cont=cont++;
		numI=cont;
	}
	public void setNumA(int n) {
		numA=n;
	}
	public int getNumA() {
		return numA;
	}
	public double caclculaCosto() {
		double res=0;
		switch (tipo) {
		case 'U':
			res=700;
			break;
		case 'P':
			res=15000;
			break;
		case 'M':
			res=27000;
			break;
		}
		if (matF.equals("aluminio"))
			res=res+2000;
		else
			if(matF.equals("fibra de carbono"))
				res=res+5000;
		if (numA==3 || numA==4)
			res=res+600;
		else 
			if (numA>4)
				res=res+1000;
		return res;
	}
	public int calculaTiempo() {
		int res = 0;
		if (tipo=='U')
			res=1;
		else
			if(tipo=='M'|| tipo=='P')
				res=2;
		if (matF.equals("fibra de carbono"))
			res=res+1;

		return res;
	}
	public boolean equals(Bicicleta b) {
		boolean res=false;
		if(numI==b.numI)
			res=true;
		return res;
	}
	public int compareTo(Bicicleta b) {
		int res=-1;
		if(numI==b.numI)
			res=0;
		else
			if (numI>b.numI)
				res=1;
		return res;
	}
	public String toString() {
		String res;
		res="numero de identificación "+numI+" tipo: "+tipo+" número de artículos: "+numA+" material de fabricación: "+matF;
		return res;
	}
}
