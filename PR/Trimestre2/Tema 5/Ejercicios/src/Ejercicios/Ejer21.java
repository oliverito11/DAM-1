package Ejercicios;

import java.util.Scanner;
public class Ejer21 {
	static final byte CORRECTA = 0;
	static final byte CORTA = -1;
	static final byte DIGITOS = -2;
	static final byte USUARIO_IGUAL_CONTRASENYA = -3;
		
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Usario:\n>");
		String user = teclado.nextLine();
		System.out.print("Contrasenya:\n>");
		String passwd = teclado.nextLine();
		teclado.close();
		
		switch(comprobarCredenciales(user, passwd)) {
			case CORRECTA:
				System.out.println("Login autentificado! Bienvenido");
				break;
			case CORTA:
				System.err.println("La contrasenya ha de tener mas de 6 caracteres");
				break;
			case DIGITOS:
				System.err.println("La contrasenya ha de tener 2 digitos como minimo");
				break;
			case USUARIO_IGUAL_CONTRASENYA:
				System.err.println("La contrasenya no puede ser la misma que el usuario");
				break;
		}
	}
	
	/** Se comprueba la integridad de la contraseña */
	static byte comprobarCredenciales(String user, String passwd) {
		//No deber ser el usuario
		if(passwd.indexOf(user) != -1)
			return USUARIO_IGUAL_CONTRASENYA;
		
		//No puede tener menos de 6 caracteres
		if(passwd.length() < 6)
			return CORTA;
		
		//Al menos dos de ellos han de ser digitos
		int digitos = 0;
		for(int i = 0; i < passwd.length() && digitos < 2; i++){
			if(Character.isDigit(passwd.charAt(i)))
				digitos++;
		}
		
		if(digitos < 2)
			return DIGITOS;
		
		//Llegado a este punto, la contraseña es correcta
		return CORRECTA; 
	}
}
