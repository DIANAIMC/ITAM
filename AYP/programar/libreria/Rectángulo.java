package libreria;

public class Rectángulo{
	private double base;
	private double altura;
	public Rectángulo (double base,double altura) {
		this.base=base;
		this.altura=altura;
	}
	public double getBase(){
		return base;
	}
	public double getAltura(){
		return altura;
	}
	public void setBase(double b){
		base=b;
	}
	public void setAltura(double a){
		altura=a;
	}
	public double calculaArea(){
		double area;
		area=base*altura;
		return area;
	}
	public double calculaPerimetro(){
		double perimetro;
		perimetro=base*2+altura*2;
		return perimetro;
	}
	public String toString(){
		String res; 
		res="base es"+ base + "altura es" + altura;
		return res;
	}
	public boolean equals(Rectángulo r){
		boolean res;
		if(base==r.base && altura==r.altura)
			res=true;
		else
			res=false;
		return res;
	}
	public int compareTo(Rectángulo r){
		int res;
		if(base==r.base && altura==r.altura) 
			res=0;
		else 
			if(base>r.base && altura>r.altura)
				res=1;
			else
				res=-1;
		return res;
	}
}

	
