class OperadoresAsig{
	public static void main(String[] args){
		int num1 = 5, num2 = 4;
		
		System.out.println("\t\t=========================");
		System.out.println("\t\t|OPERADORES DE ASIGNACION|");
		System.out.println("\t\t=========================");
		
		System.out.println("5 += 4 -> " + (num1 += num2));
		num1 = 5;
		num2 = 4;
		System.out.println("5 -= 4 -> " + (num1 -= num2));
		num1 = 5;
		num2 = 4;
		System.out.println("5 *= 4 -> " + (num1 *= num2));
		num1 = 5;
		num2 = 4;
		System.out.println("5 /= 4 -> " + (num1 /= num2));
		num1 = 5;
		num2 = 4;
		System.out.println("5 %= 4 -> " + (num1 %= num2));
	}
}
