package Ejer5;

public class Principal {
	static final int NUM_INICIAL = 1234;
	public static void main(String[] args) {
		//Multiplicación
		System.out.println("\t\tMULTIPLICACIÓN");
		System.out.println("\t\t--------------");
		Multiplicacion m = new Multiplicacion(12);
		Encriptador e = new Encriptador(NUM_INICIAL, m, true);
		
		//Encriptación
		int numCodificado = e.encriptado();
		System.out.println("El número " + NUM_INICIAL + " codificado es: " + numCodificado);

		//Desencriptación
		e.setCodigo(numCodificado);	
		e.setEncriptar(false);
		System.out.println("El número " + numCodificado + " descodificado es: " + e.encriptado());
		
		//Diferencia
		System.out.println("\n\t\tDIFERENCIA");
		System.out.println("\t\t----------");
		e.setCodigo(NUM_INICIAL);
		Diferencia d = new Diferencia(12);
		e.setAlgoritmo(d);
		e.setEncriptar(true);

		//Encriptación
		numCodificado = e.encriptado();
		System.out.println("El número " + NUM_INICIAL + " codificado es: " + numCodificado);
		
		//Desencriptación
		e.setEncriptar(false);
		e.setCodigo(numCodificado);
		System.out.println("El número " + numCodificado + " descodificado es: " + e.encriptado());

		//XOR
		System.out.println("\n\t\tXOR");
		System.out.println("\t\t---");
		e.setCodigo(NUM_INICIAL);
		XOR x = new XOR(12);
		e.setAlgoritmo(x);
		e.setEncriptar(true);

		//Encriptación
		numCodificado = e.encriptado();
		System.out.println("El número " + NUM_INICIAL + " codificado es: " + numCodificado);
		
		//Desencriptación
		e.setEncriptar(false);
		e.setCodigo(numCodificado);
		System.out.println("El número " + numCodificado + " descodificado es: " + e.encriptado());

	}
}
