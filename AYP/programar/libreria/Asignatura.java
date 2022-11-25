package libreria;

public class Asignatura {
	private String nombre;
	private double nota;
	

	public Asignatura(String nombre,double nota) {
		this.nombre=nombre;
		this.nota=nota;
	}
	public void setNota(double n) {
		nota=n;
	}
	public double getNota() {
		return nota;
	}
	public String getNombre() {
		return nombre;
	}
	public String calculaota() {
		String res="aprobado";
		if (nota<60)
			res="reprobado";
		return res;
	}
	}
