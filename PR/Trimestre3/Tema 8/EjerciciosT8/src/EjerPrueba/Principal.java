package EjerPrueba;

public class Principal {
	public static void main(String[] args) {
		Movil m = new Movil("Verde", 1, 123.34f, "Samsung");
		Sobremesa pc = new Sobremesa("Negro", 6, 567.45f, Sobremesa.TIPO_G, 2);
		EquipoInformatico m2 = new Movil("Rosa", 1, 456.34f, "Huawei");
		m.encender();
		m.usar();
		pc.encender();
		pc.usar();
		m.foto();
		pc.programar();
		m.apagar();
		pc.apagar();
		m2.encender();
		System.out.println(m);
		System.out.println(m2);
		System.out.println(pc);
	}
}
