/**
 * @ (#) Ficha.java
 * 
 * Clase Ficha.
 * Una vez registrado el vehiculo, esta clase representa la ficha que se crea para asignar
 * un vehiculo pendiente de trabajar a un mecanico. Puede incluir uno o varios trabajos a realizar.
 * 
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Ficha {
	
	protected Integer numFicha;
	protected String matricula;
    protected String nombreMecanico;
    protected ArrayList<Trabajo> trabajos = new ArrayList<Trabajo>();
    protected Enumerados.EstadoReparacion estado;
    protected Enumerados.Parado parado;
	protected Calendar fechaReparacion;
    
	
	/* Tres métodos constructores:
	 1º. Sin parámetros. Para hacer uso del método con el que introducimos los datos por consola.
	 2º. Le pasamos los cuatro primeros atributos. Lo utilizamos cuando se crea una ficha por primera vez.
	 3º. Los mismos que el anterior más los atributos estado y fechaReparacion. Se usa para modificar una ficha.
	*/
	
    public Ficha(){    
    }
    
    public Ficha(Integer numFicha, String matricula, String nombreMecanico, ArrayList<Trabajo> trabajos){    
      this.numFicha = numFicha;
      this.matricula = matricula;
      this.nombreMecanico = nombreMecanico;
      this.trabajos = trabajos;
      this.estado = Enumerados.EstadoReparacion.ACEPTADO;
    }   
 
    public Ficha(Integer numFicha, String matricula, String nombreMecanico, ArrayList<Trabajo> trabajos, 
    		Enumerados.EstadoReparacion estado, Calendar fechaReparacion){    
        this.numFicha = numFicha;
        this.matricula = matricula;
        this.nombreMecanico = nombreMecanico;
        this.trabajos = trabajos;
        this.estado = estado;
        this.fechaReparacion = fechaReparacion;
    }   

    
	public Integer getNumFicha() {
		return numFicha;
	}
	
	public void setNumFicha(Integer numFicha) {
		this.numFicha = numFicha;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNombreMecanico() {
		return nombreMecanico;
	}
	
	public void setNombreMecanico(String nombreMecanico) {
		this.nombreMecanico = nombreMecanico;
	}
	
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}
	
	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	
	public Enumerados.EstadoReparacion getEstado() {
		return estado;
	}
	
	public void setEstado(Enumerados.EstadoReparacion estado) {
		this.estado = estado;
	}
	
	public Enumerados.Parado getParado() {
		return parado;
	}
	
	public void setParado(Enumerados.Parado parado) {
		this.parado = parado;
	}

	public Calendar getFechaReparacion() {
		return fechaReparacion;
	}

	public void setFechaReparacion(Calendar fechaReparacion) {
		this.fechaReparacion = fechaReparacion;
	}

	
	// Con el método nuevaFicha solicitamos y obtenemos por consola los datos necesarios para la creación
	// de un objeto ficha. Le pasamos el atributo nuevoNumero para poder asignar y localizar una ficha
	// por su correspondiente número.

	public Ficha nuevaFicha(Integer nuevoNumero) { 
	        System.out.print("Ficha: " + nuevoNumero + "\n");
	        System.out.print("Introduzca la matricula del vehiculo: ");
	        matricula = Menu.sc.nextLine();
	        System.out.print("Introduzca el nombre mecanico: ");
	        nombreMecanico = Menu.sc.nextLine();
	        System.out.print(Enumerados.menuMotivosVisita() + "\n");
	        System.out.print("Introduzca numero de trabajos separados por blanco: ");
	        String trbMenu = Menu.sc.nextLine();
	        ArrayList<Trabajo> trbLista = Enumerados.setArrayTrabajos(trbMenu);
	        Ficha ficha = new Ficha(nuevoNumero, matricula.trim(), nombreMecanico.trim(), trbLista);
	        return ficha;       
	}

	
	// El método modificarFicha va a solicitar y obtener por teclado los datos
	// para poder cambiar los trabajos a realizar y el estado en el que se encuentra la reparación de una ficha.
	
	public Ficha modificarFicha(Ficha fichaAnt) { 
        System.out.print("Ficha: " + fichaAnt.getNumFicha() + "\n");
        System.out.print("Nombre mecanico: " + fichaAnt.getNombreMecanico() + ". ");
        System.out.print("Matricula: " + fichaAnt.getMatricula() + "\n");
        System.out.print(Enumerados.menuMotivosVisita() + "\n");
        System.out.print("Introduzca numero de trabajos separados por blanco: ");
        String trbMenu = Menu.sc.nextLine();
        ArrayList<Trabajo> trbLista = Enumerados.setArrayTrabajos(trbMenu);
        System.out.print("Introduzca el nuevo estado de la ficha: ");
        estado = darEstadoConsola();
        if (estado.equals(Enumerados.EstadoReparacion.TERMINADO)){
        	fechaReparacion = darFechaConsola();
        }
        Ficha ficha = new Ficha(fichaAnt.getNumFicha(), matricula.trim(), nombreMecanico.trim(), trbLista, estado, fechaReparacion);
        return ficha;       
    }
	
	
	// Con el método darEstadoConsola recogemos por consola el estado de reparación de un vehículo.
	
	public Enumerados.EstadoReparacion darEstadoConsola(){
		System.out.print(Enumerados.menuEstadoReparacion() + "\n");
        Integer iEstado = Menu.escanerInt();
        return Enumerados.EstadoReparacion.values()[iEstado];
	}
	
	
	// Con el método darFechaConsola devolvemos una fecha obtenida por consola.
	// Se usa en el método fichasEntreFechas, donde introducimos dos fechas para obtener el listado
	// de fichas reparadas entre esas dos fechas. Y en el método modificarFicha para dar una fecha de reparación.
	
	public Calendar darFechaConsola(){
		Calendar fecha = Calendar.getInstance();
		try{
			Integer anno = 0;
			Integer dia = 1;
			Integer mes = 1;
			System.out.print("Dar fecha: \n");
	        System.out.print("Anno: ");
	        anno = Menu.sc.nextInt();
	        Menu.sc.nextLine();
	        System.out.print("Mes: ");
	        mes = Menu.sc.nextInt();
	        Menu.sc.nextLine();
	        System.out.print("Dia: ");
	        dia = Menu.sc.nextInt();
	        Menu.sc.nextLine();	        
	        fecha.set(Calendar.YEAR, anno);
	        fecha.set(Calendar.MONTH, mes-1);
	        fecha.set(Calendar.DAY_OF_MONTH, dia);
		} catch (Exception e){
			System.out.print("Fecha erronea. Se graba fecha actual ");
			fecha.getTime();
		}
        return fecha;
        
	}
	
	
	// El método fecha simplemente es para dar un formato de impresión a una fecha.
	
	private String fecha(Calendar fecha){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(fecha.getTime());
	}
	
	
	// El método entreFechas es de tipo boolean, únicamente devuelve true o false al comprobar
	// si existen objetos de tipo ficha en un periodo entre dos fechas.
	
	public boolean entreFechas(Calendar ficFecha, Calendar fecha1, Calendar fecha2){
		if (ficFecha!= null && fecha1 != null && fecha2 != null &&
				ficFecha.after(fecha1) && ficFecha.after(fecha2) ){
			return true;
		} else{
			return false;
		}
	}
	
	
	/* Métodos to String y toStringReducido:
	 toString. Mostrará cuatro atributos y se hará uso de él cuando se quiera listar
	 una serie de fichas y no sea necesario mostrar todos los datos.
	 toStringReducido. Sí que nos muestra los demás datos que completan una ficha.
	*/
	
	public String toStringReducido(){
		String datos =   "Ficha: " + numFicha + " " + matricula  +  " " + nombreMecanico 
				+ " " + estado.toString();
		if (estado.equals(Enumerados.EstadoReparacion.TERMINADO)){
			datos= datos + "  " + fecha(fechaReparacion);
		}
		return datos;
	}
	
	@Override
	public String toString() {
		
		String datosFicha =   "\n Ficha: " + numFicha + 
							   "\n matricula: " + matricula +
							   "\n nombre mecanico: " + nombreMecanico +
							   "\n trabajos: " + trabajos.toString() +
							   "\n estado: " + estado.toString();
		if (parado!=null){
			datosFicha	= datosFicha + parado.toString();
		}
		if (estado.equals(Enumerados.EstadoReparacion.TERMINADO)){
			datosFicha	= datosFicha + "\n fecha reparado: " + fecha(fechaReparacion);
		}
		datosFicha	= datosFicha +  "\n ********** \n ";
		return datosFicha;
	}
}