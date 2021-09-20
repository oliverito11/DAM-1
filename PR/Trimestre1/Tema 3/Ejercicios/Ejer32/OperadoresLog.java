class OperadoresLog{
	public static void main(String[] args){
		boolean verdadero = true;
		boolean falso = false;
		
		System.out.println("\t\t====================");
		System.out.println("\t\t|OPERADORES LOGICOS|");
		System.out.println("\t\t====================");
		
		System.out.println("Verdadero && Falso = " + (verdadero && falso));
		System.out.println("Verdadero && Verdadero = " + (verdadero && verdadero));
		System.out.println("\n");
		
		System.out.println("Verdadero || Falso = " + (verdadero || falso));
		System.out.println("Verdadero || Verdadero = " + (verdadero || verdadero));
		System.out.println("Falso || Falso = " + (falso || falso));
		System.out.println("\n");
		
		System.out.println("!Verdadero = " + (!verdadero));
		System.out.println("!Falso = " + !falso);
	}
}
