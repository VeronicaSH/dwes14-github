package ControlDeFlujo;
import java.util.Scanner;
public class factorial_for {
	public int factorial() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce numero");
		int num=teclado.nextInt();
		int resultado=1;
		teclado.close();
		for(int i=1;i<=num;i++) {
			resultado=resultado*i;
			System.out.println(resultado);
		}
		return resultado;
		
		
	}
	public static void main(String[] args) {
		factorial_for ejercicio=new factorial_for();
		ejercicio.factorial();

	}

}
