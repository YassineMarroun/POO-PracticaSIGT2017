/**
 * @ (#) Cliente.java
 * 
 * Clase Cliente.
 * Es una subclase que hereda de la clase madre Usuario.
 * Cliente es el objeto sobre el que se van a realizar los trabajos en GestionTaller.
 * Representa al dueño de uno o varios vehículos, se incluirán en su ArrayList vehiculos.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private String dni;
	private String correo;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Oferta> ofertas;	
	
	
	public Cliente () {
		
	}
	
	public Cliente (String nombre, Integer telefono, String dni, String correo) {		
		super(nombre, telefono);
		this.dni = dni;
		this.correo = correo;
		this.vehiculos = new ArrayList<Vehiculo>();
	}
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
	
	// El método addVehiculo añade un vehiculo a la lista de vehículos de un cliente.
	
	public void addVehiculo(Vehiculo vehiculo) {
		
		this.vehiculos.add(vehiculo);
	}
	

	// Con el método nuevoCliente, obtenemos los datos de un cliente que acude al taller.
	
	public Cliente nuevoCliente() {  	  
	        System.out.print("Introduzca el nombre del Cliente: ");
	        String nombre = Menu.sc.nextLine();
	        System.out.print("Introduzca el Telefono: ");
	        String tfno = Menu.sc.nextLine();
	        Integer telefono = Integer.parseInt(tfno);
	        System.out.print("Introduzca el DNI: ");
	        String dni = Menu.sc.nextLine();
	        System.out.print("Introduzca el correo electronico: ");
	        String correo = Menu.sc.nextLine();
	        Cliente cliente = new Cliente(nombre, telefono, dni, correo);
	        return cliente;       
	}


	// El método enviarOfertas imprime las ofertas que le corresponden a un cliente.
	// Tal como se comenta en el enunciado de la práctica, es una simulación de enviar las ofertas a un cliente.

	public String enviarOfertas(){
	   String enviar = "";
	   enviar = "El cliente " + this.nombre + " con correo " + this.correo;			   
	   if (this.ofertas==null){
		   enviar = enviar + " no tiene ofertas: \n";
	   } else{
		   enviar = enviar + " tiene las ofertas: \n";
		   for (Oferta ofe: this.ofertas){
			   enviar = enviar + ofe.toString();
		   }
	   }
	   return enviar;
	}

	
	@Override
	public String toString() {		
		String datosCliente = super.toString() +
							  "\n DNI: " + dni + 
							   "\n eMail: " + correo + 
							   "\n Vehiculos: " + vehiculos.toString() +
							   "\n tiene Ofertas: ";							 
		if (ofertas==null || ofertas.size()<=0){
			datosCliente = datosCliente + "no";
		} else {
			datosCliente = datosCliente + "si";
		}
		datosCliente = datosCliente + "\n ********** \n ";
		return datosCliente;
	}
}