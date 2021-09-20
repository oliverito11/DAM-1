package Ejer4;

public class CuentaCorriente {
	private String numCuenta;
	private float saldo;
	private Titular titular;
	
	/** CONSTRUCTORES */
	public CuentaCorriente(String numCuenta, float saldo, Titular titular) {
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public CuentaCorriente(String numCuenta, Titular titular) {
		this.numCuenta = numCuenta;
		this.saldo = 15.3f;
		this.titular = titular;
	}
	/******************************************/
	
	/** Aumentar el saldo */
	public void ingresar(float saldo) {
		if(saldo > 0)
			setSaldo(saldo);
		else
			System.out.println("No se admiten números negativos.");
	}
	
	/** Disminuir el saldo */
	public void reintegro(float saldo) {
		if(saldo > 0) {
			if(this.saldo - saldo < 0)
				System.out.println("No tienes suficiente dinero");
			else
				setSaldo(-saldo);
		}
		else
			System.out.println("No se admiten números negativos.");
	}
	
	/** Mostrar número de cuenta y su saldo */
	public void imprimirCuenta() {
		System.out.println("Número de cuenta: " + getNumCuenta() + "\nSaldo: " + getSaldo());
	}
	
	/** Se compara el saldo de dos cuentas, habiendo comprobado antes que son distintas */
	public void compararCuentas(CuentaCorriente cc1, CuentaCorriente cc2) {
		if(cc1.getNumCuenta().equals(cc2.getNumCuenta()))
			System.out.println("Ambas cuentas son iguales.");
		else
			System.out.println("Diferencia de saldo de las cuentas: " + (cc1.getSaldo() > cc2.getSaldo() ? cc1.getSaldo() - cc2.getSaldo() : cc2.getSaldo() - cc1.getSaldo()));
	}
	
	/** GETTERS Y SETTERS */
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public Titular getTitular() {
		return titular;
	}
}
