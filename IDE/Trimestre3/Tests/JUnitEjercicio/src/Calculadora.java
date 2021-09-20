public class Calculadora {
	public int v1, v2;
	
	public Calculadora(int a, int b) {
		v1 = a;
		v2 = b;
	}
	
	public int sumar() {
		return v1 + v2;
	}
	
	public int restar() {
		return v1 - v2;
	}
	
	public int producto() {
		return v1 * v2;
	}

	public int dividir() {
		return v1 / v2;
	}
	
	public long potencia() {
		return (long) Math.pow(v1, v2);
	}
	
	public long raiz() {
		return (long)Math.pow(v1, 1/v2);
	}
}
