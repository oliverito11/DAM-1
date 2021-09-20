import java.util.Scanner;

class Ejer14{
    public static void main(String[] args){
        int num;
        int suma1 = 0, suma2 = 0, cont = 0;
        boolean primeraParte = true;
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("Dame un numero");
            num = teclado.nextInt();
            if(num != 0){
                if(primeraParte){
                    if(num <= 200){
                        suma1 += num;
                        cont++;
                    }
                    else{
                        primeraParte = false;
                    }
                }
                else{
                    suma2 += num;
                    cont++;
                }
            }
        }while(num != 0);
        teclado.close();

        if(cont == 0){
            System.out.println("No has introducido ningun valor");
        }
        else if(suma1 != 0 && suma2 == 0){
            System.out.println("La primera suma es: " + suma1);
            System.out.println("No hay segunda suma");
            System.out.println("Has introducido " + cont + " valores");
        } 
        else if(suma1 == 0 && suma2 != 0){
            System.out.println("No hay primera suma");
            System.out.println("La segunda suma es: " + suma2);
            System.out.println("Has introducido " + cont + " valores");
        }
        else{
            System.out.println("La primera suma es: " + suma1);
            System.out.println("La segunda suma es: " + suma2);
            System.out.println("Has introducido " + cont + " valores");
        }
    }
}
