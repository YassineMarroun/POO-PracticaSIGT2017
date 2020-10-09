/**
 * @ (#) GestionTaller.java
 * 
 * Clase GestionTaller.
 * Esta clase va a gestionar el conjunto de objetos de las clases Vehiculo, Mecanico, Cliente, Ficha y Oferta.
 * Por tanto, los atributos de esta clase son:
 * De tipo ArrayList: vehiculos y mecanicos.
 * De tipo HashMap: clientes, fichas y ofertas.
 * Se han elegido dos tipos de colecciones para trabajar diferentes estructuras. 
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.util.*;

public class GestionTaller {

	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private List<Mecanico> mecanicos = new ArrayList<Mecanico>();
	private Map<String, Cliente> clientes = new HashMap<String, Cliente>();
	private Map<Integer, Ficha>  fichas =  new HashMap<Integer, Ficha> ();
	private Map<String, Oferta>  ofertas =  new HashMap<String, Oferta> ();

	
	// Hacemos uso del método createDatosInicialesPruebas para añadir una serie de objetos
	// de las clases mencionadas a sus correspondientes listas y mapas.
	// Es de utilidad para realizar pruebas haciendo diferentes selecciones en el menú.
	
	public void createDatosInicialesPruebas() {
		
	//  Comercial comercial1 = new Comercial ("Susana Oliver", 625483275, "Comercial Primero.");
	//	Jefe jefe1 = new Jefe ("Victor Machado", 633144895, "Gerente.");
		Mecanico mecanico1 = new Mecanico ("Jorge Garrido", 645786329, "Primer Mecanico.");
	    Mecanico mecanico2 = new Mecanico ("Carlos Bueno", 685147956, "Segundo Mecanico.");
	    Mecanico mecanico3 = new Mecanico ("Sergio Ibaiz", 654359624, "Tercer Mecanico.");
        mecanicos.add(mecanico1);
        mecanicos.add(mecanico2);
        mecanicos.add(mecanico3);
	    
		Cliente cliente1 = new Cliente("Pedro", 632012587, "2453175S", "pedro@tal");
		Cliente cliente2 = new Cliente("Isabel", 693214758, "3785425A", "isa@tal");
		Cliente cliente3 = new Cliente("Daniel", 630247852, "41236984H", "dani@tal");
		Cliente cliente4 = new Cliente("Juan", 916325748, "75216235P", "juan@tal");

		Coche vehiculo1 = new Coche(Enumerados.TipoCoche.TURISMO, "Opel", "Astra", "1128DFT", Enumerados.Combustible.DIESEL, "2453175S");
		Coche vehiculo2 = new Coche(Enumerados.TipoCoche.MONOVOLUMEN, "Seat", "Toledo", "3378ERD", Enumerados.Combustible.DIESEL, "2453175S");
		VehiculoGrande vehiculo3 = new VehiculoGrande(Enumerados.TipoGrandes.FURGONETA, "BMW", "X5", "8756FTP", Enumerados.Combustible.GASOLINA, "41236984H");
		Moto vehiculo4 = new Moto(Enumerados.TipoMoto.DE_CARRETERA, "Kawassaki", "500", "9620GEA", Enumerados.Combustible.GASOLINA, "3785425A");
		Coche vehiculo5 = new Coche(Enumerados.TipoCoche.VEHICULO_PROFESIONAL, "Ambulancia", "PequeÃ±a", "4875DER", Enumerados.Combustible.GASOLINA, "3785425A");		

		vehiculos.add(vehiculo1);
		vehiculos.add(vehiculo2);
		vehiculos.add(vehiculo3);
		vehiculos.add(vehiculo4);
		vehiculos.add(vehiculo5);
		
		cliente1.addVehiculo(vehiculo1);
		cliente1.addVehiculo(vehiculo2);
		cliente3.addVehiculo(vehiculo3);
		cliente2.addVehiculo(vehiculo4);
		cliente2.addVehiculo(vehiculo5);
		
		clientes.put("2453175S", cliente1);
		clientes.put("3785425A", cliente2);
		clientes.put("41236984H", cliente3);
		clientes.put("75216235P", cliente4);
		
		ArrayList<Trabajo> trabs = new ArrayList<Trabajo>();
		trabs.add(new Trabajo(Enumerados.MotivoVisita.MOTOR));
		Ficha ficha1 = new Ficha(1,"8756FTP", "Jorge Garrido", trabs);
		
		fichas.put(1, ficha1);
		
		ArrayList<Oferta> oferts = new ArrayList<Oferta>();
		Oferta oferta1 = new Oferta("ofe1", Enumerados.TipoOferta.CAMBIO_DE_ACEITE, 15);
        oferts.add(oferta1);
		cliente1.setOfertas(oferts);
		cliente2.setOfertas(oferts);
		
		ofertas.put("ofe1", oferta1);
	}

	
	/*
	 Métodos para gestionar objetos de la clase Vehiculo.
	 */
	
	// El método crearVehiculo crea el objeto vehiculo, le asigna los datos obtenidos con el método nuevoVehiculo,
	// lo añade al ArrayList vehiculos y, por último, con el dni localiza al cliente en el mapa de clientes
	// y con addVehiculo lo asigna a la lista de vehículos de dicho cliente.
 
	public void crearVehiculo(){
		  Vehiculo vehiculo = new Vehiculo();
		  vehiculo = vehiculo.nuevoVehiculo();
		  if (vehiculo!=null){
			  vehiculos.add(vehiculo);
		      Cliente cl = clientes.get(vehiculo.getDniCliente());
		      if (cl!=null){
		        cl.addVehiculo(vehiculo);
		      }
		  } else{
			  System.out.print("Fallo dando de alta un vehiculo");
		  }
	}
	
	
	// El método buscarVehiculoPantalla nos pide que le demos por teclado una matricula,
	// se la pasa como parámetro a buscarVehiculo e imprime en pantalla los datos del vehiculo que le devuelve.
	
	public void buscarVehiculoPantalla(){
        String matricula;
        System.out.print("Buscar Vehiculo por Matricula: ");
        matricula = Menu.sc.nextLine();
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo!=null){
        	System.out.println(vehiculo.toString());
        } else{
        	System.out.println("vehiculo no existe");
        }
    } 
	
	
	// El método buscarVehiculo recibe una variable matricula, recorre el ArrayList vehiculos
	// y devuelve el objeto vehiculo que localice con dicha matricula.
	
	public Vehiculo  buscarVehiculo(String matricula){
        for(int i = 0; i < vehiculos.size(); i++){	
            if(vehiculos.get(i).getMatricula().equals(matricula)){
            	return vehiculos.get(i);
            }
            	
        }
        return null;
	}
	
	
	// El método eliminarVehiculo nos pide una matricula, hace uso de dicha variable
	// para recorrer el ArrayList vehiculos y elimina el objeto vehiculo que localice con dicha matricula.
	
	public void eliminarVehiculo() {
		Scanner sc = new Scanner(System.in);
        String matricula;
        System.out.print("Eliminar Vehiculo por Matricula: ");
        matricula = sc.nextLine();
		
		for(int i = 0; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getMatricula().equals(matricula)) {
				vehiculos.remove(i);
			}
		}
		sc.close();
	}
	
	
	// El método listarVehiculos muestra en pantalla todos los elementos que tengamos en el ArrayList vehiculos.
	
	public void listarVehiculos() {			
		System.out.println("Listado de vehiculos.");
		for(Vehiculo vhi: vehiculos) {
			System.out.println(vhi.toStringAmpliado());        
		}
	}
	
	
	/*
	 Métodos para gestionar objetos de la clase Cliente.
	 */
	
	// El método crearCliente crea un objeto cliente, le asigna los datos obtenidos mediante
	// el método nuevoCliente y se lo pasa como parámetro a guardarCliente,
	// que es donde se va a incluir en el mapa de clientes.
	
	public void crearCliente(){
		
		Cliente cliente = new Cliente();		
		cliente = cliente.nuevoCliente();
		guardarCliente(cliente);
		
	}
	
	
	// El método buscarClientePantalla nos pide que le demos por teclado un dni,
	// se lo pasa como parámetro a buscarCliente e imprime en pantalla el objeto cliente que le devuelve.
	
	public void buscarClientePantalla(){
        String dni;
        System.out.print("Buscar Cliente por dni: ");
        dni = Menu.sc.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente!=null){
        	System.out.println(cliente.toString());
        } else{
        	System.out.println("cliente no existe");
        }
    } 
	
	
	// El método buscarCliente devuelve del HashMap clientes el objeto cliente con el que coincida
	// el dni que se le ha pasado como parámetro.
	
	public Cliente buscarCliente(String dni){		
		return clientes.get(dni);
	}

	
	// El método guardarCliente hace uso del dni para comprobar si existe el objeto cliente,
	// si ya existe nos da un mensaje de error y si no es así, lo añade al HashMap clientes.
	
	public void guardarCliente(Cliente cliente){		
		Cliente cl = clientes.get(cliente.getDni());
		if (cl != null) {
			System.out.println("No se puede introducir el Cliente. Ya esta registrado.");
		} else {
			clientes.put(cliente.getDni(), cliente);
		}
	}

	
	// El método eliminarCliente elimina el objeto cliente con el que coincida
	// el dni que se le ha pasado como parámetro.
	
	public void eliminarCliente(String dni) {       
        clientes.remove(dni);
	}

	
	// El método listarClientes simplemente muestra en pantalla los elementos que tengamos en el HashMap clientes.
	
	public void listarClientes(){
		for (Cliente cl : clientes.values()) {
			System.out.println(cl.toString());
		}
	}
	

	/*
	 Métodos para gestionar objetos de la clase Ficha.
	 */
	
	// El método getNumNuevaFicha obtiene el total de fichas que tenemos en el HashMap fichas y le suma uno.
	
	public int getNumNuevaFicha() {
		if (fichas!=null && fichas.size()>0){
	       return fichas.size() + 1;
		}else{
		   return 1;
		}
	}
	
	
	// El método altaFichas crea una nueva ficha con el número recibido en el parámetro nuevoNumero
	// y los datos obtenidos por el método nuevaFicha.
	
	public void altaFichas(Integer nuevoNumero){
		  Ficha ficha = new Ficha();
		  ficha = ficha.nuevaFicha(nuevoNumero);
		  if (ficha!=null){
			  guardarDatosFicha(nuevoNumero, ficha);
		  }
	}
	
	
	// modificarFicha recibe un número de ficha, si no existe ficha con dicho número da un mensaje de error,
	// y si existe, muestra los datos de la ficha a modificar y solicita los nuevos datos de trabajos a realizar,
	// estado en el que se encuentra y si está Terminado, solicita la fecha. Con esos datos guarda
	// una nueva ficha que sustituye la anterior en el mapa de fichas con el mismo número de ficha.
	
	public void modificarFicha(Integer numFic){
	   Ficha fichaAnt = fichas.get(numFic);
	   Ficha fichaNueva = null;
	   if (fichaAnt!=null){
			fichaNueva = fichaAnt.modificarFicha(fichaAnt);
	   } else{
			System.out.println("Numero de ficha inexistente");	
	   }
	   if (fichaNueva!=null){
		   guardarDatosFicha(numFic, fichaNueva);
	   }
	}
	
	
	// El método guardarDatosFicha va a comprobar si por las características del vehiculo
	// hay que asignarle algún trabajo más. Por ejemplo, si en su atributo de tipo enumerado Combustible
	// hemos guardado que es un vehículo diésel, se le añade la revisión del filtro de partículas.
	// Tras los cambios añade la ficha al mapa y la imprime en pantalla.
	
	private void guardarDatosFicha(Integer numFic, Ficha ficha){
		  String matricula = ficha.getMatricula();
		  Vehiculo vehi = buscarVehiculo(matricula);
		  if (vehi!=null){
			  Trabajo trab;
			  if (vehi instanceof Moto){
				  trab = new Trabajo(Enumerados.MotivoVisita.PRESION_NEUMATICOS);
				  ficha.getTrabajos().add(trab);
			  }
			  if (vehi instanceof Coche){
				  Coche coche = (Coche) vehi;
				  if (coche.getTipoCoche().equals(Enumerados.TipoCoche.VEHICULO_PROFESIONAL)){
					  trab = new Trabajo(Enumerados.MotivoVisita.SIRENAS);
					  ficha.getTrabajos().add(trab);
				  }
			  }
			  if (vehi.getCombustible().equals(Enumerados.Combustible.DIESEL)){
				  trab = new Trabajo(Enumerados.MotivoVisita.FILTRO_PARTICULAS);
				  ficha.getTrabajos().add(trab);
			  }
			  fichas.put(numFic, ficha);
			  System.out.println(ficha.toStringReducido());
		  } else{
			  System.out.println("La matricula grabada en la ficha no existe. Dar de alta el vehiculo");
		  }
	}
	
	
	// El método visualizaFichasTodas simplemente imprime en pantalla todos los elementos
	// que tenemos en el HashMap fichas.
	
	public void visualizaFichasTodas() {
		System.out.println("Listado de fichas.");
		for(Ficha fic: fichas.values()) {
			System.out.println(fic.toStringReducido());        
		}
	}
	
	
	// El método visualizaFichasMecanico recorre el mapa de fichas comparando el nombre del mecánico
	// de cada ficha con el nombre del mecánico pasado en el parámetro, en el caso de coincidir,
	// imprime esa ficha. Cada vez que coincide el nombre, imprime esa ficha.

	public void visualizaFichasMecanico(String nomMecanico) {
		boolean existe = false;
		System.out.println("Listado de fichas del mecanico: " + nomMecanico);
		for(Ficha fic: fichas.values()) {
			if (fic.getNombreMecanico().equals(nomMecanico)){
				System.out.println(fic.toString());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen fichas de este mecanico");		
		}
	}
	

	// visualizaFichasEstado realiza una búsqueda en el HashMap fichas e imprime en pantalla
	// aquellas en las que coincide su estado con el que le hemos pasado como parámetro al método.
	// En el enunciado se pedía que se mostrasen las fichas que se encuentren en estado Parado,
	// pero con este método podemos mostrar las fichas que se encuentre en el estado que seleccionemos.

	public void visualizaFichasEstado(Enumerados.EstadoReparacion estado) {
		boolean existe = false;
		System.out.println("Listado de fichas en estado: " + estado.toString());
		for(Ficha fic: fichas.values()) {
			if (fic.getEstado().equals(estado)){
				System.out.println(fic.toStringReducido());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen fichas en este estado");		
		}
	}


	// El método fichasEntreFechas va a solicitar dos fechas mediante el método darFechaConsola,
	// y recorriendo el mapa de fichas imprime en pantalla todas aquellas fichas en las que
	// el método entrefechas es true. Si no existe ninguna, daría el mensaje de que no existen fichas.
	
	public void fichasEntreFechas() {
		Ficha ficFec = new Ficha();
		Calendar fecha1 = ficFec.darFechaConsola();
		Calendar fecha2 = ficFec.darFechaConsola();
		boolean existe = false;
		if (fecha1!=null && fecha2!=null){	
			System.out.println("Listado de fichas reparadas entre fechas: " + fecha1.getTime() + " y " + fecha2.getTime());
			for(Ficha fic: fichas.values()) {
				if (fic.entreFechas(fic.getFechaReparacion(), fecha1, fecha2)){
					System.out.println(fic.toStringReducido());
					existe = true;
				}
			}
		}
		if (!existe){
			System.out.println("No existen fichas reparadas entre esas fechas");		
		}
	}
	
	
	// El método asignarFichaAMecanico recibe como parámetros las variables numFicha y nombreMecanico.
	// Si el método buscarMecanico le devuelve que existe un objeto mecanico con ese mismo nombreMecanico,
	// le asigna ese dato al atributo nombreMecanico de la ficha indicada por la variable numFicha.
	
	public void asignarFichaAMecanico(Integer numFicha, String nombreMecanico){
		Ficha ficha = fichas.get(numFicha);
		Boolean existe = false;
		if (ficha!=null){
			existe = buscarMecanico(nombreMecanico);
			if (existe){
				ficha.setNombreMecanico(nombreMecanico);
			} else{
				System.out.println("No existe el mecanico: " + nombreMecanico);
			}
		} else {
			System.out.println("No existe la ficha: " + numFicha);
		}
	}
	
	
	// El método getFicha recibe un numFicha y devuelve el objeto ficha con el que coincida del HashMap fichas.
	
	public Ficha getFicha(Integer numFicha){
		return fichas.get(numFicha);
	}

	
	/*
	 Método para gestionar objetos de la clase Usuario.
	 */
	
	// El método buscarMecanico es de tipo boolean y únicamente devuelve true o false si localiza o no
	// un objeto mecanico mediante la variable nombreMecanico que le hemos pasado.
	
	private Boolean buscarMecanico(String nombreMecanico){
		Boolean existe = false;
		for (Mecanico mec: mecanicos){
			if (mec.nombre.equals(nombreMecanico)){
				existe = true;
				break;
			}
		}
		return existe;
	}
	
	
	/*
	 Métodos para gestionar objetos de la clase Oferta.
	 */
	
	// El método crearOferta crea un objeto oferta, le asigna los datos que devuelve el método nuevaOferta
	// y guarda dicho objeto en el HashMap ofertas.
	
	public void crearOferta(){
		Oferta oferta = new Oferta();
		oferta = oferta.nuevaOferta();
		ofertas.put(oferta.getDescripcion(), oferta);
	}
	
	
	// El método ofertaACliente pide los datos dni y descripción, con ello localiza los objetos cliente y oferta.
	// Incluye la oferta al correspondiente ArrayList del cliente si el método noOfertada le ha devuelto
	// que no lo estaba ya. Por último, le da fecha a la oferta cuando es presentada si el método haPasadounAnno
	// le devuelve que ha sido presentada hace más de un año.
	
	public void ofertaACliente(){
		System.out.println("Dni cliente: ");
		String dni = Menu.sc.nextLine();
		System.out.println("Descripcion oferta: ");
		String desc = Menu.sc.nextLine();
		Cliente cl = clientes.get(dni);
		Oferta ofe = ofertas.get(desc);
		if (cl != null && ofe !=null){
			Oferta yaOfertada = noOfertada(cl, ofe);           
			if (yaOfertada == null){
				if (cl.getOfertas()==null){
					cl.setOfertas(new ArrayList<Oferta>());
				}
		        cl.getOfertas().add(ofe);	
			} else{
				if (haPasadounAnno(yaOfertada)){
					yaOfertada.setFechaPresentada(Calendar.getInstance());					
				} else{
					System.out.println("Oferta ya presentada hace menos de un anno");
				}
			}
		} else{
			System.out.println("No existe cliente u oferta");
		}
	}
	
	
	// El método noOfertada comprueba, mediante la variable descripcion, si un objeto oferta
	// se encuentra en el ArrayList ofertas de un cliente.
	
	private Oferta noOfertada(Cliente cl, Oferta ofe){
		if (cl.getOfertas()==null){
			return null;			
		}
		for (Oferta ofeCl: cl.getOfertas()){
			if (ofeCl.getDescripcion().equals(ofe.getDescripcion())){				
				 return ofeCl;
				}
		}
		return null;
	}
	
	
	// El método haPasadounAnno es de tipo boolean, comprueba con el atributo FechaPresentada
	// si una oferta ha sido presentada hace menos de un año, y devuelve true o false.
	
	private Boolean haPasadounAnno(Oferta yaOfertada){		
	    Calendar haceUnAnno = Calendar.getInstance();
	    haceUnAnno.add(Calendar.YEAR, -1);
		if (yaOfertada.getFechaPresentada() == null || yaOfertada.getFechaPresentada().before(haceUnAnno)){	
			return true;
		}
		return false;
	}
	
	
	// El método enviarOfertas recorre el HashMap clientes y a cada elemento le aplica el método enviarOfertas
	// de la clase Cliente, que imprime los datos de las ofertas de cada cliente
	// incluidas en su ArrayList ofertas.
	
	public void enviarOfertas(){
		for (Cliente cl: clientes.values()){
			System.out.println(cl.enviarOfertas());
		}
	}
	
	
	// El método pasarItv solicita una matricula para localizar un objeto vehiculo, comprueba
	// si está pasando la ITV, y si no es así, le da valor true a la variable de tipo boolean aPasarItv.
	// Si ya está pasando la ITV, muestra el mensaje de que la está pasando. 
	
	public void pasarItv(){
        String matricula;
        System.out.print("Matricula a pasar Itv: ");
        matricula = Menu.sc.nextLine();
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo!=null){
        	if (vehiculo.getItv()!=null && vehiculo.getItv().isaPasarItv()){
        		System.out.println("Vehiculo ya esta pasando la itv");
        	} else{
        		vehiculo.getItv().setaPasarItv(true);
        	}
        } else{
        	System.out.println("Vehiculo no existe");
        }
	}
	
	
	// El método modificarEstadoItv solicita una matricula para localizar un objeto vehiculo, comprueba
	// si está pasando la ITV, y si es así, solicita indicar los trabajos realizados o pendientes de realizar
	// para incluirlos en el ArrayList de clase Trabajo.
	
	public void modificarEstadoItv(){
        String matricula;
        System.out.print("Matricula a modificar estado Itv: ");
        matricula = Menu.sc.nextLine();
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo!=null){
        	Itv vhItv = vehiculo.getItv();
        	if (vhItv==null || !vehiculo.getItv().isaPasarItv()){
        		System.out.println("Vehiculo no esta pasando la itv. Dar de alta en Itv");
        	} else{
                System.out.print(Enumerados.menuMotivosVisita() + "\n");
                System.out.print("Introduzca numero de trabajos marcados en la Itv separados por blanco: ");
                String trbMenu = Menu.sc.nextLine();
                ArrayList<Trabajo> trbLista = Enumerados.setArrayTrabajos(trbMenu);
                vhItv.setaReparar(trbLista);
                System.out.print("Indique si ya estan reparados. 0.No reparado 1.Reparado");
                Integer reparado = Menu.sc.nextInt();
                if (reparado>0){
                    vhItv.setReparado(true);
                } else{
                	vhItv.setReparado(false);
                }
        	}
        } else{
        	System.out.println("Vehiculo no existe");
        }
	}	
}