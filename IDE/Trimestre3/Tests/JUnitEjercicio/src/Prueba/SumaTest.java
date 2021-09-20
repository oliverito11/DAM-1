package Prueba;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumaTest{
	@ParameterizedTest
	@CsvSource({"0, 0, 0", "2, 2, 4"})
	public void sumarTest(int a, int b, int valorEsperado) {
		int resultado = new Suma(a, b).sumar();
		assertEquals(resultado, valorEsperado);
	}
}