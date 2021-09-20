import java.util.ArrayList;
public class Simbolo {
	private char apertura, cierre;
	
	public Simbolo(char apertura, char cierre) {
		this.apertura = apertura;
		this.cierre = cierre;
	}
	
	public static boolean isApertura(char c, ArrayList<Simbolo> s) {
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).getApertura() == c) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isCierre(char c, ArrayList<Simbolo> s) {
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).getCierre() == c) {
				return true;
			}
		}
		return false;
	}
	
	/** GETTERS Y SETTERS */
	public char getApertura() {
		return apertura;
	}
	
	public char getCierre() {
		return cierre;
	}
}
