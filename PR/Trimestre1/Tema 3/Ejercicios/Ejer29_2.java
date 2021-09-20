import java.util.Locale;
import java.util.Scanner;

class Ejer29_2{
	static Scanner teclado = new Scanner(System.in);
	
	static final int TRIANGULO = 1;
	static final int CUADRILATERO = 2;
	static final int CIRCUNFERENCIA = 3;
	static final int SALIR = 4;
	
	static final int PERIMETRO = 1;
	static final int AREA = 2;
	static final int VOLVER = 3;
	
	static final float PI = 3.1415f;
	
	static int opc, opc2;
	
	public static void main(String[] args){
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
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
			
		
			//ACCIÓN DEL PRIMER MENÚ
			switch(opc){
				case TRIANGULO:
					do{
						System.out.println("\t\t" + PERIMETRO + ". Perimetro");
						System.out.println("\t\t" + AREA + ". Area Comprendida");
						System.out.println("\t\t" + VOLVER + ". Volver");
						System.out.print("\n\n\t\t->");
						opc2 = teclado.nextInt();
						System.out.println("\n\n");
						float ladoT;
						
						//ACCIÓN DEL SUBMENÚ
						switch(opc2){
							case PERIMETRO:
								System.out.println("Dime un lado del triangulo (equilatero)");
								ladoT = teclado.nextFloat();
								System.out.println("El perimetro del triangulo es: " + (3 * ladoT));
								break;
							case AREA:
								System.out.println("Dime un lado del triangulo ");
								ladoT = teclado.nextFloat();
								System.out.println("El area del triangulo equilatero es: " + ((Math.sqrt(3) / 4) * Math.pow(ladoT, 2)));
								break;
							case VOLVER:
								break;
							default:
								System.err.println("\t\t--VALOR INCORRECTO--");
						}
					}while(opc2 != VOLVER);
					break;
					
				case CUADRILATERO:
					do{
						System.out.println("\t\t" + PERIMETRO + ". Perimetro");
						System.out.println("\t\t" + AREA + ". Area Comprendida");
						System.out.println("\t\t" + VOLVER + ". Volver");
						System.out.print("\n\n\t\t->");
						opc2 = teclado.nextInt();
						System.out.println("\n\n");
						float ladoC;
						
						//ACCIÓN DEL SUBMENÚ
						switch(opc2){
							case PERIMETRO:
								System.out.println("Dime un lado del cuadrilatero");
								ladoC = teclado.nextFloat();
								System.out.println("El perimetro del cuadrilatero es: " + (4 * ladoC));
								break;
							case AREA:
								System.out.println("Dime un lado del cuadrilatero");
								ladoC = teclado.nextFloat();
								System.out.println("El area del cuadrilatero es: " + (Math.pow(ladoC, 2)));
								break;
							case VOLVER:
								break;
							default:
								System.err.println("\t\t--VALOR INCORRECTO--");
						}
					}while(opc2 != VOLVER);
					break;
					
				case CIRCUNFERENCIA:
					do{
						System.out.println("\t\t" + PERIMETRO + ". Perimetro");
						System.out.println("\t\t" + AREA + ". Area Comprendida");
						System.out.println("\t\t" + VOLVER + ". Volver");
						System.out.print("\n\n\t\t->");
						opc2 = teclado.nextInt();
						System.out.println("\n\n");
						float radio;
						
						//ACCIÓN DEL SUBMENÚ
						switch(opc2){
							case PERIMETRO:
								System.out.println("Radio de la circunferencia (float):");
								radio = teclado.nextFloat();
								System.out.println("El radio de la circunferencia es: " + (2 * PI * radio));
								break;
							case AREA:
								System.out.println("Radio de la circunferencia (float):");
								radio = teclado.nextFloat();
								System.out.println("El area de la circunferencia es: " + (PI * Math.pow(radio, 2)));
								break;
							case VOLVER:
								break;
							default:
								System.err.println("\t\t--VALOR INCORRECTO--");
						}
					}while(opc2 != VOLVER);
					break;
				case SALIR:
					break;
				default:
					System.err.println("\t\t--VALOR INCORRECTO--");
			}
		}while(opc != SALIR);
		teclado.close();
	}
}
