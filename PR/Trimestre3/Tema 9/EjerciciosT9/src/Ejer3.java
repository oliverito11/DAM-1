/**
 * Se pasará un fichero a este compilador e irá recorriendo línea por línea para
 * comprobar la compensación de paréntesis, corchetes y llaves
 * */

import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
public class Ejer3 {
	public static void main(String[] args) {
		//Comprobación de argumentos
		if(args.length != 1) {
			System.err.println("Uso correcto del programa: java Ejer3 <fichero>");
			return;
		}
		
		File f = new File(args[0]);
		if(!f.exists() || !f.isFile()) {
			System.err.println("El fichero no existe o es un directorio");
			return;
		}
		
		//Símbolos que de apertura y cierre
		Simbolo parentesis = new Simbolo('(', ')');
		Simbolo corchetes = new Simbolo('[', ']');
		Simbolo llaves = new Simbolo('{', '}');
		
		//Estructura que almacenará los símbolos
		ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
		
		simbolos.add(parentesis);
		simbolos.add(corchetes);
		simbolos.add(llaves);
		
		
		//Llamada al compilador
		if(compilador(f, simbolos)) {
			System.out.println("Fichero correcto.");
		}else {
			System.out.println("Error en el fichero.");
		}
	}
	
	static boolean compilador(File f, ArrayList<Simbolo> simbolos) {
		boolean resultado = true;
		BufferedReader br = null;
		Stack<Character> pila = new Stack<Character>();
		
		try {
			br = new BufferedReader(new FileReader(f));
			String linea = "";
			int count = 1;		//Contador para mostrar la línea en la que dió error el programa
			while((linea = br.readLine()) != null) {
				for(int i = 0; i < linea.length(); i++) {
					//¿Es de apertura?
					if(Simbolo.isApertura(linea.charAt(i), simbolos)) {
						pila.push(linea.charAt(i));
					}
					//¿Es de cierre?
					else if (Simbolo.isCierre(linea.charAt(i), simbolos)) {
						//Si la pila está vacía, quiere decir que no hay ninguna apertura más y será un error
						if(pila.isEmpty())
							resultado = false;
						else {
							//Comparamos los simbolos con los correctos
							Simbolo comp = new Simbolo(pila.pop(), linea.charAt(i));
							
							for(int k = 0; k < simbolos.size(); k++) {
								if(comp.getApertura() == simbolos.get(k).getApertura() && comp.getCierre() == simbolos.get(k).getCierre()) {
									resultado = true;
									break;
								}else
									resultado = false;
							}							
						}
					}
					if(!resultado) {
						System.out.println("Línea " + count + ": " + linea);
						return false;
					}
				}
				count++;
			}
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
}
