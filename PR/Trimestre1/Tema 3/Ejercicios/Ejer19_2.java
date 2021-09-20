class Ejer19_2{
	public static void main(String[] args){
		int num = 1;
		do{
			System.out.println("\nTabla de multiplicar del: " + num);
			for (int i = 0; i <= 10; i++)
				System.out.println(num + " x " + i + " = " + num * i);
			num++;
		}while(num <= 10);
	}
}

