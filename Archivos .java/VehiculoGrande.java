/**
 * @ (#) VehiculoGrande.java
 * 
 * Clase VehiculoGrande.
 * Es una subclase que hereda de la clase madre Vehiculo.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class VehiculoGrande extends Vehiculo{
	
	Enumerados.TipoGrandes tipoGrande;

	
	public VehiculoGrande(Enumerados.TipoGrandes tipoGrande, String marca, String modelo, String matricula, Enumerados.Combustible combustible, String dniCliente) {
			
		super(marca, modelo, matricula, combustible, dniCliente);
		this.tipoGrande = tipoGrande;
	}

	
	public Enumerados.TipoGrandes getTipoGrande() {
		return tipoGrande;
	}

	public void setTipoGrande(Enumerados.TipoGrandes tipoGrande) {
		this.tipoGrande = tipoGrande;
	}
	
	
	@Override
	public String toStringAmpliado() {
		String datosGrande = "Vehiculo grande: " + tipoGrande + super.toStringAmpliado();
		return datosGrande;		
	}
	
	@Override	
	public String toString(){
		String datosGrande = "Vehiculo grande: " + tipoGrande + super.toString();
		return datosGrande;
	}
}