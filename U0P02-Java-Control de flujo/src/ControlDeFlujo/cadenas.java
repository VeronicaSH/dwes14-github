package ControlDeFlujo;
import java.util.Scanner;
public class cadenas {
	String cadena=" ";
	String cadenaNueva=" ";
	
	public String Aceptar(){
        String cadena;
        Scanner teclado= new Scanner(System.in);
        System.out.println("Introduce cadena");
        cadena=teclado.nextLine();
        teclado.close();
        return cadena;
        
    }
	public void validar() {
	        String []cadena1=new String[4];
	        for(int i=0;i<cadena1.length;i++){
	            cadena1[i]=Aceptar();
	        }
	        for(int i=0;i<cadena1.length;i++) {
	        	cadenaNueva.concat(cadena1[i]);
	        }
	}
	
	public static void main(String[] args) {
		cadenas ejercicio= new cadenas();
		ejercicio.validar();
		
		
	}

}
