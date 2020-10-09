/**
 * @ (#) Enumerados.java
 * 
 * Clase Enumerados.
 * En esta clase vamos a tener una serie de tipos enumerados que nos van a permitir
 * clasificar un objeto según sus características.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.util.ArrayList;

public class Enumerados {
	
	public enum TipoVehiculo{
		MOTO,
		COCHE,
		GRANDE
	}
	
	public enum TipoMoto{
		DE_CARRETERA,
		DE_CAMPO
	}
	
	public enum TipoCoche{
		TURISMO,
		DEPORTIVO,
		MONOVOLUMEN,
		TODO_TERRENO,
		VEHICULO_PROFESIONAL
		
	}
	
	public enum TipoGrandes{
		FURGONETA,
		CAMIONETA,
		AUTOBUS
	}
	
	public enum Combustible {
		DIESEL,
		GASOLINA,
		ELECTRICO
	}

	
	public enum MotivoVisita {
		MOTOR, 
		FRENOS,
		RUEDAS,
		CHAPA_Y_PINTURA,
		LUNAS,
		ENCENDIDO,
		FILTRO_PARTICULAS,  // Si es un Diesel.
		PRESION_NEUMATICOS,  // Si tiene 2 ruedas.
		SIRENAS  // Si es un Vehiculo Profesional.
	}
	
	public enum EstadoReparacion {
		ACEPTADO,
		PENDIENTE,
		EN_PROCESO,
		FASE_PRUEBA,
		PARADO,
		TERMINADO	
	}
	
	public enum Parado {
		FALTAN_PIEZAS,
        CONFIRMAR_CLIENTE	
	}

	public enum TipoOferta {
		PUESTA_A_PUNTO,
        NEUMATICOS,
        CAMBIO_DE_ACEITE
	}
	
	
	// Los siguientes métodos con la misma estructura, nos permiten visualizar las diferentes opciones
	// que tiene cada tipo enumerado para poder mostrarlos al usuario cuando está introduciendo los datos.
	
	public static String menuMotivosVisita(){
		String verMotivos = "";
		for (Enumerados.MotivoVisita vm: Enumerados.MotivoVisita.values()){
			verMotivos = verMotivos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return verMotivos;
	}
	
	public static String menuTiposCombustible(){
		String tipos = "";
		for (Enumerados.Combustible vm: Enumerados.Combustible.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	public static String menuTiposVehiculos(){
		String tipos = "";
		for (Enumerados.TipoVehiculo vm: Enumerados.TipoVehiculo.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	public static String menuTiposCoche(){
		String tipos = "";
		for (Enumerados.TipoCoche vm: Enumerados.TipoCoche.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	public static String menuTiposMoto(){
		String tipos = "";
		for (Enumerados.TipoMoto vm: Enumerados.TipoMoto.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}

	public String menuTiposGrande(){
		String tipos = "";
		for (Enumerados.TipoGrandes vm: Enumerados.TipoGrandes.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	public static String menuEstadoReparacion(){
		String tipos = "";
		for (Enumerados.EstadoReparacion vm: Enumerados.EstadoReparacion.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	public static String menuTipoOfertas(){
		String tipos = "";
		for (Enumerados.TipoOferta vm: Enumerados.TipoOferta.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	
	// El método setArrayTrabajos recibe un String con los números de trabajo seleccionados en el menú
	// y los convierte en una lista de trabajos que corresponden con los números seleccionados.
	
	// De este método hacen uso los métodos nuevaFicha, modificarFicha y modificarEstadoItv.
	// Son los métodos donde el mecánico tiene que introducir los trabajos a realizar
	// al crear una ficha, al cambiar una ficha o cuando viene un vehículo de la ITV.

	public static ArrayList<Trabajo> setArrayTrabajos(String trbMenu){
		   ArrayList<Trabajo> trbLista = new ArrayList<Trabajo>();
		   Integer itrab;
		   String trb[] = trbMenu.split(" ");
		   for (int i=0; i<trb.length; i++){
			   try{
				   itrab = Integer.parseInt(trb[i].trim());
				   Trabajo trabajo = new Trabajo(Enumerados.MotivoVisita.values()[itrab]);
				   trbLista.add(trabajo);
			   } catch(Exception e){
			        System.out.print("Algun numero de trabajo mal introducido"); 
			   }
		   }

	       return trbLista;
	}
}