import java.util.Scanner;

class SentenciasDeControl{
	static final int IFELSE = 1;
	static final int WHILE = 2;
	static final int DOWHILE = 3;
	static final int FOR = 4;
	static final int SUMA_LIMITE = 50;
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int opc, num;
		int suma = 0;
		
		System.out.println("\t\t=======================");
		System.out.println("\t\t|SENTENCIAS DE CONTROL|");
		System.out.println("\t\t=======================");
		
		System.out.println("\t\t" + IFELSE + ". if-else");
		System.out.println("\t\t" + WHILE + ". while");
		System.out.println("\t\t" + DOWHILE + ". do-while");
		System.out.println("\t\t" + FOR + ". for");
		
		System.out.print("\n\n->");
		opc = teclado.nextInt();
		
		//SWITCH (BREAK)
		switch(opc){
			case 1:
				//IF-ELSE
				int mayorMenor = 10;
				System.out.println("Dime un numero y te dire si es mayor o menor que el que tengo");
				num = teclado.nextInt();
				if (num > mayorMenor)
					System.out.println("Tu numero es mayor");
				else
					System.out.println("Tu numero es menor");
						
				System.out.println("Mi numero era: " + mayorMenor);
				break;
			case 2:
				//WHILE
				System.out.println("Dame numeros hasta que su suma sea mayor o igual que " + SUMA_LIMITE);
				num = teclado.nextInt();
				suma = num;
				while(suma < 50){
					System.out.println("Quedan " + (SUMA_LIMITE - suma));
					num = teclado.nextInt();
					suma += num;
				}
				break;
			case 3:
				//DO-WHILE
				System.out.println("Dame numeros hasta que su suma sea mayor o igual que " + SUMA_LIMITE);
				do{
					num = teclado.nextInt();
					suma += num;
					System.out.println("Quedan " + (SUMA_LIMITE - suma));
				}while(suma < 50);
				break;
			case 4:
				//FOR(CONTINUE)
				System.out.println("Pares entre 0 y...");
				int ciclos = teclado.nextInt();
				for (int i = 1; i < ciclos; i++)
				{
					if(i % 2 != 0)
						continue;
					
					System.out.println(i);
				}
				break;
			default:
				System.err.println("ERROR: VALOR INCORRECTO");
				break;
		}
		teclado.close();
	}
}
