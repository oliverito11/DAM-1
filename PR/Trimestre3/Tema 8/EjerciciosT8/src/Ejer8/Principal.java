package Ejer8;

public class Principal {
	public static void main(String[] args) {
		int[][] pos = new int[][]{
			{2, 3}
		};
		Circunferencia cir = new Circunferencia("Rojo", pos, 5.4d);
		System.out.println("El �rea de la circunferencia es: " + cir.calcularArea());
		System.out.println("El per�metro de la circunferencia es: " + cir.calcularPerimetro());
		
		double[] lados = new double[] {2, 2};
		Cuadrado cua = new Cuadrado("Verde", pos, lados);
		System.out.println("El �rea del cuadrado es: " + cua.calcularArea());
		System.out.println("El per�metro del cuadrado es: " + cua.calcularPerimetro());
		
		double[] ladosTri = new double[] {3, 4, 5};
		Triangulo tri = new Triangulo("Amarillo", pos, ladosTri);
		System.out.println("El �rea del tri�ngulo es: " + tri.calcularArea());
		System.out.println("El per�metro del tri�ngulo es: " + tri.calcularPerimetro());
		
		double[] ladosRec = new double[] {8, 9};
		Cuadrilatero rec = new Rectangulo("Negro", pos, ladosRec);
		System.out.println("El �rea del rect�ngulo es: " + rec.calcularArea());
		System.out.println("El per�metro del rect�ngulo es: " + rec.calcularPerimetro());
		
	}
}
