import java.util.Scanner;

class Ejer23{
	static final int ORDENADO = 1;
	static final int DESORDENADO = -1;
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el primer valor");
		int num1 = teclado.nextInt();
		System.out.println("Introduzca el segundo valor");
		int num2 = teclado.nextInt();
		System.out.println("Introduzca el tercer valor");
		int num3 = teclado.nextInt();
		teclado.close();
		
		int[] orden = ordena(num1, num2, num3);
		if (orden[3] == ORDENADO)
			System.out.println("LOS NUMEROS ESTAN ORDENADOS.");
		else{
			System.out.println("LOS NUMEROS ESTABAN DESORDENADOS.");
			System.out.print("El nuevo orden es: ");
			for (int i = 0; i < orden.length - 1; i++)
				System.out.print(orden[i]);
		}
			
	}
	
	static int[] ordena(int num1, int num2, int num3){
		//SE USA UNA POSICION DE MAS PARA GUARDAR EL INDICADOR DE SI ESTABAN O NO ORDENADOS
		int[] orden = new int[4];
		
		//¿ESTAN ORDENADOS?
		if (num1 >= num2 && num1>= num3 && num2 >= num3){
			orden[3] = ORDENADO;
			return orden;
		}
		else
			orden[3] = DESORDENADO;
			
		if (num1 <= num2){
			int aux = num2;
			num2 = num1;
			num1 = aux;
		}
		if(num1 <= num3){
			int aux = num3;
			num3 = num1;
			num1 = aux;
			orden[0] = num1;
		}
		if(num2 <= num3){
			int aux = num3;
			num3 = num2;
			num2 = aux;
			orden[1] = num2;
			orden[2] = num3;
		}
		return orden;
	}
}
