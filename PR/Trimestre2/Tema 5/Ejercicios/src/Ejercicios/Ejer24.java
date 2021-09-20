package Ejercicios;

import java.util.Scanner;
public class Ejer24 {
	static final int FILAS = 12;
	static final int COLUMNAS = 2;
	static Scanner teclado = new Scanner(System.in);
	static int[][] meses = {
			{1, 31}, {2, 28}, {3, 31},
			{4, 30}, {5, 31}, {6, 30},
			{7, 31}, {8, 31}, {9, 30},
			{10, 31}, {11, 30}, {12, 31}
	};
	
	public static void main(String[] args) {
		Fecha fecha = new Fecha();
		rellenarFecha(fecha);
		teclado.close();
		
		siguienteFecha(fecha);
		System.out.println("La nueva fecha es: " + fecha.numDia + "/" + (fecha.mes + 1 ) + "/" + fecha.anyo);
	}
	
	/** Se piden los valores para una fecha (comprobando que son válidos)  */
	static void rellenarFecha(Fecha fecha) {
		do {
			System.out.print("Dime un anyo:\n>");
			fecha.anyo = teclado.nextInt();
		}while(fecha.anyo < 0);
		if (comprobarBisiesto(fecha.anyo)) {
			meses[1][1] = 29;
		}
		do {
			System.out.print("Dime un mes:\n>");
			fecha.mes = teclado.nextInt() - 1;			
		}while(fecha.mes < 1 || fecha.mes > 12);
		do {
			System.out.print("Dime un dia:\n>");
			fecha.numDia = teclado.nextInt();
		}while(!comprobarDia(fecha.numDia, fecha.mes));
	}
	
	/** Si el día es mayor que el número total de días del mes correspondiente, se pasa al siguiente mes */
	static boolean comprobarDia(int dia, int mes){
		if(dia > meses[mes][1])
			return false;
		return true;
	}
	
	/** Son años bisiestos todos aquellos que sean divisibles entre 4 */
	static boolean comprobarBisiesto(int anyo){
		if(anyo % 4 == 0)
			return true;
		return false;
	}
	
	/** Sumar un día puede aumentar el mes o el año o ninguno */
	static void siguienteFecha(Fecha fecha){
		fecha.numDia++;
		if(fecha.numDia > meses[fecha.mes][1]) {
			fecha.numDia = 1;
			fecha.mes++;
		}
		if(fecha.mes >= meses.length) {
			fecha.anyo++;
			fecha.mes = 0;
		}
	}
}
