import java.util.Scanner;

class TicTacToe{
	
	static Scanner teclado = new Scanner(System.in);
	static int linea, columna;
	static int[][] tabla = new int[3][3];
	
	
	public static void main(String[] args){
		do{
			ShowTable();
			PlayerTurn();
			ShowTable();
			try{
				for (int i = 0; i < 3; i++)
				{
					System.out.print(".");
					Thread.sleep(400);
				}
				System.out.println();
			}catch(Exception e){}
			AITurn();
		}while(!CheckTie());
	}
	
	static void ShowTable(){
		System.out.println("| " + tabla[0][0] + " | " + tabla[0][1] + " | " + tabla[0][2] + " |");
		System.out.println("| " + tabla[1][0] + " | " + tabla[1][1] + " | " + tabla[1][2] + " |");
		System.out.println("| " + tabla[2][0] + " | " + tabla[2][1] + " | " + tabla[2][2] + " |");
	}
	
	//PLAYER
	static void PlayerTurn(){
		GetRowCol();
	}
	
	static void GetRowCol(){
		System.out.print("Linea: ");
		linea = teclado.nextInt();
		System.out.print("Columna: ");
		columna = teclado.nextInt();
		CheckRowCol();
	}
	
	static void CheckRowCol(){
		if (linea > 3 || columna > 3){
			System.out.println("VALORES FUERA DE LOS LIMITES");
			GetRowCol();
		}
		else if(tabla[linea - 1][columna - 1] == 0)
			tabla[linea - 1][columna - 1] = 1;
		else{
			System.out.println("YA EXISTE UNA FICHA EN ESA POSICION");
			GetRowCol();
		}
	}
	
	//AI
	static void AITurn(){
		int max = 2;
		int min = 0;
		int range = max - min + 1;
		int lineaAI, columnaAI;
		do{
			lineaAI = (int)(Math.random() * range) + min;
			columnaAI = (int)(Math.random() * range) + min;
		}while(tabla[lineaAI][columnaAI] != 0 && !CheckTie());
		tabla[lineaAI][columnaAI] = 2;
	}
	
	static boolean CheckTie(){
		for (int i = 0; i < tabla.length; i++)
		{
			for (int j = 0; j < tabla[0].length; j++)
			{
				if (tabla[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
