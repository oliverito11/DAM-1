package Ejercicios;

import java.util.Scanner;

public class Ejer23B {
	static final int MESES = 12;
	static Scanner teclado = new Scanner(System.in);
	static int[][] meses = {
			{1, 31}, {2, 28}, {3, 31},
			{4, 30}, {5, 31}, {6, 30},
			{7, 31}, {8, 31}, {9, 30},
			{10, 31}, {11, 30}, {12, 31}
	};
	
	public static void main(String[] args) {
		//Almaceno la fecha de nacimiento del usuario
		System.out.println("\t\tFECHA DE NACIMIENTO DEL USUARIO");
		System.out.println("\t\t===============================");
		Fecha nacimiento = new Fecha();
		rellenarFecha(nacimiento);
		
		limpiarPantalla();
		
		//Almaceno la fecha a día de hoy		
		System.out.println("\t\tFECHA DE HOY");
		System.out.println("\t\t============");
		Fecha hoy = new Fecha();
		rellenarFecha(hoy);
		
		System.out.println("La cantidad de días transcurridos en ese plazo de tiempo es: " + contarDias(hoy, nacimiento));
		
		teclado.close();
	}
	
	/** Se pedirá un año, mes y día y se evaluará la veracidad de cada dato */
	static void rellenarFecha(Fecha fecha) {
		do {
			System.out.print("Anyo:\n>");
			fecha.anyo = teclado.nextInt();
		//No puede haber años negativos
		}while(fecha.anyo < 0);
		do {
			System.out.print("Mes:\n>");
			fecha.mes = teclado.nextInt() - 1;
		//Los meses van desde el 1 hasta el 12
		}while(fecha.mes < 0 || fecha.mes > 12);
		do {
			System.out.print("Dia:\n>");
			fecha.numDia = teclado.nextInt();
		}while(!comprobarDia(fecha.numDia, fecha.mes));
	}
	
	/** Si un día es mayor que el mes que le corresponde o es negativo, es erróneo */
	static boolean comprobarDia(int dia, int mes){
		if(dia > meses[mes][1] || dia < 1)
			return false;
		return true;
	}
	
	static long contarDias(Fecha hoy, Fecha nacimiento) {
		long dias = 0;
		
		//Empiezo a sumar los días desde el año de nacimiento hasta el año anterior a este
		for (int i = nacimiento.anyo; i < hoy.anyo; i++)
			//Relleno la variable con los dias de cada mes hasta el anterior al objetivo
			for (int j = 0; j < MESES; j++)
				dias += meses[j][1];
		
		//Sumo los días de todos los meses hasta el anterior al objetivo
		for (int j = 0; j < hoy.mes; j++)
			dias += meses[j][1];
		
		//Ahora sumo los días restantes: TotalDiasMes - (TotalDiasMes - DiaObjetivo)
		dias += meses[hoy.mes][1] - (meses[hoy.mes][1] - hoy.numDia);
		return dias;
	}
	
	static void limpiarPantalla() {
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
	}
}