package ControlDeFlujo;
import java.util.Scanner;
public class diaSemana {
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce dia");
		String dia=teclado.next();
		teclado.close();
		switch(dia) {
			case "lunes": System.out.println("laborable");
			break;
			case "martes": System.out.println("laborable");
			break;
			case "miercoles": System.out.println("laborable");
			break;
			case "jueves": System.out.println("laborable");
			break;
			case "viernes": System.out.println("laborable");
			break;
			case "sabado": System.out.println("laborable");
			break;
			case "domingo": System.out.println("no laborable");
			break;

}
	}

}
