import java.util.Scanner;

class Ejer30{
	static final int BINARIO = 2;
	static final int OCTAL = 8;
	static final int HEXADECIMAL = 16;
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int num;
		
		System.out.println("Dime el decimal que quieres convertir");
		num = teclado.nextInt();
		teclado.close();
		
		//ORGANIZO EL PROGRAMA EN MÉTODOS
		DivisionesSucesivas(num, BINARIO);
		DivisionesSucesivas(num, OCTAL);
		DivisionesSucesivas(num, HEXADECIMAL);
	}

	static void DivisionesSucesivas(int num, int divisor){
		int resto;
		String result = "";
		
		while (num > 0){
			//OBTENGO LOS VALORES
			resto = num % divisor;
			
			//SI ES BASE HEXADECIMAL, TENGO QUE PASAR LOS VALORES A LETRAS EN CASO DE SER > 9
			if (divisor == HEXADECIMAL)
				
				//TRANSFORMO EL RESTO A HEXADECIMAL EN CASO DE SER MAYOR QUE 9
				result = ToHexadecimal(resto) + result;
			
			//ESTOY EN BASE 2 U 8 (NO TIENEN NADA DE ESPECIAL)
			else
				result = resto + result;
				
			//SIGUIENTE COCIENTE
			num /= divisor;
		}
		System.out.println("El numero dado en base " + divisor + " es: " + result);
	}
	
	static String ToHexadecimal(int resto)
	{
		switch(resto){
			case 10:
				return "A";
			case 11:
				return "B";
			case 12:
				return "C";
			case 13:
				return "D";
			case 14:
				return "E";
			case 15:
				return "F";
			default:
				return Integer.toString(resto);
		}
	}
}

