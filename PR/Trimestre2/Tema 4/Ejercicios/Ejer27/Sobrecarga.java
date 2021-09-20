class Sobrecarga{
	public static void main(String[] args){
		System.out.println("Metodo suma sin valores --> " + suma());
		
		int num1 = 10, num2 = 5;
		System.out.println("Metodo suma con dos valores --> " + suma(num1, num2));
		
		String txt1 = "Hola, ";
		String txt2 = "mundo!";
		System.out.println("Metodo suma de dos Strings --> " + suma(txt1, txt2));
	}
	
	static int suma(){
		int num1 = 4, num2 = 4;
		return num1 + num2;
	}
	
	static int suma(int num1, int num2){
		return num1 + num2;
	}
	
	static String suma(String txt1, String txt2){
		return txt1 + txt2;
	}
}
