package menu;

/**
 * Esta clase opera como una interfaz entre usuario y programa
 * 
 * @version 1.1
 * @author afernandez acandela mgomez thuecas
 *
 */
import java.util.Scanner;
import clases.Buscador;
import clases.Pagina;

//TODO comentar metodos con javadoc

public class Menu {
	
	static Buscador buscador= new Buscador();
	
	public static void io(String hiper)
	{


	}
	private final static String  ASTERISCOS="**********************************************";
	/** Este metodo te muestra las lineas del menu que te pregunta
	 * 
	 * Postcondicion:Este metodo muestra por pantalla el menu.
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public static void visualizador() {
		
		System.out.println(ASTERISCOS);
		System.out.println("\n"+"¿Qué desea realizar?");
		System.out.println("\n"+"1- Dar de alta una nueva página web");
		System.out.println("\n"+"2.- Buscar páginas por palabras clave");
		System.out.println("\n"+"3.- Salir");
		System.out.println("\n"+ASTERISCOS);
	}
	
	/**
	 * 
	 */
	public static void maneja() {
		Scanner sc= new Scanner(System.in);
		String opcion;
		String url;
		String descripcion;
		int pageRank;
		String palabrasClaves;
		String entradaClaves;
		do {
			visualizador();
			System.out.println("Elige opcion.");
			opcion=sc.next();
			switch (opcion) {
			case "1": {
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
				System.out.println("\n -Pagina hacia la que enlaza (Si no enlaza a ninguna pagina, deje en blanco la respuesta):");

				
				 System.out.println("\n 1.Ingresar sin hipervinculo");
			     System.out.println("\n 2.Ingresar con hipervinculo");
//Con lo siguiente vamos a pedirle si tiene o no un hipervinculo  la pagina que quiere añadir, si no lo tiene, se crea la pagina y se añade, si por el contrario 
//si tiene comprobara si existe la pagina y luego la creara.
			        int eleccion = sc.nextInt();

			        switch (eleccion) {

			            case 1:
			            	Pagina paginaAgregada=new Pagina(url,descripcion,pageRank,palabras);
			            	buscador.agregarPagina(paginaAgregada);

			                break;

			            case 2:
			            	System.out.println("Escribe el hipervinculo:");
							String hipervinculo=sc.next();
					         if(buscador.comprobarPagina(hipervinculo)) 
					         {
					        	 
					             Pagina paginaDevuelta = buscador.obtenerPagina(hipervinculo);
					             Pagina paginaAniadida=new Pagina(url, descripcion, pageRank, paginaDevuelta, palabras);
					             buscador.agregarPagina(paginaAniadida);
					             
					         }else {
					             System.out.println("no hay pagina asi");
					             opcion="4";
					         }
					         
					         break;
			        }
				System.out.println(ASTERISCOS);
				
				break;
			}
			case "2": {
				System.out.println(ASTERISCOS);
				System.out.println("Escribe las palabras clave: (separadas por un espacio) ");
				entradaClaves=sc.next();
				entradaClaves=entradaClaves+sc.nextLine();
				System.out.println("Resultados:");
				
//La siguiente linea crea un array apartir de lo que ha entrado por teclado, separando las palabras por espacios.
				String[] arrayClave=entradaClaves.split(" ");
				
//Con el array obtenido antes llamamos al metodo que cogera las coincidencias y ordenara las paginas, luego te lo enseñara.
				buscador.ordenarBusqueda(arrayClave);
				
				//TODO Arreglar los resultados que enseña por pantalla
				System.out.println(arrayClave.toString());
				
				break;
			}
			case "3": {
				System.out.println("Se esta cerrando el programa, pasa un buen dia.");
				
				break;
			}
			default:
				System.out.println("Ese valor no es valido.");
				break;
			}
		}while (!(opcion.equals("3"))); 
		sc.close();
	}
}
