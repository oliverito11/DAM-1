import java.util.Scanner;

class Ejer31{
	
	static final int NUMERO_A_BUSCAR = 345;
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int numeroUsuario;
		int intentos = 10;
		boolean encontrado = false;
		
		System.out.println("\t\t|ADIVINA EL NUMERO|\n");
		do{
			do{
				System.out.println("\nAdivina el numero entre 0 y 999");
				numeroUsuario = teclado.nextInt();
			}while(numeroUsuario < 0);
			intentos--;
			
			if (numeroUsuario == NUMERO_A_BUSCAR)
				encontrado = true;
			else if(numeroUsuario > NUMERO_A_BUSCAR){
				System.out.println("El numero a buscar es mas pequeno");
				System.out.println("Te quedan " + intentos + " intentos");
			}
			else{
				System.out.println("El numero a buscar es mas grande");
				System.out.println("Te quedan " + intentos + " intentos");
			}
		}while(intentos > 0 && encontrado == false);
		
		if (encontrado)
			System.out.println("CORRECTO!");
		else
			System.out.println("SIN INTENTOS! El numero a encontrar era: " + NUMERO_A_BUSCAR);
	}
}
