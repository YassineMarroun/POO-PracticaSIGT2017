/**
 * @ (#) Comercial.java
 * 
 * Clase Comercial.
 * Es una subclase que hereda de la clase madre Usuario.
 * Representa a los comerciales del taller.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Comercial extends Usuario{
	
	private String puesto;
	
	
	public Comercial (String nombre, Integer telefono, String puesto) {
		
		super(nombre, telefono);
		this.puesto = puesto;
	}

	
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	
	@Override
	public String toString() {
		String datosComercial = super.toString() +
							  "\n Puesto: " + puesto;
		return datosComercial;
	}
}