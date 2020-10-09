/**
 * @ (#) Coche.java
 * 
 * Clase Coche.
 * Es una subclase que hereda de la clase madre Vehiculo.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Coche extends Vehiculo{
	
	private Enumerados.TipoCoche tipoCoche;

	
	public Coche(Enumerados.TipoCoche tipoCoche, String marca, String modelo, String matricula, Enumerados.Combustible combustible, String dniCliente) {
			
		super(marca, modelo, matricula, combustible, dniCliente);
		this.tipoCoche = tipoCoche;
	}

	
	public Enumerados.TipoCoche getTipoCoche() {
		return tipoCoche;
	}

	public void setTipoCoche(Enumerados.TipoCoche tipoCoche) {
		this.tipoCoche = tipoCoche;
	}
	

	@Override
	public String toStringAmpliado() {
		String datosCoche = "Coche: " + tipoCoche + super.toStringAmpliado();
		return datosCoche;		
	}
	
	@Override	
	public String toString(){
		String datosCoche = "Coche: " + tipoCoche + super.toString();
		return datosCoche;
	}	
}