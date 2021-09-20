package Ejercicios;

import java.util.Scanner;
public class Ejer23 {
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
		System.out.println("Desde el primer dia del año " + fecha.anyo + " hasta el " + fecha.numDia + "/" + (fecha.mes + 1) + " han pasado " + contarDias(fecha) + " dias");
	}
	
	static void rellenarFecha(Fecha fecha) {
		do {
			System.out.print("Dime un anyo:\n>");
			fecha.anyo = teclado.nextInt();
		}while(fecha.anyo < 0);
		do {
			System.out.print("Dime un mes:\n>");
			fecha.mes = teclado.nextInt() - 1;			
		}while(fecha.mes < 1 || fecha.mes > 12);
		do {
			System.out.print("Dime un dia:\n>");
			fecha.numDia = teclado.nextInt();
		}while(!comprobarDia(fecha.numDia, fecha.mes));
	}
	
	static boolean comprobarDia(int dia, int mes){
		if(dia > meses[mes][1])
			return false;
		return true;
	}
	
	static long contarDias(Fecha fecha) {
		long dias = 0;
		
		//Relleno la variable con los dias de cada mes hasta el anterior al objetivo
		for (int i = 0; i < fecha.mes; i++)
			dias += meses[i][1];
		
		//Ahora sumo los días restantes: TotalDiasMes - (TotalDiasMes - DiaObjetivo)
		dias += meses[fecha.mes][1] - (meses[fecha.mes][1] - fecha.numDia);
		return dias;
	}
}