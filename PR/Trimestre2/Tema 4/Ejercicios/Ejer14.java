import java.util.Scanner;

class Ejer14{
	static Scanner teclado = new Scanner(System.in);
	
	static final int TRIANGULO = 1;
	static final int CUADRILATERO = 2;
	static final int CIRCUNFERENCIA = 3;
	static final int SALIR = 4;
	
	static final int PERIMETRO = 1;
	static final int AREA = 2;
	static final int VOLVER = 3;
	
	static int opc, opc2;
	
	public static void main(String[] args){
		do{
			switch(menu()){
				case TRIANGULO:
					do{
						switch(submenu()){
							case PERIMETRO:
								double per = perimetro(TRIANGULO);
								System.out.println("El perimetro del triangulo es: " + per);
								break;
							case AREA:
								double are = area(TRIANGULO);
								System.out.println("El area del triangulo es: " + are);
							case VOLVER:
								break;
							default:
								System.err.println("ERROR! Valor incorrecto");
						}
					}while(opc2 != 3);
					break;
				case CUADRILATERO:
					do{
						switch(submenu()){
							case PERIMETRO:
								double per = perimetro(CUADRILATERO);
								System.out.println("El perimetro del cuadrilatero es: " + per);
								break;
							case AREA:
								double are = area(CUADRILATERO);
								System.out.println("El area del cuadrilatero es: " + are);
							case VOLVER:
								break;
							default:
								System.err.println("ERROR! Valor incorrecto");
						}
					}while(opc2 != 3);
					break;
				case CIRCUNFERENCIA:
					do{
						switch(submenu()){
							case PERIMETRO:
								double per = perimetro(CIRCUNFERENCIA);
								System.out.println("El perimetro de la circunferencia es: " + per);
								break;
							case AREA:
								double are = area(CIRCUNFERENCIA);
								System.out.println("El area de la circunferencia es: " + are);
							case VOLVER:
								break;
							default:
								System.err.println("ERROR! Valor incorrecto");
						}
					}while(opc2 != 3);
					break;
				case SALIR:
					break;
				default:
					System.err.println("\t\t--VALOR INCORRECTO--");
			}
		}while(opc != 4);
		teclado.close();
	}
	
	static int menu(){
		System.out.println("\t\t--------------------");
		System.out.println("\t\t|AREAS Y PERIMETROS|");
		System.out.println("\t\t--------------------");
		System.out.println("\t\t" + TRIANGULO + ". Triangulo");
		System.out.println("\t\t" + CUADRILATERO + ". Cuadrilatero");
		System.out.println("\t\t" + CIRCUNFERENCIA + ". Circunferencia");
		System.out.println("\t\t" + SALIR + ". Salir");
		System.out.print("\n\n\t\t->");
		opc = teclado.nextInt();
		
		return opc;
	}
	
	static int submenu(){
		System.out.println("\t\t" + PERIMETRO + ". Perimetro");
		System.out.println("\t\t" + AREA + ". Area Comprendida");
		System.out.println("\t\t" + VOLVER + ". Volver");
		System.out.print("\n\n\t\t->");
		opc2 = teclado.nextInt();
		
		return opc2;
	}
	
	static double perimetro(int figura){
		float lado1, lado2, lado3;
		double per = 0;
		switch(figura){
			case TRIANGULO:
				System.out.println("Dime el primer lado del triangulo");
				lado1 = teclado.nextFloat();
				System.out.println("Dime el segundo lado del triangulo");
				lado2 = teclado.nextFloat();
				System.out.println("Dime el tercer lado del triangulo");
				lado3 = teclado.nextFloat();
				
				per = lado1 + lado2 + lado3;
				break;
			case CUADRILATERO:
				System.out.println("Dime un lado del cuadrilatero");
				lado1 = teclado.nextFloat();
				per = lado1 * 4;
				break;
			case CIRCUNFERENCIA:
				System.out.println("Radio de la circunferencia:");
				lado1 = teclado.nextFloat();
				per = 2 * Math.PI + lado1;
				break;
		}
		return per;
	}
	
	static double area(int figura){
		float base, altura;
		double are = 0;
		
		switch(figura){
			case TRIANGULO:
				System.out.println("Dime la base del triangulo");
				base = teclado.nextFloat();
				System.out.println("Dime la altura del triangulo");
				altura = teclado.nextFloat();
				are = (base * altura) / 2;
				break;
			case CUADRILATERO:
				System.out.println("Dime la base del cuadrilatero");
				base = teclado.nextFloat();
				System.out.println("Dime la altura del cuadrilatero");
				altura = teclado.nextFloat();
				are = base * altura;
				break;
			case CIRCUNFERENCIA:
				System.out.println("Dime el radio de la circunferencia");
				int radio = teclado.nextInt();
				are = Math.PI * (float)Math.pow(radio, 2);
				break;
		}
		
		return are;
	}
}
