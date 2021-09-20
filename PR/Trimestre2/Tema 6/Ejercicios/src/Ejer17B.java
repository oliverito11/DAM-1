/**
 * Programa que gestiona la escritura de datos personales de un Alumno en un fichero
 * de texto. Se tendrán que hacer 2 versiones donde en la primera el fichero tendrá
 * un carácter delimitador y en la segunda se hará mediante columnas.
 * */

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
public class Ejer17B {
	static final int COLUMNAS = 20;
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Uso correcto del programa: java Ejer17 <fichero>");
			return;
		}
		teclado.useLocale(Locale.ENGLISH);
		String agenda = args[0];
		if(!escribirAlumno(pedirAlumno(), agenda))
			System.err.println("Error al añadir alumnos.");
	}
	
	static boolean escribirAlumno(AlumnoDatos a, String agenda) {
		boolean resultado = true;
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileWriter(agenda, true));
			pw.append(escribirAlumno(a.nombre) + escribirAlumno(a.primerA) + escribirAlumno(a.segundoA) + escribirAlumno(a.curso) + escribirAlumno(Integer.toString(a.edad)) + escribirAlumno(Character.toString(a.grupo)) + escribirAlumno(Float.toString(a.media)));
		}catch(IOException e) {
			System.err.println("Error de E/S");
			resultado = false;
		}finally {
			if(pw != null)
				pw.close();
		}
		
		return resultado;
	}
	
	static AlumnoDatos pedirAlumno() {
		AlumnoDatos a = new AlumnoDatos();
		
		System.out.print("Nombre del alumno:\n>");
		a.nombre = teclado.nextLine();
		System.out.print("Primer apellido del alumno:\n>");
		a.primerA = teclado.nextLine();
		System.out.print("Segundo apellido del alumno:\n>");
		a.segundoA = teclado.nextLine();
		System.out.print("Curso del alumno:\n>");
		a.curso = teclado.nextLine();
		System.out.print("Grupo:\n>");
		a.grupo = teclado.nextLine().charAt(0);
		System.out.print("Edad del alumno:\n>");
		a.edad = teclado.nextInt();
		System.out.print("Nota media del alumno:\n>");
		a.media = teclado.nextFloat();
		
		return a;
	}
	
	static String escribirAlumno(String dato) {
		int cont = 0;
		StringBuffer resultado = new StringBuffer("");
		for(int i = 0; i < dato.length(); i++) {
			resultado.append(dato.charAt(i));
			cont++;
		}
		
		if(cont > COLUMNAS) {
			System.err.println("El dato supera los " + COLUMNAS + " carácteres.");
			resultado = null;
		}else {
			while(cont < COLUMNAS) {
				resultado.append(" ");
				cont++;
			}
		}
		
		return resultado.toString();
	}
}
