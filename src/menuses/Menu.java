package menuses;

/**
 * Esta clase opera como una interfaz entre usuario y programa
 * 
 * @version 1.0
 * @author afernandez acandela mgomez thuecas
 *
 */
import java.util.Scanner;
import clases.Buscador;
import clases.Pagina;


public class Menu {
	 
	static Buscador buscador= new Buscador();
	
	private final static String  ASTERISCOS="**********************************************";
	/** Este metodo te muestra las lineas del menu que te pregunta
	 * 
	 * Postcondicion:Este metodo muestra por pantalla el menu.
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public static String visualizador(Scanner sc) {
		
		
		String eleccion ="";
		
		System.out.println(ASTERISCOS);
		System.out.println("\n"+"¿Qué desea realizar?");
		System.out.println("\n"+"1- Dar de alta una nueva página web");
		System.out.println("\n"+"2.- Buscar páginas por palabras clave");
		System.out.println("\n"+"3.- Salir");
		System.out.println("\n"+ASTERISCOS);
		System.out.println("Elige opcion.");
		
		eleccion = sc.next();
		
		return eleccion;
	}
	
	public static void opcionInvalida() {
		System.out.println("Opción no valida");
	}
	
	public static void mostrarResultados(Pagina[] resultados) {
		if (resultados.length==0)
			System.out.println("No se han encontrado coincidencias");
		for (Pagina paginas : resultados) {
			System.out.println(paginas);
		}	
	}
	
	public static Object[] altaPagina(Scanner sc) 
	{
		String url;
		String descripcion;
		int pageRank;
		String palabrasClaves;
		
		System.out.println("\n"+ASTERISCOS);
		System.out.println("-¿Cual es la URL?");
		url=sc.next();
		System.out.println("\n -¿Cual es la descripcion?");
		descripcion=sc.next();
		descripcion=descripcion+sc.nextLine();
		System.out.println("\n -¿Cual es su pageRank?");
		pageRank=sc.nextInt();
		System.out.println("\n -Indique el listado de palabras clave (separadas por un espacio) ");
		palabrasClaves=sc.next();
		palabrasClaves=palabrasClaves+sc.nextLine();
		String[] palabras= palabrasClaves.split(" ");
		
		Object[] datosObtenidos =  {url, descripcion, Integer.valueOf(pageRank), palabras};
		return datosObtenidos;
		
		
	}
	
	public static String preguntarHipervinculo (Scanner sc) 
	{
		System.out.println("Desea introducir un hipervinculo?");
		System.out.println("1- Si");
		System.out.println("2- No");
		
		String elec=sc.next();
		
		return elec;
		
	}
	
	public static String pedirHipervinculo(Scanner sc) 
	{
		System.out.println("Introduzca la url de la pagina a la que quiere enlazar");
		String vinculo=sc.next();
		return vinculo;
		
	}
	
	
	public static String[] buscar(Scanner sc) {

				System.out.println(ASTERISCOS);
				System.out.println("Escribe las palabras clave: (separadas por un espacio) ");
				String entradaClaves=sc.next();
				entradaClaves=entradaClaves+sc.nextLine();
				System.out.println("Resultados:");
				
				//La siguiente linea crea un array apartir de lo que ha entrado por teclado, separando las palabras por espacios.
				String[] arrayClave=entradaClaves.split(" ");
		return arrayClave;/*
							 * 
							 * //Con el array obtenido antes llamamos al metodo que cogera las coincidencias
							 * y ordenara las paginas. Pagina[]
							 * resultado=buscador.ordenarBusqueda(arrayClave); //Luego recorremos ese array
							 * mostrando por pantalla. for (Pagina paginas : resultado) {
							 * System.out.println(paginas); }
							 */
		/*
		 * case "3": {
		 * System.out.println("Se esta cerrando el programa, pasa un buen dia.");
		 * 
		 * break; } default: System.out.println("Ese valor no es valido."); break; }
		 */

	}
}
