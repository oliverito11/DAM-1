package Ejercicios;

import java.util.Scanner;

class Ejer3{
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args){
		Mes[] meses = new Mes[12];
		for (int i = 0; i < meses.length; i++){
			limpiarPantalla();
			meses[i] = rellenarMes();
			System.out.println("\n\nPulsa una tecla para continuar...");
			teclado.nextLine();
			teclado.nextLine();
		}
		
		for (int i = 0; i < meses.length; i++){
			limpiarPantalla();
			mostrarMes(meses[i]);
			System.out.println("\n\nPulsa una tecla para continuar...");
			teclado.nextLine();
		}
		teclado.close();
	}
	
	static Mes rellenarMes(){
		Mes mes = new Mes();
		System.out.print("Nombre del mes:\n>");
		mes.nombre = teclado.next();
		System.out.print("Numero del mes:\n>");
		mes.numero = teclado.nextInt();
		System.out.print("Dias del mes:\n>");
		mes.dias = teclado.nextInt();
		System.out.print("Temperatura media del mes:\n>");
		mes.temperatura = teclado.nextFloat();
		return mes;
	}
	
	static void mostrarMes(Mes mes){
		System.out.println("Nombre del mes: " + mes.nombre);
		System.out.println("Numero  del mes: " + mes.numero);
		System.out.println("Dias que tiene del mes: " + mes.dias);
		System.out.println("Temperatura media del mes: " + mes.temperatura);
	}
	
	static void limpiarPantalla(){
		for (int i = 0; i < 35; i++)
			System.out.println();
	}
}
