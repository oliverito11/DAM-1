package Ejercicios;
import java.util.Scanner;

public class Ejer8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime la cantidad de filas que quieres visualizar\n>");
		int[][] numeros = new int[teclado.nextInt()][];
		teclado.close();
		
		rellenarMatriz(numeros);
	}

	/** Se irá iterando por toda la matriz y aumentando la longitud de cada fila */
	static void rellenarMatriz(int[][] nums) {
		for (int i = 0, cols = 1; i < nums.length; i++, cols += 2){
			//Reseteamos la variable de nums
			int num = 1;
			
			//Añadir nuevas columnas a cada fila
			nums[i] = new int[cols];
			
			//Rellenar array 1a parte
			for (int j = 0; j < nums[i].length / 2; j++) {
				nums[i][j] = num % 10;
				num++;
				System.out.print(nums[i][j]);
			}
			
			//Rellenar array 2a parte
			for (int j = nums[i].length / 2; j < nums[i].length; j++) {
				nums[i][j] = num % 10;
				num--;
				System.out.print(nums[i][j]);
			}
			
			//Nueva linea
			System.out.println();
		}
	}
}
