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

	
	// Hacemos uso del m�todo createDatosInicialesPruebas para a�adir una serie de objetos
	// de las clases mencionadas a sus correspondientes listas y mapas.
	// Es de utilidad para realizar pruebas haciendo diferentes selecciones en el men�.
	
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
		Coche vehiculo5 = new Coche(Enumerados.TipoCoche.VEHICULO_PROFESIONAL, "Ambulancia", "Pequeña", "4875DER", Enumerados.Combustible.GASOLINA, "3785425A");		

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
	 M�todos para gestionar objetos de la clase Vehiculo.
	 */
	
	// El m�todo crearVehiculo crea el objeto vehiculo, le asigna los datos obtenidos con el m�todo nuevoVehiculo,
	// lo a�ade al ArrayList vehiculos y, por �ltimo, con el dni localiza al cliente en el mapa de clientes
	// y con addVehiculo lo asigna a la lista de veh�culos de dicho cliente.
 
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
	
	
	// El m�todo buscarVehiculoPantalla nos pide que le demos por teclado una matricula,
	// se la pasa como par�metro a buscarVehiculo e imprime en pantalla los datos del vehiculo que le devuelve.
	
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
	
	
	// El m�todo buscarVehiculo recibe una variable matricula, recorre el ArrayList vehiculos
	// y devuelve el objeto vehiculo que localice con dicha matricula.
	
	public Vehiculo  buscarVehiculo(String matricula){
        for(int i = 0; i < vehiculos.size(); i++){	
            if(vehiculos.get(i).getMatricula().equals(matricula)){
            	return vehiculos.get(i);
            }
            	
        }
        return null;
	}
	
	
	// El m�todo eliminarVehiculo nos pide una matricula, hace uso de dicha variable
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
	
	
	// El m�todo listarVehiculos muestra en pantalla todos los elementos que tengamos en el ArrayList vehiculos.
	
	public void listarVehiculos() {			
		System.out.println("Listado de vehiculos.");
		for(Vehiculo vhi: vehiculos) {
			System.out.println(vhi.toStringAmpliado());        
		}
	}
	
	
	/*
	 M�todos para gestionar objetos de la clase Cliente.
	 */
	
	// El m�todo crearCliente crea un objeto cliente, le asigna los datos obtenidos mediante
	// el m�todo nuevoCliente y se lo pasa como par�metro a guardarCliente,
	// que es donde se va a incluir en el mapa de clientes.
	
	public void crearCliente(){
		
		Cliente cliente = new Cliente();		
		cliente = cliente.nuevoCliente();
		guardarCliente(cliente);
		
	}
	
	
	// El m�todo buscarClientePantalla nos pide que le demos por teclado un dni,
	// se lo pasa como par�metro a buscarCliente e imprime en pantalla el objeto cliente que le devuelve.
	
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
	
	
	// El m�todo buscarCliente devuelve del HashMap clientes el objeto cliente con el que coincida
	// el dni que se le ha pasado como par�metro.
	
	public Cliente buscarCliente(String dni){		
		return clientes.get(dni);
	}

	
	// El m�todo guardarCliente hace uso del dni para comprobar si existe el objeto cliente,
	// si ya existe nos da un mensaje de error y si no es as�, lo a�ade al HashMap clientes.
	
	public void guardarCliente(Cliente cliente){		
		Cliente cl = clientes.get(cliente.getDni());
		if (cl != null) {
			System.out.println("No se puede introducir el Cliente. Ya esta registrado.");
		} else {
			clientes.put(cliente.getDni(), cliente);
		}
	}

	
	// El m�todo eliminarCliente elimina el objeto cliente con el que coincida
	// el dni que se le ha pasado como par�metro.
	
	public void eliminarCliente(String dni) {       
        clientes.remove(dni);
	}

	
	// El m�todo listarClientes simplemente muestra en pantalla los elementos que tengamos en el HashMap clientes.
	
	public void listarClientes(){
		for (Cliente cl : clientes.values()) {
			System.out.println(cl.toString());
		}
	}
	

	/*
	 M�todos para gestionar objetos de la clase Ficha.
	 */
	
	// El m�todo getNumNuevaFicha obtiene el total de fichas que tenemos en el HashMap fichas y le suma uno.
	
	public int getNumNuevaFicha() {
		if (fichas!=null && fichas.size()>0){
	       return fichas.size() + 1;
		}else{
		   return 1;
		}
	}
	
	
	// El m�todo altaFichas crea una nueva ficha con el n�mero recibido en el par�metro nuevoNumero
	// y los datos obtenidos por el m�todo nuevaFicha.
	
	public void altaFichas(Integer nuevoNumero){
		  Ficha ficha = new Ficha();
		  ficha = ficha.nuevaFicha(nuevoNumero);
		  if (ficha!=null){
			  guardarDatosFicha(nuevoNumero, ficha);
		  }
	}
	
	
	// modificarFicha recibe un n�mero de ficha, si no existe ficha con dicho n�mero da un mensaje de error,
	// y si existe, muestra los datos de la ficha a modificar y solicita los nuevos datos de trabajos a realizar,
	// estado en el que se encuentra y si est� Terminado, solicita la fecha. Con esos datos guarda
	// una nueva ficha que sustituye la anterior en el mapa de fichas con el mismo n�mero de ficha.
	
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
	
	
	// El m�todo guardarDatosFicha va a comprobar si por las caracter�sticas del vehiculo
	// hay que asignarle alg�n trabajo m�s. Por ejemplo, si en su atributo de tipo enumerado Combustible
	// hemos guardado que es un veh�culo di�sel, se le a�ade la revisi�n del filtro de part�culas.
	// Tras los cambios a�ade la ficha al mapa y la imprime en pantalla.
	
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
	
	
	// El m�todo visualizaFichasTodas simplemente imprime en pantalla todos los elementos
	// que tenemos en el HashMap fichas.
	
	public void visualizaFichasTodas() {
		System.out.println("Listado de fichas.");
		for(Ficha fic: fichas.values()) {
			System.out.println(fic.toStringReducido());        
		}
	}
	
	
	// El m�todo visualizaFichasMecanico recorre el mapa de fichas comparando el nombre del mec�nico
	// de cada ficha con el nombre del mec�nico pasado en el par�metro, en el caso de coincidir,
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
	

	// visualizaFichasEstado realiza una b�squeda en el HashMap fichas e imprime en pantalla
	// aquellas en las que coincide su estado con el que le hemos pasado como par�metro al m�todo.
	// En el enunciado se ped�a que se mostrasen las fichas que se encuentren en estado Parado,
	// pero con este m�todo podemos mostrar las fichas que se encuentre en el estado que seleccionemos.

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


	// El m�todo fichasEntreFechas va a solicitar dos fechas mediante el m�todo darFechaConsola,
	// y recorriendo el mapa de fichas imprime en pantalla todas aquellas fichas en las que
	// el m�todo entrefechas es true. Si no existe ninguna, dar�a el mensaje de que no existen fichas.
	
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
	
	
	// El m�todo asignarFichaAMecanico recibe como par�metros las variables numFicha y nombreMecanico.
	// Si el m�todo buscarMecanico le devuelve que existe un objeto mecanico con ese mismo nombreMecanico,
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
	
	
	// El m�todo getFicha recibe un numFicha y devuelve el objeto ficha con el que coincida del HashMap fichas.
	
	public Ficha getFicha(Integer numFicha){
		return fichas.get(numFicha);
	}

	
	/*
	 M�todo para gestionar objetos de la clase Usuario.
	 */
	
	// El m�todo buscarMecanico es de tipo boolean y �nicamente devuelve true o false si localiza o no
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
	 M�todos para gestionar objetos de la clase Oferta.
	 */
	
	// El m�todo crearOferta crea un objeto oferta, le asigna los datos que devuelve el m�todo nuevaOferta
	// y guarda dicho objeto en el HashMap ofertas.
	
	public void crearOferta(){
		Oferta oferta = new Oferta();
		oferta = oferta.nuevaOferta();
		ofertas.put(oferta.getDescripcion(), oferta);
	}
	
	
	// El m�todo ofertaACliente pide los datos dni y descripci�n, con ello localiza los objetos cliente y oferta.
	// Incluye la oferta al correspondiente ArrayList del cliente si el m�todo noOfertada le ha devuelto
	// que no lo estaba ya. Por �ltimo, le da fecha a la oferta cuando es presentada si el m�todo haPasadounAnno
	// le devuelve que ha sido presentada hace m�s de un a�o.
	
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
	
	
	// El m�todo noOfertada comprueba, mediante la variable descripcion, si un objeto oferta
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
	
	
	// El m�todo haPasadounAnno es de tipo boolean, comprueba con el atributo FechaPresentada
	// si una oferta ha sido presentada hace menos de un a�o, y devuelve true o false.
	
	private Boolean haPasadounAnno(Oferta yaOfertada){		
	    Calendar haceUnAnno = Calendar.getInstance();
	    haceUnAnno.add(Calendar.YEAR, -1);
		if (yaOfertada.getFechaPresentada() == null || yaOfertada.getFechaPresentada().before(haceUnAnno)){	
			return true;
		}
		return false;
	}
	
	
	// El m�todo enviarOfertas recorre el HashMap clientes y a cada elemento le aplica el m�todo enviarOfertas
	// de la clase Cliente, que imprime los datos de las ofertas de cada cliente
	// incluidas en su ArrayList ofertas.
	
	public void enviarOfertas(){
		for (Cliente cl: clientes.values()){
			System.out.println(cl.enviarOfertas());
		}
	}
	
	
	// El m�todo pasarItv solicita una matricula para localizar un objeto vehiculo, comprueba
	// si est� pasando la ITV, y si no es as�, le da valor true a la variable de tipo boolean aPasarItv.
	// Si ya est� pasando la ITV, muestra el mensaje de que la est� pasando. 
	
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
	
	
	// El m�todo modificarEstadoItv solicita una matricula para localizar un objeto vehiculo, comprueba
	// si est� pasando la ITV, y si es as�, solicita indicar los trabajos realizados o pendientes de realizar
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