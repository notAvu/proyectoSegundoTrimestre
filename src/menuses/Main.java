package menuses;

import java.util.Scanner;

import clases.Buscador;
import clases.Pagina;

/**
 * Metodo main, lo primero que ejecuta el programa, todos conocemos y amamos al metodo main
 * 
 * @version 1.0
 * @author afernandez acandela mgomez thuecas
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String opcion=Menu.visualizador(sc);//metodo resume nuestro proyecto
		Buscador buscador = new Buscador();	
		do {
			switch (opcion) {
			case "1": {
				Object[] array=Menu.altaPagina(sc);
				buscador.agregarPagina(new Pagina(array[0].toString(),array[1].toString(),(int)array[2],(String[])array[3]));
				
				boolean inputValido=false;
				while(!inputValido) {
					inputValido=true;
		            if(Menu.pedirHipervinculo(sc).equals("1"))
		            {
		            	String link = Menu.pedirHipervinculo(sc);
		            	if(buscador.comprobarPagina(link)) 
		            	{
		            		Pagina vinculada=buscador.obtenerPagina(link);
		            		vinculada.setPageRank(vinculada.getPageRank()+1);
		            	}else 
		            	{
		            		System.out.println("No existe esa página");
		            		inputValido=false;
		            	}
		            }else if(!Menu.pedirHipervinculo(sc).equals("2"))
		            {
		            	System.out.println("opcion no valida");
		            	inputValido=false;
		            }
				}
				break;
			}
			case "2": {
				String[] claveBusqueda = Menu.buscar(sc);
				Pagina[] resultado=buscador.ordenarBusqueda(claveBusqueda);
				//Luego recorremos ese array mostrando por pantalla.				
				for (Pagina paginas : resultado) {
					System.out.println(paginas);
				}				
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
