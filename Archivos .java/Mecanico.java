/**
 * @ (#) Mecanico.java
 * 
 * Clase Mecanico.
 * Es una subclase que hereda de la clase madre Usuario.
 * Representa a un objeto mecanico, recibe a los clientes y abre una ficha.

 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Mecanico extends Usuario{
	
	private String puesto;
	
	
	public Mecanico (String nombre, Integer telefono, String puesto) {
		
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
		String datosMecanico = super.toString() +
							  "\n Puesto: " + puesto;
		return datosMecanico;
	}
}