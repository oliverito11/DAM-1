import java.util.Scanner;

class Player implements IPlayers{
	Scanner teclado = new Scanner(System.in);
	public void Turn(){
		GetRowCol();
	}
	
	public void GetRowCol(){
		System.out.print("Linea: ");
		linea = teclado.nextInt();
		System.out.print("Columna: ");
		columna = teclado.nextInt();
		CheckRowCol();
	}
	
	public void CheckRowCol(){
		if (linea > 3 || columna > 3){
			System.out.println("VALORES FUERA DE LOS LIMITES");
			GetRowCol();
		}
	}
}
