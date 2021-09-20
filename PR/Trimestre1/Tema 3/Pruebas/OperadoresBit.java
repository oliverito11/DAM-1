import java.util.Scanner;

class OperadoresBit{
	public static void main(String[] args){
		/*
		 * Permisos 000
		 * Primer bit: lectura
		 * Segundo bit: escritura
		 * Tercer bit: ejecucion
		 */
		 byte permisos;
		 Scanner teclado = new Scanner(System.in);
		 
		 System.out.println("Dime el numero de tus permisos (0 - 7)");
		 permisos = nextByte();
		 teclado.close();
		 
	}
}
