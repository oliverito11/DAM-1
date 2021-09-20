public class Asignatura {
	private String nombreAsig, nombreProfe;
	private float horasSemanales, nota;
	
	public Asignatura (String nAsig, String nProfe, float horas, float not){
		setNombreAsig(nAsig);
		setNombreProfe(nProfe);
		setHorasSemanales(horas);
		setNota(not);
	}
	
	@Override
	public String toString(){
		return "Nombre de la asignatura: " + getNombreAsig() + "\nNombre del profesor: " + getNombreProfe() + "\nHoras semanales: " + getHorasSemanales() + "\nNota: " + getNota();
	}
	
	//GETTERS Y SETTERS
	public void setNombreAsig(String nAsig){
		nombreAsig = nAsig;
	}
	
	public String getNombreAsig(){
		return nombreAsig;
	}
	
	public void setNombreProfe(String nProfe){
		nombreProfe = nProfe;
	}
	
	public String getNombreProfe(){
		return nombreProfe;
	}
	
	public void setHorasSemanales(float horas){
		horasSemanales = horas;
	}
	
	public float getHorasSemanales(){
		return horasSemanales;
	}
	
	public void setNota(float not){
		nota = not;
	}
	
	public float getNota(){
		return nota;
	}
}
