import java.util.Scanner;

class Ordenados{
	int num1, num2, num3;
	byte ordenados;
}

class Ejer23_2{
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
		
		Ordenados ord = new Ordenados();
		ord = ordena(num1, num2, num3);
		System.out.println();
		
		if (ord.ordenados == ORDENADO)
			System.out.println("LOS NUMEROS ESTAN ORDENADOS.");
		else{
			System.out.println("LOS NUMEROS ESTABAN DESORDENADOS.");
			System.out.print("El nuevo orden es: ");
			System.out.println(ord.num1 + " > " + ord.num2 + " > " + ord.num3);
		}
			
	}
	
	static Ordenados ordena(int num1, int num2, int num3){
		Ordenados ord = new Ordenados();
		
		//¿ESTAN ORDENADOS?
		if (num1 >= num2 && num2 >= num3){
			ord.ordenados = ORDENADO;
			return ord;
		}
		
		ord.ordenados = DESORDENADO;
			
		if (num1 <= num2){
			int aux = num2;
			num2 = num1;
			num1 = aux;
		}
		if(num1 <= num3){
			int aux = num3;
			num3 = num1;
			num1 = aux;
		}
		if(num2 <= num3){
			int aux = num3;
			num3 = num2;
			num2 = aux;
		}
		
		ord.num1 = num1;
		ord.num2 = num2;
		ord.num3 = num3;
		
		return ord;
	}
}

