/**
 * @ (#) Moto.java
 * 
 * Clase Moto.
 * Es una subclase que hereda de la clase madre Vehiculo.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Moto extends Vehiculo{
	
	private Enumerados.TipoMoto tipoMoto;

	
	public Moto(Enumerados.TipoMoto tipoMoto, String marca, String modelo, String matricula, Enumerados.Combustible combustible, String dniCliente) {			
		
		super(marca, modelo, matricula, combustible, dniCliente);
		this.tipoMoto = tipoMoto;
	}

	
	public Enumerados.TipoMoto getTipoMoto() {
		return tipoMoto;
	}

	public void setTipoMoto(Enumerados.TipoMoto tipoMoto) {
		this.tipoMoto = tipoMoto;
	}
	
	
	@Override
	public String toStringAmpliado() {
		String datosMoto = "Moto: " + tipoMoto + super.toStringAmpliado();
		return datosMoto;		
	}
	
	@Override
	public String toString(){		
		String datosMoto = "Moto: " + tipoMoto + super.toString();
		return datosMoto;
	}
}