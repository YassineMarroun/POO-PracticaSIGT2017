/**
 * @ (#) Jefe.java
 * 
 * Clase Jefe.
 * Es una subclase que hereda de la clase madre Usuario.
 * Representa al jefe del taller.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Jefe extends Usuario{
	
	private String puesto;
	
	
	public Jefe (String nombre, Integer telefono, String puesto) {
		
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
		String datosJefe = super.toString() +
							  "\n Puesto: " + puesto;
		return datosJefe;
	}
}