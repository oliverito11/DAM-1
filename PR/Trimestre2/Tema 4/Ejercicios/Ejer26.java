import java.util.Scanner;
import java.util.Locale;

class Ejer26{
	static Scanner teclado = new Scanner(System.in);
	static final int DOS_ENTEROS = 1;
	static final int TRES_ENTEROS = 2;
	static final int TRES_REALES = 3;
	static final int DOS_CADENAS = 4;
	static final int SUMAS_SUCESIVAS = 5;
	static final int LINEAS = 55;

	public static void main(String[] args){
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
		
		int num1, num2;
		int opc = menu();
		limpiarPantalla();
		switch(opc){
			case DOS_ENTEROS:
				System.out.println("Dame un primer valor entero");
				num1 = teclado.nextInt();
				System.out.println("Dame un segundo valor entero");
				num2 = teclado.nextInt();
				
				System.out.println("La suma de los dos valores enteros es " + suma(num1, num2));
				break;
			case TRES_ENTEROS:
				System.out.println("Dame un primer valor entero");
				num1 = teclado.nextInt();
				System.out.println("Dame un segundo valor entero");
				num2 = teclado.nextInt();
				System.out.println("Dame un tercer valor entero");
				int num3 = teclado.nextInt();
				
				System.out.println("La suma de los tres valores enteros es " + suma(num1, num2, num3));
				break;
			case TRES_REALES:
				System.out.println("Dame un primer valor real");
				float numF1 = teclado.nextFloat();
				System.out.println("Dame un segundo valor real");
				float numF2 = teclado.nextFloat();
				System.out.println("Dame un tercer valor real");
				float numF3 = teclado.nextFloat();
				
				System.out.println("La suma de los tres valores reales es " + suma(numF1, numF2, numF3));
				break;
			case DOS_CADENAS:
				System.out.println("Dame una primera cadena de texto");
				String txt1 = teclado.next();
				System.out.println("Dame una segunda cadena de texto");
				String txt2 = teclado.next();
				
				System.out.println("La concatenacion de ambas cadenas es " + suma(txt1, txt2));
				break;
			case SUMAS_SUCESIVAS:
				System.out.println("La suma de todos los valores introducidos es " + suma());
				break;
			default:
				System.err.println("ERROR. Valor incorrecto");
		}
		teclado.close();
	}
	
	static int menu(){
		System.out.println("\t\t=======");
		System.out.println("\t\t SUMAS");
		System.out.println("\t\t=======");
		
		System.out.println("\t" + DOS_ENTEROS + " - Suma de dos enteros");
		System.out.println("\t" + TRES_ENTEROS + " - Suma de tres enteros");
		System.out.println("\t" + TRES_REALES + " - Suma de tres reales");
		System.out.println("\t" + DOS_CADENAS + " - Concatenacion de cadenas");
		System.out.println("\t" + SUMAS_SUCESIVAS + " - Sumas sucesivas");
		
		System.out.print("\n\tElija una opcion:\t");
		return teclado.nextInt();
	}
	
	/** Método sobre las sucesivas sumas que devolverá esta cuando el usuario introduzca un 0 */
	static int suma(){
		int sum = 0;
		int num;
		do{
			System.out.println("Dame un valor (0 para salir)");
			num = teclado.nextInt();
			sum += num;
		}while(num != 0);
		
		return sum;
	}
	
	static int suma(int num1, int num2){
		return num1 + num2;
	}
	
	static int suma(int num1, int num2, int num3){
		return num1 + num2 + num3;
	}
	
	static float suma(float  num1, float num2, float num3){
		return num1 + num2 + num3;
	}
	
	static String suma(String txt1, String txt2){
		return txt1 + txt2;
	}
	
	static void limpiarPantalla(){
		for (int i = 0; i < LINEAS; i++)
			System.out.println();
	}
}
