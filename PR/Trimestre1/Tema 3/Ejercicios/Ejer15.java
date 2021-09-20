import java.util.Scanner;

class Ejer15{
	public static void main(String[] args){
		int num;
		int lastNum = 0, cont = 0, mayorNumRepet = 0;
		int repet = 1, mayorRepet = 1;
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Dame un valor");
			num = teclado.nextInt();
			if(num != 0){
				cont++;
				if(num == lastNum){
					repet++;
					if(repet > mayorRepet){
						mayorRepet = repet;
						mayorNumRepet = num;
					}
				}
				else{
					repet = 1;
				}
				lastNum = num;
			}
		}while(num != 0);
		teclado.close();
		
		if(cont == 0)
			System.out.println("No has introducido ningun valor");
		else
			System.out.println("Has introducido " + cont + " valores, y de ellos el mayor es " + mayorNumRepet + " con " + mayorRepet + " repeticiones");
	}
}
