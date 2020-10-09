/**
 * @ (#) Principal.java
 * 
 * Clase Principal.
 * En la clase Principal contamos con el método main.
 * Únicamente va a incluir la creación de un objeto menu y la correspondiente llamada al método menuPrincipal.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */


public class Principal {

	public static void main (String[] args){		
		
        Menu menu = new Menu();
		menu.menuPrincipal();
	}
}