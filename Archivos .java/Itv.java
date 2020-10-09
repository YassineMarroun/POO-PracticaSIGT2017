/**
 * @ (#) Itv.java
 * 
 * Clase Itv.
 * Esta clase representa la gestión de pasar la ITV de un vehículo.
 * Este objeto se crea y se incluye en el atributo Itv de un vehiculo.
 * 
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.util.ArrayList;

public class Itv {
	
	private boolean aPasarItv;  // Se pone a true cuando se lleve a pasar la ITV.
	private boolean revisionTaller;  // Representa si ha pasado la revisión del taller.
	private ArrayList<Trabajo> aReparar;  // Es una lista de trabajos detectados cuando se ha pasado la ITV.
	private boolean reparado;  // Tendrá un valor true cuando hayan finalizado dichos trabajos.
    
	
    public Itv(){  
    	this.aPasarItv = false;
    	this.revisionTaller = false;
    	this.reparado = false;
    }

    
	public boolean isRevisionTaller() {
		return revisionTaller;
	}

	public void setRevisionTaller(boolean revisionTaller) {
		this.revisionTaller = revisionTaller;
	}

	public boolean isaPasarItv() {
		return aPasarItv;
	}

	public void setaPasarItv(boolean aPasarItv) {
		this.aPasarItv = aPasarItv;
	}

	public ArrayList<Trabajo> getaReparar() {
		return aReparar;
	}

	public void setaReparar(ArrayList<Trabajo> aReparar) {
		this.aReparar = aReparar;
	}

	public boolean isReparado() {
		return reparado;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}
}