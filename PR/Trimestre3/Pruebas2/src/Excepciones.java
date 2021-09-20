
public class Excepciones {
	public static void main(String[] args) {
		//excepcion();
		
		try {
			arrojaExcepcion();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Excepci�n de �ndice fuera de los l�mites del array");
			System.out.println(e.getMessage());
		}
	}
	
	static void excepcion() {
		try {
			String cad = "hola";
			System.out.println(Integer.parseInt(cad));
		}catch(NumberFormatException e) {
			System.out.println("Error de formato num�rico");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Finally");
		}
		System.out.println("El programa sigue");
	}
	
	static void arrojaExcepcion() throws ArrayIndexOutOfBoundsException{
		int[] arr = new int[2];
		System.out.print(arr[1]);
		
		/*
		 * - Cuando el m�todo est� fuera de un try catch, 
		 * se mostrar� el comportamiento por defecto pero con el
		 * mensaje que hayamos puesto debajo.
		 * - Sin embargo, si atrapamos la excepci�n, el mensaje no saldr�
		 * a menos que usemos el m�todo getMessage();
		*/
		
		/*
		 * throw new NumberFormatException("Excepcion desconocida");
		 * ---------------------------------------------------------
		 * Si no es del mismo tipo, obviamnete se ejecutar� con el 
		 * comportamiento por defecto
		 */
		
		throw new ArrayIndexOutOfBoundsException("Array index out of bounds");
	}
}
