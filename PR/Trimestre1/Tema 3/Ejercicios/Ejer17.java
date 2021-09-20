class Ejer17{
	public static void main(String[] args){
		try{
			System.out.println("Dame un caracter");
			int c = System.in.read();
			
			if(c >= 65 && c <= 90 || c >= 97 && c <= 122)
				System.out.println("El caracter introducido es una letra");
			else if(c >= 48 && c <= 57)
				System.out.println("El caracter introducido es un numero");
			else
				System.out.println("El caracter introducido es un caracter especial");
		}
		catch(Exception e)
			System.err.println("ERROR DE CARACTER");
	}
}
