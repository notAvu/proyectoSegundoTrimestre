package menuses;

import java.util.Scanner;

import clases.Buscador;
import clases.Pagina;

/**
 * Metodo main, lo primero que ejecuta el programa, todos conocemos y amamos al metodo main
 * Funciona como controlador uniendo el menu con el resto del programa
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
			opcion=Menu.visualizador(sc);
			switch (opcion) {//aqui se ejecuta lo que el usuario haya elegido en la linea anterior
			case "1"://agregar pagina
				{
				Object[] array=Menu.altaPagina(sc);
				Pagina nuevaPagina=new Pagina(array[0].toString(),array[1].toString(),(int)array[2],(String[])array[3]);
				buscador.agregarPagina(nuevaPagina);//agrega una pagina con los datos del metodo anterior
				String eleccion;
				do {
					eleccion=Menu.preguntarHipervinculo(sc);//el usuario decide si quiere poner un hipervinculo a la pagina que acaba de crear
					switch (eleccion) {
					case "1" :
						{
						boolean inputValido=false;
						while(!inputValido) {
							String link = Menu.pedirHipervinculo(sc);
							if(buscador.comprobarPagina(link)) 
							{
								Pagina vinculada=buscador.obtenerPagina(link);
								nuevaPagina.setHipervinculo(vinculada);
								
								inputValido=true;
							}else 
							{
								Menu.paginaInexistente();
							}
						}
						break;
					}
					case "2": 
					{
						System.out.println();
						break;//El caso dos no hace nada pero he preferido usar un switch en vez un if/else para controlar que el usuario solo pueda responder con "1" y "2".
					}
					default: { //en cualquier otro caso
						Menu.opcionInvalida();
						break;
					}
					}
				} while (!(eleccion.equals("1")) && !(eleccion.equals("2")));
				break;
			}
			case "2": //buscar por palabras clave
			{
				String[] claveBusqueda = Menu.buscar(sc);
				Pagina[] resultado=buscador.ordenarBusqueda(claveBusqueda);
				Menu.mostrarResultados(resultado);			
				break;
			}
			case "3"://salir del programa
			{
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
