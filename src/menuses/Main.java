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
		Buscador buscador = new Buscador();	
		String opcion;
		do {
			opcion=Menu.visualizador(sc);//metodo resume nuestro proyecto
			switch (opcion) {
			case "1": {
				Object[] array=Menu.altaPagina(sc);
				buscador.agregarPagina(new Pagina(array[0].toString(),array[1].toString(),(int)array[2],(String[])array[3]));
				String eleccion;
				do {
					eleccion=Menu.preguntarHipervinculo(sc);
					switch (eleccion) {
					case "1": {
						boolean inputValido=false;
						while(!inputValido) {
							String link = Menu.pedirHipervinculo(sc);
							if(buscador.comprobarPagina(link)) 
							{
								Pagina vinculada=buscador.obtenerPagina(link);
								vinculada.setPageRank(vinculada.getPageRank()+1);
								inputValido=true;
							}else 
							{
								Menu.paginaInexistente();
							}
						}
						break;
					}
					case "2": {
						System.out.println();
						break;//El caso dos no hace nada pero he preferido usar un switch en vez un if/else para controlar que el usuario solo pueda responder con "1" y "2".
					}
					default: {
						Menu.opcionInvalida();
						break;
					}
					}
				} while (!(eleccion.equals("1")) && !(eleccion.equals("2")));
				break;
			}
			case "2": {
				String[] claveBusqueda = Menu.buscar(sc);
				Pagina[] resultado=buscador.ordenarBusqueda(claveBusqueda);
				Menu.mostrarResultados(resultado);			
				break;
			}
			case "3": {
				Menu.mensajeSaliendo();
				break;
			}
			default:
				Menu.opcionInvalida();
				break;
			}
		}while (!(opcion.equals("3"))); 
		sc.close();

	}

}
