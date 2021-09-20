class Ejer20 {

	static final int LIMITE = 20;
	
	public static void main(String[] args){
		int suma5 = 0;

		for (int i = 2; i < LIMITE; i += 3)
		{
			int suma = 0;
			for (int j = i; j < i + 3; j++)
			{
				suma += j;
				if (j % 5 == 0)
					suma5 += j;
			}
			System.out.println(suma);
		}
		
		System.out.println("La suma de los numeros divisibles entre 5 es: " + suma5);
	}
}
