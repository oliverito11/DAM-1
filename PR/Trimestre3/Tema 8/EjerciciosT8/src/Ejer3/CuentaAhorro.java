package Ejer3;

public class CuentaAhorro extends CuentaCorriente{
	private float interes;
	
	/** CONSTRUCTORES */
	public CuentaAhorro(Titular titular, String numCuenta, float saldo, float interes) {
		super(numCuenta, saldo, titular);
		setInteres(interes);
	}
	
	public CuentaAhorro(Titular titular, String numCuenta, float interes) {
		super(numCuenta, titular);
		setInteres(interes);
	}
	
	public CuentaAhorro(Titular titular, String numCuenta) {
		super(numCuenta, titular);
		interes = 2.5f;
	}
	/******************************************/
	
	/** Incrementar el saldo por el interés */
	public float calcularInteres() {
		return getSaldo() * interes;
	}
	
	/** GETTERS Y SETTERS */
	public void setInteres(float interes) {
		this.interes = interes;
	}
	
	public float getInteres() {
		return interes;
	}
}
