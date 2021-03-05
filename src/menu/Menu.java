package menu;

import java.util.Scanner;

public class Menu {
	final static String  Asteriscos="**********************************************";
	/** Este metodo te muestra las lineas del menu que te pregunta
	 * 
	 * Postcondicion:Este metodo muestra por pantalla el menu.
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public static void visualizador() {
		
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
		String url;
		String descripcion;
		int pageRank;
		String palabrasClaves;
		do {
			
			System.out.println("Elige opcion.");
			opcion=sc.next();
			switch (opcion) {
			case "1": {
				//TODO Llamar metodo "Dar alta una pagina nueva"
				System.out.println("\n"+Asteriscos);
				System.out.println("-¿Cual es la URL?");
				url=sc.next();
				System.out.println("\n -¿Cual es la descripcion?");
				descripcion=sc.next();
				System.out.println("\n -¿Cual es su pageRank?");
				pageRank=sc.nextInt();
				System.out.println("\n -Indique el listado de palabras clave");
				palabrasClaves=sc.next();
				String[] elNombreQueLeQuierasPoner= palabrasClaves.split("\s");
				System.out.println("\n -Pagina hacia la que enlaza (Si no enlaza a ninguna pagina, deje en blanco la respuesta):");
				
				//Metodos para  hipervinculo, luego llamamos al metodo para dar de alta.
				System.out.println(Asteriscos);
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
