import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {

	@ParameterizedTest
	@CsvSource({"0, 0, 0", "100, 0, 100", "100, 100, 200", "50, 50, 100"})
	void sumarTest(int a, int b, int valorEsperado) {
		Calculadora c = new Calculadora(a, b);
		int resultado = c.sumar();
		assertEquals(valorEsperado, resultado);
	}
	
	@ParameterizedTest
	@CsvSource({"0, 0, 0", "100, 0, 100", "100, 100, 0", "50, 100, 50"})
	void restarTest(int a, int b, int valorEsperado) {
		Calculadora c = new Calculadora(a, b);
		int resultado = c.restar();
		assertEquals(valorEsperado, resultado);
	}
	
	@ParameterizedTest
	@CsvSource({"0, 0, 0", "100, 0, 0", "100, 100, 10000", "50, 50, 2500"})
	void productoTest(int a, int b, int valorEsperado) {
		Calculadora c = new Calculadora(a, b);
		int resultado = c.producto();
		assertEquals(valorEsperado, resultado);
	}
	
	@ParameterizedTest
	@CsvSource({"0, 0, 0", "100, 0, 0", "100, 100, 1", "50, 50, 1", "100, 50, 2"})
	void dividirTest(int a, int b, int valorEsperado) {
		Calculadora c = new Calculadora(a, b);
		int resultado = c.dividir();
		assertEquals(valorEsperado, resultado);
	}
	
	@ParameterizedTest
	@CsvSource({"0, 0, 1", "100, 0, 1", "100, 2, 10000", "50, 4, 6250000"})
	void potenciaTest(int a, int b, int valorEsperado) {
		Calculadora c = new Calculadora(a, b);
		long resultado = c.potencia();
		assertEquals(valorEsperado, resultado);
	}
	
	@ParameterizedTest
	@CsvSource({"0, 1, 0", "100, 2, 10", "50, 3, 1"})
	void raizTest(int a, int b, int valorEsperado) {
		Calculadora c = new Calculadora(a, b);
		long resultado = c.raiz();
		assertEquals(valorEsperado, resultado);
	}
}
