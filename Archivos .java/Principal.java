/**
 * @ (#) Principal.java
 * 
 * Clase Principal.
 * En la clase Principal contamos con el m�todo main.
 * �nicamente va a incluir la creaci�n de un objeto menu y la correspondiente llamada al m�todo menuPrincipal.
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