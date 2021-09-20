import java.util.Scanner;

class Ejer29 {
	static Scanner teclado = new Scanner(System.in);
	
	static final int TRIANGULO = 1;
	static final int CUADRILATERO = 2;
	static final int CIRCUNFERENCIA = 3;
	static final int SALIR = 4;
	
	static final int PERIMETRO = 1;
	static final int AREA = 2;
	static final int VOLVER = 3;
	
	static final float PI = 3.1415f;
	
	static int opc;
	
	public static void main(String[] args){
		Menu();		
	}
	
	static void Menu(){
		do{
			System.out.println("\t\t--------------------");
			System.out.println("\t\t|AREAS Y PERIMETROS|");
			System.out.println("\t\t--------------------");
			System.out.println("\t\t" + TRIANGULO + ". Triangulo");
			System.out.println("\t\t" + CUADRILATERO + ". Cuadrilatero");
			System.out.println("\t\t" + CIRCUNFERENCIA + ". Circunferencia");
			System.out.println("\t\t" + SALIR + ". Salir");
			System.out.print("\n\n\t\t->");
			opc = teclado.nextInt();
			
			switch(opc){
				case TRIANGULO:
					Submenu(TRIANGULO);
					break;
				case CUADRILATERO:
					Submenu(CUADRILATERO);
					break;
				case CIRCUNFERENCIA:
					Submenu(CIRCUNFERENCIA);
					break;
				case SALIR:
					break;
				default:
					System.err.println("\t\t--VALOR INCORRECTO--");
			}
		}while(opc != 4);
	}
	
	static void Submenu(int figura){
		do{
			System.out.println("\t\t" + PERIMETRO + ". Perimetro");
			System.out.println("\t\t" + AREA + ". Area Comprendida");
			System.out.println("\t\t" + VOLVER + ". Volver");
			System.out.print("\n\n\t\t->");
			opc = teclado.nextInt();
			System.out.println("\n\n");
			float lado, radio;
			
			//TRIANGULO
			if (figura == 1){				
				switch(opc){
					case 1:
						System.out.println("Dime un lado del triangulo (equilatero)");
						lado = teclado.nextFloat();
						System.out.println("El perimetro del triangulo es: " + (3 * lado));
						break;
					case 2:
						System.out.println("Dime un lado del triangulo (equilatero)");
						lado = teclado.nextFloat();
						System.out.println("El area del triangulo equilatero es: " + ((Math.sqrt(3) / 4) * Math.pow(lado, 2)));
						break;
					case 3:
						break;
					default:
						System.err.println("\t\t--VALOR INCORRECTO--");
				}
			}
			//CUADRILATERO
			else if(figura == 2){
				switch(opc){
					case 1:
						System.out.println("Dime un lado del cuadrilatero");
						lado = teclado.nextFloat();
						System.out.println("El perimetro del cuadrilatero es: " + (4 * lado));
						break;
					case 2:
						System.out.println("Dime un lado del cuadrilatero");
						lado = teclado.nextFloat();
						System.out.println("El area del cuadrilatero es: " + (Math.pow(lado, 2)));
						break;
					case 3:
						break;
					default:
						System.err.println("\t\t--VALOR INCORRECTO--");
				}
			}
			//CIRCUNFERENCIA
			else{
				switch(opc){
					case 1:
						System.out.println("Radio de la circunferencia (float):");
						radio = teclado.nextFloat();
						System.out.println("El radio de la circunferencia es: " + (2 * PI * radio));
						break;
					case 2:
						System.out.println("Radio de la circunferencia (float):");
						radio = teclado.nextFloat();
						System.out.println("El area de la circunferencia es: " + (PI * Math.pow(radio, 2)));
						break;
					case 3:
						break;
					default:
						System.err.println("\t\t--VALOR INCORRECTO--");
				}
			}
			
			System.out.println("\n\n");
		}while(opc != 3);
	}
}
