class ConversionDeDatos{
	public static void main(String[] args){
		int num1 = 10, num2 = 6;
		byte numByte = 13;
		System.out.println("Division de enteros: " + (num1 / num2));
		System.out.println("Division de reales: " + ((float)num1 / num2));
		System.out.println("byte > short > int > long > float > double");
		System.out.println("El byte " + numByte + " a short: " + (short)numByte);
		System.out.println("El byte " + numByte + " a double: " + (double)numByte);
		
		System.out.println("\n");
		String numeroStr = "20";
		System.out.println(numeroStr + " es un String");
		System.out.println(Integer.parseInt(numeroStr) + " + " + num1 + " = " + (Integer.parseInt(numeroStr) + num1));
		System.out.println(Integer.toString(num1) + " es ahora un String tambien");
	}
}
