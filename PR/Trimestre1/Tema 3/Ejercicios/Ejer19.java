class Ejer19{
	public static void main(String[] args){
		Multiplicacion(1);
	}
	
	static void Multiplicacion(int num){
		System.out.println("\nTabla de multiplicar del: " + num);
		for (int i = 0; i <= 10; i++)
		{
			System.out.println(num + " x " + i + " = " + num * i);
		}
		if (num < 10)
		{
			Multiplicacion(num + 1);
		}
	}
}
