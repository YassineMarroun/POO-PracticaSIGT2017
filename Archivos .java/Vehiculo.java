/**
 * @ (#) Vehiculo.java
 * 
 * Clase Vehiculo.
 * Es la superclase de las clases Coche, Moto y VehiculoGrande.
 * Representa a cada uno de los vehículos que entran en el taller.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Vehiculo {
	
	protected String marca;
	protected String modelo;
	protected String matricula;
	protected Enumerados.Combustible combustible;	
	protected String dniCliente;
	private Itv itv;	
	
	
	public Vehiculo () {
		
	}
	
	public Vehiculo (String marca, String modelo, String matricula, Enumerados.Combustible combustible, String dniCliente) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.combustible = combustible;
		this.dniCliente = dniCliente;
		this.itv = new Itv();
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Enumerados.Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Enumerados.Combustible combustible) {
		this.combustible = combustible;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public Itv getItv() {
		return itv;
	}

	public void setItv(Itv itv) {
		this.itv = itv;
	}	

	
	// Con el método nuevoVehiculo obtenemos los datos de un vehículo cuando acude al taller.
	// Se crea una instancia de clase Coche, Moto o VehiculoGrande en función del tipo seleccionado.
	
	public Vehiculo nuevoVehiculo() {
		    System.out.print(Enumerados.menuTiposVehiculos());
			System.out.print("Introduzca el tipo de vehiculo: ");
			Integer tipoVehi = Menu.escanerInt();
			Enumerados.TipoVehiculo enumTv = Enumerados.TipoVehiculo.values()[tipoVehi];
			System.out.print("Introduzca la Marca del vehiculo: ");
			String marca = Menu.sc.nextLine();
			System.out.print("Introduzca el Modelo: ");
			String modelo = Menu.sc.nextLine();
			System.out.print("Introduzca la Matricula: ");
			String matricula = Menu.sc.nextLine();
			System.out.print(Enumerados.menuTiposCombustible());
			System.out.print("Introduzca el tipo de Combustible: ");
			Integer combustible =  Menu.escanerInt();
			Enumerados.Combustible tipoComb = Enumerados.Combustible.values()[combustible];
			System.out.print("Introduzca el dni del cliente: ");
			String dniCliente = Menu.sc.nextLine();
			Vehiculo vehiculo = null;

			if (Enumerados.TipoVehiculo.COCHE.equals(enumTv)){
			    System.out.print(Enumerados.menuTiposCoche());
				System.out.print("Introduzca el tipo de coche: ");
				Integer itc = Menu.sc.nextInt();
				Menu.sc.nextLine(); 
				Enumerados.TipoCoche tipo = Enumerados.TipoCoche.values()[itc];
				vehiculo = new Coche(tipo, marca.trim(), modelo.trim(), matricula.trim(), tipoComb, dniCliente.trim());
			}

			if (Enumerados.TipoVehiculo.MOTO.equals(enumTv)){
			    System.out.print(Enumerados.menuTiposMoto());
				System.out.print("Introduzca el tipo de moto: ");
				Integer itc = Menu.sc.nextInt();
				Menu.sc.nextLine(); 
				Enumerados.TipoMoto tipo = Enumerados.TipoMoto.values()[itc];
				vehiculo = new Moto(tipo, marca.trim(), modelo.trim(), matricula.trim(), tipoComb, dniCliente.trim());
			}
			
			if (Enumerados.TipoVehiculo.GRANDE.equals(enumTv)){
			    System.out.print(Enumerados.menuTiposMoto());
				System.out.print("Introduzca el tipo de vehiculo grande: ");
				Integer itc = Menu.sc.nextInt();
				Menu.sc.nextLine(); 
				Enumerados.TipoGrandes tipo = Enumerados.TipoGrandes.values()[itc];
				vehiculo = new VehiculoGrande(tipo, marca.trim(), modelo.trim(), matricula.trim(), tipoComb, dniCliente.trim());
			}
			return vehiculo;
	}
	

	// Para visualizar los datos de un objeto, en este caso tenemos dos métodos:
	// toStringAmpliado, con el que mostramos todos los atributos de un vehiculo.
	// toString, muestra tres atributos, del que se hace uso cuando queremos listados.
	
	public String toStringAmpliado() {		
		String datos = "\n Marca: " + marca +
							   "\n Modelo: " + modelo +
							   "\n Matricula: " + matricula +
							   "\n Combustible: " + combustible.toString() +
							   "\n a pasar Itv: " + siNo(itv.isaPasarItv()) +  
							   "\n reparado Itv: " + siNo(itv.isReparado()) +  
							   "\n Dni del Cliente: " + dniCliente + 
							   "\n ********** \n ";	
		return datos;
	}
	
	@Override
	public String toString() {		
		String datos = " " + marca + " " + modelo + " " + matricula;	
		return datos;
	}
	
	
	// El método siNo tiene la función de devolver un Si o un No según el valor del parámetro boolean recibido.
	// Con ello visualizamos en el toStringAmpliado el valor que devuelven isaPasarItv e isReparado.
	
	private String siNo(Boolean tipoBool){
		if (tipoBool){
			return "Si";
		} else {
			return "No";
		}
	}
}