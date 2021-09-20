class TiposDeDatosMetodos{
	public static void main(String[] args){
		System.out.println("Metodo que devuelve un entero --> " + suma());
		System.out.println("Metodo que devuelve un real --> " + division());
		System.out.println("Metodo que devuelve un caracter --> " + caracter());
		System.out.println("Metodo que devuelve una cadena de caracteres --> " + mensaje());
		System.out.println("Metodo que no devuelve nada --> ");
		mensajeTantasVeces(10);
	}
	
	static int suma(){
		int num1 = 10, num2 = 5;
		return num1 + num2;
	}
	
	static float division(){
		float num1 = 4f, num2 = 3f;
		return num1 / num2;
	}
	
	static char caracter(){
		char letra = 65;
		return letra;
	}
	
	static String mensaje(){
		String msg = "Buenos dias";
		return msg;
	}
	
	static void mensajeTantasVeces(int num){
		for (int i = 0; i < num; i++)
			System.out.println("Texto numero " + i);
	}
}
