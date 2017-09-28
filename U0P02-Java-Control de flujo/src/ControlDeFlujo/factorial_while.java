package ControlDeFlujo;
import java.util.Scanner;
public class factorial_while {

	public static void main(String[] args) {
		 Scanner teclado= new Scanner(System.in); // Crear objeto de la clase Scanner para 
         // poder leer los datos

		System.out.print("Numero: ");
		int numero = teclado.nextInt(); // Leer dato
		teclado.close(); //cerramos teclado
		int factorial = 1; // declarar e inicializar factorial en 1
		
		while(numero != 0)
		{
		factorial *= numero;
		numero--;
		}
		
		System.out.print("Factorial: " + factorial); // Imprimir factorial
		}   
		
			}
		
		
