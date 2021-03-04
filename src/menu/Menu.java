package menu;

import java.util.Scanner;

public class Menu {
	
	/** Este metodo te muestra las lineas del menu que te pregunta
	 * 
	 * Postcondicion:Este metodo muestra por pantalla el menu.
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public static void visualizador() {
		final String  Asteriscos="**********************************************";
		System.out.println(Asteriscos);
		System.out.println("\n"+"¿Qué desea realizar?");
		System.out.println("\n"+"1- Dar de alta una nueva página web");
		System.out.println("\n"+"2.- Buscar páginas por palabras clave");
		System.out.println("\n"+"3.- Salir");
		System.out.println("\n"+Asteriscos);
	}
	
	/**
	 * 
	 */
	public static void maneja() {
		visualizador();
		Scanner sc= new Scanner(System.in);
		String opcion;
		do {
			
			System.out.println("Elige opcion.");
			opcion=sc.next();
			switch (opcion) {
			case "1": {
				//TODO Llamar metodo "Dar alta una pagina nueva"
				System.out.println("El 1");
				break;
			}
			case "2": {
				//TODO Llamar metodo "Buscar paginas por palabras claves"
				System.out.println("El 2");
				break;
			}
			case "3": {
				System.out.println("Se esta cerrando el programa, pasa un buen dia.");
				//boolean rendirse=true;
				break;
			}
			default:  
				System.out.println("Ese valor no es valido.");
				break;
			}
		}while (opcion!="3");//booal rendirse  Probar con while
		
	}
}
