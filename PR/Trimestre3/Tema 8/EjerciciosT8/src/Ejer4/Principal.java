package Ejer4;

public class Principal {
	public static void main(String[] args) {
		Centralita c = new Centralita();
		
		LlamadaLocal lc1 = new LlamadaLocal(666666, 777777, 256);
		c.registrarLlamada(lc1);
		
		LlamadaProvincial lp1 = new LlamadaProvincial(999999, 888888, 987654, 1);
		c.registrarLlamada(lp1);
		
		LlamadaProvincial lp2 = new LlamadaProvincial(999999, 888888, 12, 3);
		c.registrarLlamada(lp2);
		
		c.registroLlamadas();
	}
}
