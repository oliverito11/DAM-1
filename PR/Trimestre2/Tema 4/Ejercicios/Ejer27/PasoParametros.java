class Asignatura{
	String nombre;
}

class PasoParametros{
	public static void main(String[] args){
		System.out.println("==============");
		System.out.println("PASO POR VALOR");
		System.out.println("==============");
		
		int num = 2;
		System.out.println("Valor de num antes: \t\t" + num);
		cambioValor(num);
		System.out.println("Valor de num despues: \t\t" + num);
		
		System.out.println("\n");
		
		System.out.println("===================");
		System.out.println("PASO POR REFERENCIA");
		System.out.println("===================");
		
		Asignatura asig = new Asignatura();
		asig.nombre = "Programacion";
		
		System.out.println("Nombre de la asignatura antes: \t\t" + asig.nombre);
		cambioNombre(asig);
		System.out.println("Nombre de la asignatura despues: \t" + asig.nombre);
	}
	
	static void cambioValor(int num){
		num = 100;
		System.out.println("Valor de num en el metodo: \t" + num);
	}
	
	static void cambioNombre(Asignatura asig){
		asig.nombre = "Lenguajes de Marca";
		System.out.println("Nombre de la asignatura en el metodo: \t" + asig.nombre);
	}
}
