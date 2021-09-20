class ManejoBits{
	public static void main(String[] args){
		int num1 = 5;
		
		//5 * 2 * 2 = 20
		System.out.println("5 dos bits a la izquierda es: " + (num1 << 2));
		
		//5 * 2 * 2 * 2 = 40
		System.out.println("5 tres bits a la izquierda es: " + (num1 << 3));
		
		int num2 = 50;
		
		//50 / 2 / 2 = 12
		System.out.println("50 dos bits a la derecha es: " + (num2 >> 2));
		
		//50 / 2 / 2 / 2 = 6
		System.out.println("50 dos bits a la derecha es: " + (num2 >> 3));
		
		int cero = 0;
		System.out.println("0 complemento a uno es: " + (~cero));
		
		
		System.out.println("AND: " + (8 | 5));
	}
}
