package clases;

/**
 * La clase contendra las paginas a las que el buscador puede acceder y las
 * funcionalidades necesarias para agregar y buscar las paginas.
 * 
 * @version 1.1
 * @author afernandez acandela mgomez thuecas
 *
 */
public class Buscador {
	// atributos
	private Pagina[] memoria;

	// metodos
	public Buscador() {
		memoria = new Pagina[0];
	}

	public Pagina[] getMemoria() {
		return memoria;
	}

	public void setMemoria(Pagina[] memoria) {
		this.memoria = memoria;
	}

	/**
	 * Devuelve la descripcion de cada una de las p�ginas almacenadas en la memoria
	 * llamando al m�todo toString de cada p�gina del array Precondiciones: La
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
	 * que coinciden entre la busqueda y las palabras clave. Si dos p�ginas tienen
	 * el mismo numero de coincidencias se ordenan en base al pagerank
	 * Precondiciones: no puede haber elementos null en el array memoria.
	 * Postcondiciones: el array debe haber quedado ordenado ascendentemente en
	 * funcion de las coincidencias en la busqueda y el pagerank
	 * 
	 * @param palabras
	 */



	/**
	 * Agrega un objeto de la clase pagina (page) pasada por parametro al array
	 * memoria. Para ello aumenta el tama�o de este en 1 y a�ade la pagina en el
	 * nuevo espacio 
	 * 
	 * Entrada:objeto de la clase Pagina
	 * Salida:ninguna
	 * Precondiciones: el objeto page no puede ser null
	 * Postcondiciones: el array memoria debe ser un nuevo array igual que el original pero con una pagina mas (la que se ha a�adido)
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

	private int tamanoArray(String[] palabras) {

		int tamanoArray = 0;

		for(int i = 0; i < this.memoria.length; i++) {

			if(this.memoria[i].getCoincidencias(palabras) >= 1) {

				tamanoArray++;

			}

		}
		return tamanoArray;
	}

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


	public Pagina[] ordenarBusqueda(String[] palabras) {

		Pagina[] filtrado = this.obtenerBusqueda(palabras);
		Pagina aux;

		for(int i = 0; i < filtrado.length - 1; i++) {

			for(int j = 0; j < filtrado.length - 1; j++) {

				if(filtrado[j+1].getCoincidencias(palabras) > filtrado[j].getCoincidencias(palabras)) {

					aux = filtrado[j + 1];
					filtrado[j+1] = filtrado[j];
					filtrado[j] = aux;

				} else if(filtrado[j+1].getCoincidencias(palabras) == filtrado[j].getCoincidencias(palabras)) {

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


	public boolean comprobarPagina(String hipervinculo) {

		boolean resultado = false;

		for(int i = 0; i < this.memoria.length; i++) {

			if(memoria[i].getUrl().toLowerCase().equals(hipervinculo.toLowerCase())) {

				resultado = true;

			}

		}

		return resultado;

	}

	public Pagina obtenerPagina(String hipervinculo) {

		Pagina devuelto = null;


		for (int i = 0; i < this.memoria.length; i++) {

			if(this.memoria[i].getUrl().toLowerCase().equals(hipervinculo.toLowerCase())) {

				devuelto = memoria[i];


			}


		}

		return devuelto;

	}



}