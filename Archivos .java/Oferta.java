/**
 * @ (#) Oferta.java
 * 
 * Clase Oferta.
 * Es una clase que gestiona las diferentes ofertas que puede tener un taller para un cliente.
 * Representa el primer punto que se solicita en el Nivel 4.
 * 
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.util.Calendar;

public class Oferta {

	String descripcion;
	Enumerados.TipoOferta tipoOferta;
	Boolean ofertada;
	Boolean presentada;
	Calendar fechaPresentada;
	Integer porcentajeDescuento;

	
	public Oferta() {
	}

	public Oferta(String descripcion, Enumerados.TipoOferta tipoOferta, Integer porcentajeDescuento) {
		this.descripcion = descripcion;
		this.tipoOferta = tipoOferta;
		this.ofertada = true;
		this.presentada = false;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Enumerados.TipoOferta getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(Enumerados.TipoOferta tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public Boolean getOfertada() {
		return ofertada;
	}

	public void setOfertada(Boolean ofertada) {
		this.ofertada = ofertada;
	}

	public Calendar getFechaPresentada() {
		return fechaPresentada;
	}

	public void setFechaPresentada(Calendar fechaPresentada) {
		this.fechaPresentada = fechaPresentada;
	}

	public Boolean getPresentada() {
		return presentada;
	}

	public void setPresentada(Boolean presentada) {
		this.presentada = presentada;
	}

	public Integer getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Integer porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	
	// El método nuevaOferta solicita y obtiene por teclado los datos para devolver un objeto oferta.
	
	public Oferta nuevaOferta() {
		System.out.print("Introduzca la descripcion: ");
		descripcion = Menu.sc.nextLine();
		System.out.print(Enumerados.menuTipoOfertas() + "\n");
		System.out.print("Introduzca numero de oferta: ");
		Integer numeroOferta = Menu.escanerInt();
		System.out.print("Introduzca porcentaje de descuento: ");
		porcentajeDescuento = Menu.escanerInt();
		Oferta oferta = new Oferta(descripcion.trim(), Enumerados.TipoOferta.values()[numeroOferta],
				porcentajeDescuento);
		return oferta;
	}

	
	@Override
	public String toString() {
		String datos = tipoOferta.toString() + " con descuento " + this.porcentajeDescuento + "% \n";
		return datos;
	}
}