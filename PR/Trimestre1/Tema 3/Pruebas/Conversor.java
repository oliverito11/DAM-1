import java.util.Scanner;

class Conversor{
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args){
		byte opc;
		int num;
		int binario = 2;
		int hexadecimal = 16;
		
		System.out.println("Cual es la conversion que deseas hacer?");
		System.out.println("[1]-D -> B\n[2]-D -> H");
		System.out.println("[3]-B -> D\n[4]-B -> H");
		System.out.println("[5]-H -> B\n[6]-H -> D");
		opc = teclado.nextByte();
		
		switch(opc)
		{
			case 1:
				System.out.println("Dime el numero decimal");
				num = teclado.nextInt();
				DivisionesSucesivas(num, binario);
				break;
			case 2:
				System.out.println("Dime el numero decimal");
				num = teclado.nextInt();
				DivisionesSucesivas(num, hexadecimal);
				break;
			case 3:
				System.out.println("Dime el numero binario");
				num = teclado.nextInt();
				MultiplicacionBase(num, binario);
				break;
			case 4:
				System.out.println("Dime el numero binario");
				num = teclado.nextInt();
				break;
			case 5:
				break;
			case 6:
				System.out.println("Dime el numero hexadecimal");
				num = teclado.nextInt();
				MultiplicacionBase(num, hexadecimal);
				break;
			default:
				break;
		}
	}

	static void DivisionesSucesivas(int num, int divisor){
		int lastCociente = 0;
		int resto;
		String result = "";
		
		while (num > 0)
		{
			resto = num % divisor;
			if (divisor == 16)
			{
				result = ToHexadecimal(resto) + result;
			}
			else
			{
				result = resto + result;
			}
			lastCociente = num / divisor;
			num /= divisor;
		}
		System.out.println(result = lastCociente == 0 ? result : lastCociente + result);
	}
	
	static String ToHexadecimal(int resto)
	{
		switch(resto)
		{
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
	
	static void MultiplicacionBase(int num, int base)
	{
		
	}
}
