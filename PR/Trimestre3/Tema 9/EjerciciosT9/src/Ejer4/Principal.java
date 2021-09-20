package Ejer4;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.LinkedList;
public class Principal {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat(".##");
		LinkedList<Vecino> vecinos = new LinkedList<Vecino>();
		vecinos.add(new Vecino("Nombre1", "Apellido1", 1, 'A'));
		vecinos.add(new Vecino("Nombre2", "Apellido2", 2, 'B'));
		vecinos.add(new Vecino("Nombre3", "Apellido3", 1, 'B'));
		vecinos.add(new Vecino("Nombre4", "Apellido4", 3, 'D'));
		vecinos.add(new Vecino("Nombre5", "Apellido5", 2, 'D'));
		
		CuentaAhorro ca = new CuentaAhorro(new Titular("Comunidad de vecinos"), "12345");
		Banco b = new Banco(ca);
		
		while(!vecinos.isEmpty()) {
			Vecino v = vecinos.poll();
			System.out.println("Atendiendo al vecino " + v.getNombre());
			Random r = new Random();
			
			int tiempo = r.nextInt(5) + 1;
			float dinero = r.nextFloat() * 95 + 5;
			boolean ingresar = r.nextBoolean();
			
			System.out.println("Se ha tardado " + tiempo + " segundos en atender a este vecino.");
			b.setTiempo(tiempo);
			
			if(ingresar) {
				System.out.println("Se va a ingresar " + df.format(dinero)+ "€ en la cuenta.");
				b.setDineroIngresado(dinero);
				b.setNumIngresos();
			}else {
				System.out.println("Se va a reintegrar " + df.format(dinero) + "€ en la cuenta.");
				b.setDineroReintegrado(dinero);
				b.setNumReintegros();
			}
			
			b.setNumVecinos();
			System.out.println();
		}
		System.out.println();
		System.out.println("Se han atendido a " + b.getNumVecinos() + " clientes, donde el tiempo medio de atención es de " + b.getTiempoMedia() + " segundos.");
		System.out.println("El número de ingresos es de " + b.getNumIngresos() + " con un total de " + df.format(b.getDineroIngresado()) + "€ ingresados.");
		System.out.println("El número de reintegros es de " + b.getNumReintegros() + " con un total de " + df.format(b.getDineroReintegrado()) +"€ reintegrados.");
		System.out.println("El balance al final del día es de " + df.format(b.getBalance()) + "€ con un total de " + df.format(b.getSaldo()) + "€ restantes en la cuenta.");
	}
}
