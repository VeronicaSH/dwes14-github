package ControlDeFlujo;
import java.util.Scanner;
public class sumaNumeros {

	public static void main(String[] args) {
		int num;
		int suma=0;
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce numeros");
		num=teclado.nextInt();
		while(num<=50){
			suma+=num;
			System.out.println("Introduce numeros");
			num=teclado.nextInt();
			}
		System.out.println(suma);
		teclado.close();
		}
}


