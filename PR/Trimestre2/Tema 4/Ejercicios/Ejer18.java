import java.util.Scanner;
import java.util.Random;

class Ejer18{
	static final int MAX = 12;
	static final int MIN = 1;
	static final int SI = 1;
	static final int NO = 2;
	
	static int perdidas = 0;
	static int ganadas = 0;
	static boolean finPartida = false;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("\t\t\t=======");
		System.out.println("\t\t\t|CRAPS|");
		System.out.println("\t\t\t=======");
		int decision;
		
		do{
			juego();
			estadisticas();
			finPartida = false;
		}while(seguirJugando() == SI);
		teclado.close();
	}
	
	/** Tirada de los dados */
	static int tirada(){
		Random r = new Random();
		int dado = r.nextInt(MAX - MIN + 1) + MIN;
		
		return dado;
	}
	
	/** Módulo principal del juego */
	static void juego(){
		//SE HACE UNA PRIMERA TIRADA Y SE COMPRUEBA SI HA GANADO, SI HA PERDIDO O SI SE CONTINÚA JUGANDO
		boolean primeraTirada = true;
		int numVictoria = 0;
		do{
			System.out.println("Pulsa ENTER para tirar los dados...");
			teclado.nextLine();
			teclado.nextLine();
			
			int num = tirada();
			System.out.println(num);
			
			if (primeraTirada){
				numVictoria = num;
				comprobarNumPrimera(num);
				primeraTirada = false;
			}
			else
				comprobarNum(num, numVictoria);
			
		}while(!finPartida);
	}
	
	/** Compruebo la primera tirada */
	static void comprobarNumPrimera(int num){
		if (num == 7 || num == 11)
			victoria();
		else if(num == 2 || num == 3 || num == 12)
			derrota();
	}
	
	/** Compruebo las siguientes tiradas */
	static void comprobarNum(int num, int numVictoria){
		if (num == 7)
			derrota();
		else if(num == numVictoria)
			victoria();
	}
	
	static void victoria(){
		ganadas++;
		finPartida = true;
		System.out.println("HAS GANADO!");
	}
	
	static void derrota(){
		perdidas++;
		finPartida = true;
		System.out.println("HAS PERDIDO...");
	}
	
	/** Se mostrarán las estadísticas cada vez que se termine la partida, mostrando las partidas ganadas, perdidas y el total de estas */
	static void estadisticas(){
		System.out.println("\t\t\tESTADISTICAS");
		System.out.println("\t\t\t------------");
		
		System.out.println("Numero de partidas jugadas: " + (ganadas + perdidas));
		System.out.println("Numero de partidas ganadas: " + ganadas);
		System.out.println("Numero de partidas perdidas: " + perdidas);
	}
	
	/** Se le pregunta al usuario si desea continuar o no, devolviendo el valor correspondiente para finalizar o no el proceso. Se asegura que se introduzca un valor correcto */
	static int seguirJugando(){
		int decision;
		
		System.out.println("Desea seguir jugando?");
		System.out.println("[" + SI + "]-Si");
		System.out.println("[" + NO + "]-No");
		
		do{
			decision = teclado.nextInt();
		}while(decision != SI && decision != NO);
		
		return decision;
	}
}
