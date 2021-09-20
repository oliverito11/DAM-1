class OperadoresBit{
	public static void main(String[] args){
		int num1 = 9, num2 = 2;
		
		System.out.println("\t\t===========================");
		System.out.println("\t\t|OPERADORES A NIVEL DE BIT|");
		System.out.println("\t\t===========================");
		
		System.out.println("\nDESPLAZAMIENTO");
		System.out.println("--------------");
		System.out.println(num1 + " un bit a la izquierda es " + (num1 << 1));
		System.out.println(num1 + " un bit a la derecha es " + (num1 >> 1));
		
		System.out.println("\nLOGICOS");
		System.out.println("--------------");
		System.out.println(num1 + " & " + num2 + " = " + (num1 & num2));
		System.out.println(num1 + " | " + num2 + " = " + (num1 | num2));
		System.out.println(num1 + " ^ " + num2 + " = " + (num1 ^ num2));
		System.out.println("~" + num1 + " = " + (~num1));
	}
}
