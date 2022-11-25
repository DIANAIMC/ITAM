package libreria;

public class Círculo {
	private double radio;
		
	public Círculo() {
		
	}
	public Círculo (double radio) {
		this.radio=radio;
	}
	public double getRadio () {
		return radio;
	}
	public void setRadio (double r) {
		radio=r;
	}
	public double calculaArea() {
		double área;
		área=3.1416*radio*radio;
		return área;
	}
	public double calculaPerimetro() {
		double perímetro;
		perímetro=3.1416*radio*radio;
		return perímetro;
	}
	public String toString () {
		String res; 
		res="radio es" + radio;
		return res;
	}
	public boolean equals (Círculo c) {
		boolean res;
		if(radio==c.radio)
			res=true;
		else
			res=false;
		return res;
	}
	public int compareTo (Círculo c) {
		int res;
		if(radio==c.radio) 
			res=0;
		else 
			if(radio>c.radio)
				res=1;
			else
				res=-1;
		return res;
	}
}
