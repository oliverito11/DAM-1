class OperadoresArit{
	public static void main(String[] args){
		int num1 = 4, num2 = 4;
		
		System.out.println("\t\t========================");
		System.out.println("\t\t|OPERADORES ARITMETICOS|");
		System.out.println("\t\t========================");
		
		System.out.println("Suma (4 + 4): " + (num1 + num2));
		System.out.println("Resta (4 - 4): " + (num1 - num2));
		System.out.println("Producto (4 * 4): " + (num1 * num2));
		System.out.println("Division (4 / 4): " + (num1 / num2));
		System.out.println("Modulo (4 % 4): " + (num1 % num2));
		
		System.out.println("\n");
		
		System.out.println("INCREMENTO/DECREMENTO");
		System.out.println("----------");
		System.out.println("num1 vale " + num1);
		System.out.println("num1 con postincremento vale primero " + num1++ + " y luego " + num1);
		
		num1 = 4;
		System.out.println("num1 vale " + num1);
		System.out.println("num1 con preincremento vale primero " + ++num1 + " y luego " + num1);
		
		num1 = 4;
		System.out.println("num1 vale " + num1);
		System.out.println("num1 con postdecremento vale primero " + num1-- + " y luego " + num1);
		
		num1 = 4;
		System.out.println("num1 vale " + num1);
		System.out.println("num1 con predecremento vale primero " + --num1 + " y luego " + num1);
	}
}
