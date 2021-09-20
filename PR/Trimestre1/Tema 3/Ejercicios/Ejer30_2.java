import java.util.Scanner;

class Ejer30_2{
	static final int BINARIO = 2;
	static final int OCTAL = 8;
	static final int HEXADECIMAL = 16;
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int num, resto, temp;
		String result = "";
		
		System.out.println("Dime el decimal que quieres convertir");
		num = teclado.nextInt();
		temp = num;
		teclado.close();
		
		//CONVIERTO A BINARIO
		while (num > 0){
			//OBTENGO LOS VALORES
			resto = num % BINARIO;
			result = resto + result;
				
			//SIGUIENTE COCIENTE
			num /= BINARIO;
		}
		System.out.println("El numero dado en base " + BINARIO + " es: " + result);
		
		//RESETEO LAS VARIABLES
		result = "";
		num = temp;
		
		//CONVIERTO A HEXADECIMAL
		while(num > 0){
			resto = num % HEXADECIMAL;
			
			switch(resto){
			case 10:
				result = 'A' + result;
				break;
			case 11:
				result = 'B' + result;
				break;
			case 12:
				result = 'C' + result;
				break;
			case 13:
				result = 'D' + result;
				break;
			case 14:
				result = 'E' + result;
				break;
			case 15:
				result = 'F' + result;
				break;
			default:
				result = resto + result;
				break;
			}
			num /= HEXADECIMAL;
		}
		System.out.println("El numero dado en base " + HEXADECIMAL + " es: " + result);

		//RESETEO LAS VARIABLES		
		result = "";
		num = temp;
		
		//CONVIERTO A OCTAL
		while(num > 0){
			resto = num % OCTAL;
			result = resto + result;
			num /= OCTAL;
		}
		System.out.println("El numero dado en base " + OCTAL + " es: " + result);
	}
}
