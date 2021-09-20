import java.util.Scanner;

class Ejer8{
	
	static final int LETRA = 1;
	static final int NUMERO = 2;
	static final int CHAR_ESPECIAL = 3;
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un caracter y te dire de que tipo es");
		char carac = teclado.next().charAt(0);
		teclado.close();
		
		switch(tipoCaracter(carac)){
			case LETRA:
				System.out.println("El caracter introducido es una letra");
				break;
			case NUMERO:
				System.out.println("El caracter introducido es un numero");
				break;
			case CHAR_ESPECIAL:
				System.out.println("El caracter introducido es un caracter especial");
				break;
			default:
				System.err.println("ERROR. Ha habido un error al detectar el caracter");
		}
	}
	
	static int tipoCaracter(char c){
		int tipo;
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
			tipo = LETRA;
		else if(c >= '0' && c <= '9')
			tipo = NUMERO;
		else
			tipo = CHAR_ESPECIAL;
			
		return tipo;
	}
}
