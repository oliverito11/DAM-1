package Ejer4;

public class Banco {
	private int tiempo;
	private int numVecinos;
	private int numIngresos;
	private int numReintegros;
	private float dineroIngresado;
	private float dineroReintegrado;
	private CuentaAhorro ca;
	private CuentaCorriente cc;
	
	public Banco(CuentaAhorro ca) {
		this.ca = ca;
	}
	
	public Banco(CuentaCorriente cc) {
		this.cc = cc;
	}
	
	public float getBalance() {
		return dineroIngresado - dineroReintegrado;
	}
	
	public float getSaldo() {
		if(ca == null)
			return cc.getSaldo();
		
		return ca.getSaldo();
	}
	public int getTiempoMedia() {
		return tiempo / numVecinos;
	}
	
	/** GETTERS Y SETTERS */
	public void setTiempo(int tiempo) {
		this.tiempo += tiempo;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public void setNumVecinos() {
		this.numVecinos++;
	}
	
	public int getNumVecinos() {
		return numVecinos;
	}
	
	public void setNumIngresos() {
		this.numIngresos++;
	}
	
	public int getNumIngresos() {
		return numIngresos;
	}
	
	public void setNumReintegros() {
		this.numReintegros++;
	}
	
	public int getNumReintegros() {
		return numReintegros;
	}
	
	public void setDineroIngresado(float dineroIngresado) {
		this.dineroIngresado += dineroIngresado;
		if(ca == null)
			cc.ingresar(dineroIngresado);
		else
			ca.ingresar(dineroIngresado);
	}
	
	public float getDineroIngresado() {
		return dineroIngresado;
	}
	
	public void setDineroReintegrado(float dineroReintegrado) {
		this.dineroReintegrado += dineroReintegrado;
		if(ca == null)
			cc.ingresar(dineroReintegrado);
		else
			ca.ingresar(dineroReintegrado);
	}
	
	public float getDineroReintegrado() {
		return dineroReintegrado;
	}
}
