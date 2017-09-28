package ControlDeFlujo;
import java.util.Scanner;
public class numeroMenor {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce primer numero");
		int num1=teclado.nextInt();
		System.out.println("Introduce segundo numero");
		int num2=teclado.nextInt();
		teclado.close();
		while(num1 <=10 && num2<=10) {
			if(num1<num2) {
				num1++;
				System.out.println("*");
			}else {
				System.out.println("*");
				num2++;
			}
		}
		
	}

}
