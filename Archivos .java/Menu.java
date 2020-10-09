/**
 * @ (#) Menu.java
 * 
 * Clase Menu.
 * Esta clase recoge los diferentes menús donde se selecciona cada opción y a dicha opción
 * va relacionada una llamada al método correspondiente.
 *
 * @author Yassine Marroun
 * @version 1.00 2017/05/24
 */
import java.util.Scanner;

public class Menu {
	
	public static final Scanner sc = new Scanner(System.in);
	private GestionTaller gestion = new GestionTaller();
	
	
	// Menu Principal.
	
	public int menuPrincipal(){
	
		gestion.createDatosInicialesPruebas();
		
		int menu1 = 0;
		Integer numOpcs = 7;
			
		do{ 
			System.out.println("\n");
			System.out.println("1. Crear clientes.");
	    	System.out.println("2. Crear vehiculos.");
	    	System.out.println("3. Fichas.");
			System.out.println("4. Listar clientes.");
			System.out.println("5. Listar vehiculos.");
			System.out.println("6. Ofertas e Itv.");
	    	System.out.println("7. Salir.");
	    	System.out.print("Opcion> ");
	    		
	    	menu1 = escanerInt();
				
			if (menu1<1 || menu1>numOpcs) {
				System.out.println("Opcion incorrecta. Vuelve a probar");
	    	}
				
	    	switch (menu1){
	    			
	    		case 1:
	                gestion.crearCliente();
	                break;
	    		case 2:
	                gestion.crearVehiculo();
	                break;
	    		case 3:
	                menuMecanico();
	                break;
	    		case 4:
	                gestion.listarClientes();
	                break;
	    		case 5:
	                gestion.listarVehiculos();
	                break;
	    		case 6:
	    			menuOfertaseItv();
	    		case 7:
	    			System.out.println("...");
	    	}
		} while(menu1 != numOpcs); 
		
		return menu1;	
	}
	
	
	// Menu Mecanico.
	
	public int menuMecanico(){
		
		int menu1 = 0;
		Integer numOpcs = 9;
		String nombreMeca = "";
		Integer numFicha = 0;
		Ficha ficha = null;
		
		do{
			System.out.println("\n");
			System.out.println("1. Alta de ficha");
			System.out.println("2. Ver mis fichas");
			System.out.println("3. Modificar ficha");
    		System.out.println("4. Cambiar estado fichas");
    		System.out.println("5. Asignar mecanico");
    		System.out.println("6. Ver fichas en un estado");
    		System.out.println("7. Ver fichas reparadas entre dos fechas");
    		System.out.println("8. Listar todas las fichas");
    		System.out.println("9. Salir");
    		System.out.print("Opcion> ");
    		
    		menu1 = escanerInt();
			
			if(menu1<1 || menu1>=numOpcs){
    			System.out.println("Opcion incorrecta. Vuelve a probar");
    		}
			
    		switch (menu1){
    
			    case 1:
					System.out.println("Alta de fichas");
				    Integer nuevoNumero = gestion.getNumNuevaFicha();
					gestion.altaFichas(nuevoNumero);
					break;
    			case 2:
    				System.out.println("Nombre mecanico: ");
					nombreMeca = sc.nextLine();
    				gestion.visualizaFichasMecanico(nombreMeca.trim());
    				break;
    			case 3:
    				System.out.println("Modificar ficha numero:");					
					numFicha = escanerInt();
					gestion.modificarFicha(numFicha);
    				break;
    			case 4:
    				System.out.println("Cambiar estado de ficha numero:");					
					numFicha = escanerInt();
					ficha = gestion.getFicha(numFicha);
					if (ficha!=null){
						menuEstado(ficha);
					} else{
						System.out.println("Numero de ficha inexistente");	
					}
					break;
    			case 5:
    				System.out.println("Asignar mecanico a ficha numero:");					
					numFicha = escanerInt();
    				System.out.println("Nombre mecanico: ");
					nombreMeca = sc.nextLine();
    				gestion.asignarFichaAMecanico(numFicha, nombreMeca.trim());
    				break;
    			case 6:
    				System.out.println(Enumerados.menuEstadoReparacion());
    				System.out.println("Estado buscado:");					
					Integer iEstado = escanerInt();
					Enumerados.EstadoReparacion estado = Enumerados.EstadoReparacion.values()[iEstado];
    				if (estado!=null){
					    gestion.visualizaFichasEstado(estado);
    				} else{
    					System.out.println("Estado inexistente");	
    				}
    				break;
    			case 7:
    				gestion.fichasEntreFechas();
    				break;  
    			case 8:
    				gestion.visualizaFichasTodas();
    				break;     				
    			default:
    				break;
   		   } 
		} while(menu1 <= numOpcs); 
		return menu1;	
	}
	
	
	// Menu Estado.
	
