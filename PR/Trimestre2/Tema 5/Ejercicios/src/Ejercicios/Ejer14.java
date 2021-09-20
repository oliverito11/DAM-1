package Ejercicios;

import java.util.Scanner;
import java.util.Locale;

public class Ejer14 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
		
		System.out.print("Dime un float:\n>");
		float num = teclado.nextFloat();
		
		System.out.print("Dime la cantidad de decimales que quieres obtener:\n>");
		int decimales = teclado.nextInt();
		teclado.close();
		
		int resultado = obtenerDecimales(num, decimales);
		System.out.println("Los decimales del numero " + num + " son: " + resultado);
	}
	
	static int obtenerDecimales(float num, int decimales){
		String numero = Float.toString(num);
		int desde = numero.indexOf('.') + 1;
		int resultado = 0;
		if(desde > 0) {
			int hasta = desde + decimales;
			if(hasta >= numero.length())
				hasta = numero.length();
			
			String substr = numero.substring(desde, hasta);
			resultado = Integer.parseInt(substr);
		}
		return resultado;
	}
}
