/**
 * @ (#) Trabajo.java
 * 
 * Clase Trabajo.
 * Esta clase representa cada uno de los trabajos a realizar en un vehículo y que se debe incluir
 * al ArrayList trabajos de la clase Ficha o al ArrayList aReparar de la clase Itv.
 * 
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Trabajo {
    
	private Enumerados.MotivoVisita unTrabajo;
	private boolean aRealizar = true;
    private boolean realizado = false;
    
    
    public Trabajo(Enumerados.MotivoVisita unTrabajo){
    	this.unTrabajo = unTrabajo;
    	aRealizar = true;
        realizado = false;
    }
    
    
	public Enumerados.MotivoVisita getUnTrabajo() {
		return unTrabajo;
	}
	
	public void setUnTrabajo(Enumerados.MotivoVisita unTrabajo) {
		this.unTrabajo = unTrabajo;
	}
	
	public boolean isaRealizar() {
		return aRealizar;
	}
	
	public void setaRealizar(boolean aRealizar) {
		this.aRealizar = aRealizar;
	}
	
	public boolean isRealizado() {
		return realizado;
	}
	
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
    
    
	@Override
	public String toString() {
		String datosTrabajo =  unTrabajo.toString();
		if (aRealizar){
			datosTrabajo = datosTrabajo + " a realizar";
		}
		if (realizado){
			datosTrabajo = datosTrabajo + " -- realizado";
		}
		return datosTrabajo;
	}
}