package Ejer3;

import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Creación de las cuentas
		Titular oli = new Titular("Oliver", "Linares", "Colinas", 18);
		CuentaCorriente cc1 = new CuentaCorriente("1F", 200f, oli);

		Titular oli2 = new Titular("Oliver2", "Linares2", "Colinas2", 20);
		CuentaCorriente cc2 = new CuentaCorriente("2H", 100f, oli2);
		
		//Mostrar las cuentas
		System.out.println("\nCuenta corriente de " + cc1.getTitular());
		cc1.imprimirCuenta();
		System.out.println("\nCuenta corriente de " + cc2.getTitular());
		cc2.imprimirCuenta();
		
		//Ingresar dinero en una cuenta
		System.out.println("¿Cuánto dinero quieres añadir a la cuenta de " + cc1.getTitular() + "?");
		cc1.ingresar(teclado.nextFloat());
		cc1.imprimirCuenta();
		
		//Retirar dinero en una cuenta
		System.out.println("¿Cuánto dinero quieres retirar de la cuenta de " + cc2.getTitular() + "?");
		cc2.reintegro(teclado.nextFloat());
		cc2.imprimirCuenta();
		
		//Comparación de cuentas
		System.out.println("\n\nComparar distintas cuentas (mayor - menor):");
		cc1.compararCuentas(cc1, cc2);
		System.out.println("\n\nComparar distintas cuentas (menor - mayor):");
		cc1.compararCuentas(cc2, cc1);
		System.out.println("\n\nComparar la misma cuenta:");
		cc1.compararCuentas(cc1, cc1);
		
		//Cuentas ahorro
		CuentaAhorro ca1 = new CuentaAhorro(oli, "5G", 2.5f);
		System.out.println("Dime la cantidad de dinero que quieres insertar en la cuenta:");
		ca1.ingresar(teclado.nextFloat());
		
		System.out.println("Dicha cuenta ahorro tiene unos intereses de " + ca1.getInteres() + ", lo que resulta en un saldo de: " + ca1.calcularInteres());
		teclado.close();
	}
}
