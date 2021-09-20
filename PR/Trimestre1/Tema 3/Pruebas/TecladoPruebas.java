import java.util.Scanner;
import java.util.Locale;

class TecladoPruebas{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
		
		/*
		try{
			System.out.println("Dame un string");
			int num = System.in.read();
			System.out.println(num);
		}catch(Exception e){
			System.err.println(e);
		}
		*/
		
		System.out.print("Dime su nombre: ");
		String nombre = teclado.next();
		System.out.print("\nDime su edad: ");
		int edad = teclado.nextInt();
		System.out.print("\nDime su peso: ");
		float peso = teclado.nextFloat();
		System.out.print("\nDime su inicial: ");
		char inicial = teclado.next().charAt(0);
		System.out.print("\nDime un byte: ");
		byte bt = teclado.nextByte();
		
		System.out.println(nombre + " | " + edad + " | " + peso + " | " + inicial);
	}
}
