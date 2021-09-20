import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Teclado {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		System.out.println("Dame un número");
		int entero = leerEntero();
		System.out.println(entero + " x " + entero + " = " + (entero*entero));
	}
	
	static int leerEntero() {
		int lectura = 0;
		try {
			lectura = Integer.parseInt(teclado.readLine());
		} catch (IOException e) {
			System.err.println("Error de E/S");
		}catch(NumberFormatException e) {
			System.err.println("Se esperaba un valor numérico");
		}
		return lectura;		
	}
	
	static char leerCaracter() {
		char lectura = 0;
		try {
			//lectura = teclado.readLine().charAt(0);
			lectura = (char)System.in.read();
		} catch (IOException e) {
			System.err.println("Error de E/S");
		}
		return lectura;
	}
	
	static float leerReal() {
		float lectura = 0;
		try{
			lectura = Float.parseFloat(teclado.readLine());
		}catch (IOException e) {
			System.err.println("Error de E/S");
		}catch(NumberFormatException e) {
			System.err.println("Se esperaba un real");
		}
		return lectura;
	}
	
	static double leerDouble() {
		double lectura = 0;
		try{
			lectura = Double.parseDouble(teclado.readLine());
		}catch (IOException e) {
			System.err.println("Error de E/S");
		}catch(NumberFormatException e) {
			System.err.println("Se esperaba un real");
		}
		return lectura;
	}
	
	static String leerCadena() {
		String lectura = "";
		try {
			lectura = teclado.readLine();
		}catch(IOException e) {
			System.err.println("Se esperaba un real");
		}
		return lectura;
	}
}
