package ControlDeFlujo;
import java.util.Scanner;
public class factorial_do_while {
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce numero");
		int num=teclado.nextInt();
		teclado.close();
		int factorial=num;
		int total=1;
		 do
	     {
	       total *= factorial;
	       factorial--;
	       //Primero se ejecuto el cuerpo dentro del bucle y despues examinamos la sentencia  
	      }while(factorial>0);
	       System.out.println("El valor total del factorial" + total);  
	       
	       
		
		
	}

}
