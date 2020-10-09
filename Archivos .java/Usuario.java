/**
 * @ (#) Usuario.java
 * 
 * Clase Usuario.
 * Es la superclase de la que van a heredar las clases Cliente, Mecanico, Comercial y Jefe.
 * Contiene los atributos que van a ser comunes a todas las subclases.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Usuario {

	protected String nombre;
	protected Integer telefono;
	
	
	public Usuario () {
		
	}
	
	public Usuario (String nombre, Integer telefono) {
		
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getTelefono() {
		return telefono;
	}
	
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	@Override
	public String toString() {
		String datosUsuario = " Nombre: " + nombre +
							  "\n Telefono: " + telefono;
		return datosUsuario;
	}
}