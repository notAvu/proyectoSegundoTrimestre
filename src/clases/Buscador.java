package clases;

/**
 * La clase contendra las paginas a las que el buscador puede acceder y las
 * funcionalidades necesarias para agregar y buscar las paginas.
 * 
 * @version 1.0
 * @author afernandez acandela mgomez thuecas
 *
 */
public class Buscador {
	// atributos
	private Pagina[] memoria;

	// metodos
	public Buscador() {
		memoria = new Pagina[0];//La memoria comienza vacia
	}

	public Pagina[] getMemoria() {
		return memoria;
	}

	public void setMemoria(Pagina[] memoria) {
		this.memoria = memoria;
	}

	/**
	 * Devuelve la descripcion de cada una de las paginas almacenadas en la memoria
	 * llamando al metodo toString de cada pagina del array Precondiciones: La
	 * memoria no puede estar vacia Postcondiciones: Ninguna
	 * 
	 * @return print
	 */
	public String toString() {
		String print = "";
		for (int i = 0; i < memoria.length; i++) {
			print = print + " " + memoria[i].toString();
		}
		return print;
	}

	/**
	 * Ordena la memoria con el metodo de burbuja en base a el numero de palabras
	 * que coinciden entre la busqueda y las palabras clave. Si dos paginas tienen
	 * el mismo numero de coincidencias se ordenan en base al pagerank
	 * Precondiciones: no puede haber elementos null en el array memoria.
	 * Postcondiciones: el array debe haber quedado ordenado ascendentemente en
	 * funcion de las coincidencias en la busqueda y el pagerank
	 * 
	 * @param palabras
	 */



	/**
	 * Agrega un objeto de la clase pagina (page) pasada por parametro al array
	 * memoria. Para ello aumenta el tamaño de este en 1 y añade la pagina en el
	 * nuevo espacio dentro de la memoria
	 * 
	 * Entrada:objeto de la clase Pagina
	 * Salida:ninguna
	 * Precondiciones: el objeto page no puede ser null
	 * Postcondiciones: el array memoria debe ser un nuevo array igual que el original pero con una pagina mas (la que se ha aï¿½adido)
	 * 
	 * @param page
	 */
	public void agregarPagina(Pagina page) {
		Pagina[] newMemoria = new Pagina[memoria.length + 1];
		for (int i = 0; i < memoria.length; i++) {
			newMemoria[i] = memoria[i];
		}
		newMemoria[newMemoria.length - 1] = page;
		memoria = newMemoria;
	}

	/**
	 * Recorre la memoria para obtener el numero de paginas que tienen al menos una coincidencia con la busqueda (introducida por parametro)
	 * 
	 * Precondiciones: ninguna
	 * Poscondiciones: ninguna
	 * 
	 * @param busqueda
	 * @return
	 */
	
	private int tamanoArray(String[] busqueda) {

		int tamanoArray = 0;

		for(int i = 0; i < this.memoria.length; i++) {

			if(this.memoria[i].getCoincidencias(busqueda) >= 1) {

				tamanoArray++;

			}

		}
		return tamanoArray;
	}
	/**
	 * Devuelve un array con el las paginas que tienen al menos una coincidencia con las palabras introducidas por parametro
	 * 
	 * Precondiciones: ninguna
	 * Postcondiciones: ninguna
	 * 
	 * @param palabras
	 * @return
	 */
	private Pagina[] obtenerBusqueda(String[] palabras)
	{

		Pagina[] filtrado = new Pagina[this.tamanoArray(palabras)];
		int indice = 0;

		for(int i = 0; i < this.memoria.length; i++) {

			if(this.memoria[i].getCoincidencias(palabras) >= 1) {

				filtrado[indice] = this.memoria[i];
				indice++;

			}

		}
		return filtrado;
	}
	
	/**
	 * Este metodo recibe un array de palabras a buscar y devuelve un array con las paginas de la memoria que tienen al menos una coincidencia 
	 * ya ordenado segun el numero de coincidencias. En caso de que tengan el mismo numero de coincidencias los ordena en funcion del pageRank
	 * 
	 * Precondiciones:el array no debe estar vacia
	 * Postcondiciones: ninguna
	 * 
	 * @param busqueda
	 * @return filtrado 
	 */
	public Pagina[] ordenarBusqueda(String[] busqueda) {

		Pagina[] filtrado = this.obtenerBusqueda(busqueda);
		Pagina aux;

		for(int i = 0; i < filtrado.length - 1; i++) {

			for(int j = 0; j < filtrado.length - 1; j++) {

				if(filtrado[j+1].getCoincidencias(busqueda) > filtrado[j].getCoincidencias(busqueda)) {

					aux = filtrado[j + 1];
					filtrado[j+1] = filtrado[j];
					filtrado[j] = aux;

				} else if(filtrado[j+1].getCoincidencias(busqueda) == filtrado[j].getCoincidencias(busqueda)) {

					if(filtrado[j+1].getPageRank() > filtrado[j].getPageRank()) {

						aux = filtrado[j + 1];
						filtrado[j+1] = filtrado[j];
						filtrado[j] = aux;
					}

				}

			}
		}
		return filtrado;
	}
	
	/**
	 * Este metodo recibe un enlace en forma de cadena de caracteres y comprueba si se corresponde con la url de alguna pagina dentro de la memoria
	 * 
	 * Precondiciones: ninguna
	 * Postcondciciones: ninguna
	 * 
	 * @param hipervinculo
	 * @return resultado
	 */
	public boolean comprobarPagina(String hipervinculo) 
	{

		boolean resultado = false;

		for(int i = 0; i < this.memoria.length; i++) 
		{

			if(memoria[i].getUrl().toLowerCase().equals(hipervinculo.toLowerCase())) 
			{

				resultado = true;

			}

		}

		return resultado;

	}
	/**
	 * Devuelve la pagina que coincide con el hipervinculo pasado por parametro
	 * 
	 * @param hipervinculo
	 * @return devuelto
	 */
	public Pagina obtenerPagina(String hipervinculo) 
	{

		Pagina devuelto = null;


		for (int i = 0; i < this.memoria.length; i++) 
		{

			if(this.memoria[i].getUrl().toLowerCase().equals(hipervinculo.toLowerCase()))//convertimos a minusculas para facilitar la busqueda
			{

				devuelto = memoria[i];

			}


		}

		return devuelto;

	}
}