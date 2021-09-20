/**
 * Agenda de cumplea�os en la que se muestra un men� donde se le pide
 * al usuario una opci�n y se ejecutar� aquella correspondiente
 * a la deseada por dicho usuario. Las opciones son:
 * - Agregar un nuevo cumplea�os
 * - Mostrar los cumplea�os
 * - Salir del programa
 * Se le pedir� antes al usuario la ruta del fichero que hace de agenda.
 * */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ejer7 {
	static final int NUEVO = 1;
	static final int CONSULTAR = 2;
	static final int SALIR = 3;
	static Scanner teclado = new Scanner(System.in);
	static int[][] meses = {
			{1, 31}, {2, 28}, {3, 31},
			{4, 30}, {5, 31}, {6, 30},
			{7, 31}, {8, 31}, {9, 30},
			{10, 31}, {11, 30}, {12, 31}
	};
	
	static File agenda;
	public static void main(String[] args) {
		int opc = 0;
		agenda = pedirAgenda();
		do {
			System.out.println("\t\tCUMPLEA�OS");
			System.out.println("\t\t==========");
			System.out.println("[" + NUEVO + "] - Nuevo cumplea�os");
			System.out.println("[" + CONSULTAR + "] - Consultar cumplea�os");
			System.out.println("[" + SALIR + "] - Salir");
			opc = pedirValor();
			teclado.nextLine();
			seleccionMenu(opc);
		}while(opc != SALIR);
	}
	
	static int pedirValor() {
		int opc = 0;
		try {
			opc = teclado.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("Se esperaba un n�mero");
		}
		return opc;
	}
	
	static void seleccionMenu(int opc) {
		switch(opc) {
		case NUEVO:
			nuevoCumpleanyos(agenda, pedirCumple());
			break;
		case CONSULTAR:
			mostrarCumpleanyos(agenda);
			break;
		case SALIR:
			System.out.println("Fin del programa.");
			break;
		}
	}
	
	static void mostrarCumpleanyos(File agenda) {
		BufferedReader br = null;
		String fecha = "";
		Cumple c = new Cumple();
		try {
			br = new BufferedReader(new FileReader(agenda));
			while((c.nombre = br.readLine()) != null) {
				fecha = br.readLine();
				if(fecha == null)
					System.err.println("Error en el formato de cumplea�os de " + c.nombre);
				else {
					String[] temp = fecha.split("[/]");
					c.dia = Integer.parseInt(temp[0]);
					c.mes = Integer.parseInt(temp[1]);
					c.anyo = Integer.parseInt(temp[2]);
				}
				System.out.println("El cumplea�os de " + c.nombre + " es el d�a " + c.dia + " del " + c.mes + " (naci� en el a�o " + c.anyo + ").");
			}
		}catch(NumberFormatException e) {
			System.err.println("Error al leer el cumplea�os. " + e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Error al leer la fecha " + fecha + ". " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error al leer el fichero. " + e.getMessage());
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero. " + e.getMessage());
			}
		}
	}
	
	static void nuevoCumpleanyos(File agenda, Cumple cumpleanyos) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(agenda, true));
			pw.println(cumpleanyos.nombre + "\n" + cumpleanyos.dia + "/" + cumpleanyos.mes + "/" + cumpleanyos.anyo );
		}catch(IOException e) {
			System.err.println("Error al escribir en el fichero" + e.getMessage());
		}finally {
			if(pw != null)
				pw.close();
		}
	}
	
	/** Se le pedir� al usuario introducir una ruta y se comprobar� que existe y que no es un directorio */
	static File pedirAgenda() {
		String ruta = ".";
		File fichero;
		do {
			System.out.println("Dime la ruta de la agenda");
			ruta = teclado.nextLine();
			fichero = new File(ruta);
			if(!fichero.exists() || !fichero.isFile())
				System.out.println("El fichero <" + fichero + "> no existe o es un directorio.");			
		}while(!fichero.exists() || !fichero.isFile());
		
		return fichero;
	}
	
	/** Se pide un nombre y fecha correcta al usuario */
	static Cumple pedirCumple() {
		Cumple cumple = new Cumple();
		String fecha = "";
		do {			
			System.out.println("Nombre:");
			cumple.nombre = teclado.nextLine();
			System.out.println("Fecha (dd/mm/aaaa):");
			fecha = teclado.nextLine();
		}while(!comprobarFecha(fecha));
		
		String[] partesFecha = fecha.split("[/]");
		cumple.dia = Integer.parseInt(partesFecha[0]);
		cumple.mes = Integer.parseInt(partesFecha[1]);
		cumple.anyo = Integer.parseInt(partesFecha[2]);
		
		return cumple;
	}
	
	/** La fecha debe tener 3 partes, cada una en formato num�rico y dicho valor tiene que ser correcto */
	static boolean comprobarFecha(String fecha) {
		String[] partesFecha = fecha.split("[/]");
		
		if(partesFecha.length != 3) {
			System.err.println("La fecha est� mal introducida. Formato correcto: (dd/mm/aaaa)");
			return false;
		}
		for(int i = 0; i < partesFecha.length; i++) {
			//Se comprubea que todos los caracteres son num�ricos
			for(int j = 0; j < partesFecha[i].length(); j++) {
				if(!Character.isDigit(partesFecha[i].charAt(j))) {
					System.err.println("La fecha debe ser en formato num�rico.");
					return false;
				}
			}
		}
		
		int dia = Integer.parseInt(partesFecha[0]);
		int mes = Integer.parseInt(partesFecha[1]);
		
		//Se comprueba que el dia y mes son correctos
		if(mes > meses.length || dia > meses[mes][1]) {
			System.out.println("La fecha no es correcta");
			return false;
		}
		
		return true;
	}
}
