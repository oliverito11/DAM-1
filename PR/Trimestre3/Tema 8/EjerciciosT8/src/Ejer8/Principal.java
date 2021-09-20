package Ejer8;

public class Principal {
	public static void main(String[] args) {
		int[][] pos = new int[][]{
			{2, 3}
		};
		Circunferencia cir = new Circunferencia("Rojo", pos, 5.4d);
		System.out.println("El área de la circunferencia es: " + cir.calcularArea());
		System.out.println("El perímetro de la circunferencia es: " + cir.calcularPerimetro());
		
		double[] lados = new double[] {2, 2};
		Cuadrado cua = new Cuadrado("Verde", pos, lados);
		System.out.println("El área del cuadrado es: " + cua.calcularArea());
		System.out.println("El perímetro del cuadrado es: " + cua.calcularPerimetro());
		
		double[] ladosTri = new double[] {3, 4, 5};
		Triangulo tri = new Triangulo("Amarillo", pos, ladosTri);
		System.out.println("El área del triángulo es: " + tri.calcularArea());
		System.out.println("El perímetro del triángulo es: " + tri.calcularPerimetro());
		
		double[] ladosRec = new double[] {8, 9};
		Cuadrilatero rec = new Rectangulo("Negro", pos, ladosRec);
		System.out.println("El área del rectángulo es: " + rec.calcularArea());
		System.out.println("El perímetro del rectángulo es: " + rec.calcularPerimetro());
		
	}
}
