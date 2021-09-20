package Ejer5;

public class Principal {
	static final int NUM_INICIAL = 1234;
	public static void main(String[] args) {
		//Multiplicaci�n
		System.out.println("\t\tMULTIPLICACI�N");
		System.out.println("\t\t--------------");
		Multiplicacion m = new Multiplicacion(12);
		Encriptador e = new Encriptador(NUM_INICIAL, m, true);
		
		//Encriptaci�n
		int numCodificado = e.encriptado();
		System.out.println("El n�mero " + NUM_INICIAL + " codificado es: " + numCodificado);

		//Desencriptaci�n
		e.setCodigo(numCodificado);	
		e.setEncriptar(false);
		System.out.println("El n�mero " + numCodificado + " descodificado es: " + e.encriptado());
		
		//Diferencia
		System.out.println("\n\t\tDIFERENCIA");
		System.out.println("\t\t----------");
		e.setCodigo(NUM_INICIAL);
		Diferencia d = new Diferencia(12);
		e.setAlgoritmo(d);
		e.setEncriptar(true);

		//Encriptaci�n
		numCodificado = e.encriptado();
		System.out.println("El n�mero " + NUM_INICIAL + " codificado es: " + numCodificado);
		
		//Desencriptaci�n
		e.setEncriptar(false);
		e.setCodigo(numCodificado);
		System.out.println("El n�mero " + numCodificado + " descodificado es: " + e.encriptado());

		//XOR
		System.out.println("\n\t\tXOR");
		System.out.println("\t\t---");
		e.setCodigo(NUM_INICIAL);
		XOR x = new XOR(12);
		e.setAlgoritmo(x);
		e.setEncriptar(true);

		//Encriptaci�n
		numCodificado = e.encriptado();
		System.out.println("El n�mero " + NUM_INICIAL + " codificado es: " + numCodificado);
		
		//Desencriptaci�n
		e.setEncriptar(false);
		e.setCodigo(numCodificado);
		System.out.println("El n�mero " + numCodificado + " descodificado es: " + e.encriptado());

	}
}
