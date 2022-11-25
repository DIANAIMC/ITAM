package ejecutables;
import libreria.Rectángulo;
import java.util.Scanner;
import libreria.Círculo;
import java.util.*;
public class CalculaEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, k;
		double totalArea=0;
		double base, altura;
		double radio;
		double areaTapete=0;
		Scanner lee;
	
		lee = new Scanner(System.in);
		
Rectángulo oficina;
        Círculo tapete;
        //pedimos n oficinas
             System.out.println("cuantas oficinas vas a ingresar?");
n= lee.nextInt();

           for(int i=1; i<=n;i++) {

                    System.out.println("dame la base de la oficina");
                          base = lee.nextDouble();
                   System.out.println("dame la altura de la oficina");
                          altura=lee.nextDouble();
                          oficina=new Rectángulo(base,altura);
                          totalArea += oficina.calculaArea();
                          System.out.println("cuantos tapetes hay en la oficina "+i +"?");
	                      k = lee.nextInt();
           for(int j=1; j<=k; j++) {
	              
	               System.out.println("dame el radio del tapete"+ j);
	                      radio = lee.nextDouble();
	                      tapete= new Círculo(radio);
	                      areaTapete += tapete.calculaArea();
	
	
	

}
	}
System.out.println("El area vacia de todas las oficinas es:" + (totalArea-areaTapete));


	}

}