	private void menuEstado(Ficha ficha){
		int submenu1 = 0;
		Integer numOpcs = 0;
		
		do{
			for (Enumerados.EstadoReparacion estado: Enumerados.EstadoReparacion.values()){
				System.out.println(estado.ordinal() + ". " + estado.name());
			}
			numOpcs = Enumerados.EstadoReparacion.values().length;
			System.out.print(numOpcs + ". Volver");
			
			System.out.print("\n  Submenu de estado reparacion > ");		
			submenu1 = escanerInt();
			
			if(submenu1<0 || submenu1>=numOpcs){
    			System.out.println("Opcion incorrecta. Vuelve a probar");
    		} else{		
				if (Enumerados.EstadoReparacion.values()[submenu1].equals(Enumerados.EstadoReparacion.PARADO)){
					System.out.println("Motivo del Estado Parado");
					menuParado(ficha);
				}
    		}

			if (submenu1<numOpcs){
				ficha.setEstado(Enumerados.EstadoReparacion.values()[submenu1]);
			}
			
		} while (submenu1 > numOpcs); 
		// Este menu solo se repite si la opcion es incorrecta. Si es correcta se modifica el estado.
	}
	
	
	// Menu Parado.
	
	private int menuParado(Ficha ficha){
		System.out.println("\n Submenu de Parado");
		int submenu2 = 0;
		Integer numOpcs = 2;
		do{
			System.out.println("0. Faltan Piezas");
			System.out.println("1. Confirmar Cliente");
			System.out.println("2. Volver");
			System.out.print("Opcion Submenu 2 > ");
	
			submenu2 = escanerInt();
			
			if (submenu2<numOpcs){
			 ficha.setParado(Enumerados.Parado.values()[submenu2]);
			}
		}while (submenu2 > numOpcs); 
		// Este menu solo se repite si la opcion es incorrecta. Si es correcta se modifica el motivo.
		
	    return submenu2;
	}
  
  
	// Menu Ofertas e ITV.
	
	public int menuOfertaseItv(){
		
		int menuOfe = 0; 
		Integer numOpcs = 6;

		
		do{
			System.out.println("\n");
			System.out.println("1. Alta de oferta");
			System.out.println("2. Ofertar a cliente");
			System.out.println("3. Enviar ofertas");
			System.out.println("4. Alta Pasar Itv");
			System.out.println("5. Modificar estado Itv");
    		System.out.println("6. Salir");
    		System.out.print("Opcion> ");
    		
    		menuOfe = escanerInt();
			
			if(menuOfe<1 || menuOfe>numOpcs){
    			System.out.println("Opcion incorrecta. Vuelve a probar");
    		}
			
    		switch (menuOfe){
    
			    case 1:
					gestion.crearOferta();
					break;
    			case 2:
    				gestion.ofertaACliente();
    				break;
    			case 3:
					gestion.enviarOfertas();
					break; 
    			case 4:
					gestion.pasarItv();
    				break;
    			case 5:
					gestion.modificarEstadoItv();
					break;				
    			default:
    				break;
   		   } 
		} while(menuOfe < numOpcs); 
		return menuOfe;	
	}
	
	
	// Ya que en esta clase necesitamos obtener por teclado muchos datos de tipo Integer,
	// este método escanerInt evita posibles fallos de programa recogiendo los errores con un catch.
	
	public static Integer escanerInt(){
	    try{
			Integer numero = sc.nextInt();
			sc.nextLine(); 
			return numero;
	    }
		catch(Exception e){
			sc.nextLine(); 
			return -1;
		}
	}
}