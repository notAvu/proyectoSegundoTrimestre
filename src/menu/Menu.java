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
		int opcion;
		String url;
		String descripcion;
		int pageRank;
		String palabrasClaves;
		do {
			
			System.out.println("Elige opcion.");
			opcion=sc.nextInt();
			switch (opcion) {
			case 1: {
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
				String[] palabras= palabrasClaves.split(" ");
				System.out.println("\n -Pagina hacia la que enlaza (Si no enlaza a ninguna pagina, deje en blanco la respuesta):");
				String hipervinculo=sc.next();
				
				 System.out.println("1.Ingresar sin hipervinculo");
			     System.out.println("2.Ingresar con hipervinculo");

			        Scanner teclado = new Scanner(System.in);

			        int eleccion = teclado.nextInt();

			        switch (eleccion) {

			            case 1:
			            	Pagina paginaAgregada=new Pagina(url,descripcion,pageRank,palabras);
			            	buscador.agregarPagina(paginaAgregada);

			                break;

			            case 2:
			            	
					         if(buscador.comprobarPagina(hipervinculo)) 
					         {
					        	 
					             Pagina paginaDevuelta = buscador.obtenerPagina(hipervinculo);
					             Pagina paginaAniadida=new Pagina(url, descripcion, pageRank, paginaDevuelta, palabras);
					             buscador.agregarPagina(paginaAniadida);
					             
					         }else 
					         {

					             System.out.println("no hay pagina asi");
					             opcion=4;
					         

			                break;

					         }
			        }
		         	         
				//Metodos para  hipervinculo, luego llamamos al metodo para dar de alta.
				System.out.println(Asteriscos);
				break;
			}
			case 2: {
				//TODO Llamar metodo "Buscar paginas por palabras claves"
				System.out.println("El 2");
				break;
			}
			case 3: {
				System.out.println("Se esta cerrando el programa, pasa un buen dia.");
				//boolean rendirse=true;
				break;
			}
			default:
				System.out.println("Ese valor no es valido.");
				break;
			}
		}while (opcion!=3);//booal rendirse  Probar con while
		sc.close();
	}
}
