package clases;

/**
 * La clase contendra las paginas a las que el buscador puede acceder y las funcionalidades 
 * necesarias para agregar y buscar las paginas.  
 * 
 * @version 1.0
 * @author afernandez acandela mgomez thuecas
 *
 */
public class Buscador {
	//atributos
	private Pagina[] memoria;
	
	//metodos
	public Buscador() 
	{
		memoria=new Pagina[1];
	}
	
	public Pagina[] getMemoria() {
		return memoria;
	}

	public void setMemoria(Pagina[] memoria) {
		this.memoria = memoria;
	}
/**
 * Devuelve la descripcion de cada una de las páginas almacenadas en la memoria llamando 
 * al método toString de cada página del array
 * Precondiciones: La memoria no puede estar vacia
 * Postcondiciones: Ninguna
 * 
 * @return print 
 */
	public String toString()
	{
		String print="";
		for(int i =0;i<memoria.length;i++)
		{
			print=print+" "+memoria[i].toString();
		}
		return print;
	}
	
	//Metodos para busqueda de paginas
	/**
	 * Ordena la memoria con el metodo de burbuja en base a el numero de palabras que coinciden entre la busqueda y las palabras clave.
	 * Si dos páginas tienen el mismo numero de coincidencias se ordenan en base al pagerank
	 * Precondiciones: no puede haber elementos null en el array memoria.
	 * Postcondiciones: el array debe haber quedado ordenado ascendentemente en funcion de las coincidencias en la busqueda y el pagerank
	 * @param palabras
	 */

	public Pagina[] ordenarBusqueda(String[] palabras)
	{
		Pagina aux;
		Pagina[] memoriaAux = new Pagina[memoria.length];
		/* copiamos el array para no modificar el original y asi poder implementar posibles 
		 *funciones en el futuro que dependan del orden original de las páginas en el array memoria
		 */
		for (int i=0 ; i< memoriaAux.length -1 ; i++) 
		{
			for (int j = memoriaAux.length -1 ; j > i ; j--)
				{
					if (memoriaAux[j].getCoincidencias(palabras) < memoriaAux[j-1].getCoincidencias(palabras))
					{
						aux = memoriaAux[j];
						memoriaAux[j] = memoriaAux[j-1];
						memoriaAux[j-1] = aux;
					}else if(memoriaAux[j].getCoincidencias(palabras) == memoriaAux[j-1].getCoincidencias(palabras)) 
					{
						if (memoriaAux[j].getPageRank() < memoriaAux[j-1].getPageRank())
						{
							aux = memoriaAux[j];
							memoriaAux[j] = memoriaAux[j-1];
							memoriaAux[j-1] = aux;
						}
					}
				}
		}
		return memoriaAux;
	}
	
	//Metodos para agregar pagina
	
	/**(Metodo inutil)
	 * Recorre el array para comprobar si hay algun espacio vacio en el array
	 * 
	 * Precondiciones:ninguna
	 * Postcondiciones:ninguna
	 * @return hueco
	 *
	 *
	 * public int encontrarVacio() { int hueco=-1; for(int i=0;
	 * i<memoria.length;i++) { if(memoria[i]==null) { hueco=i; break; } } return
	 * hueco; }
	 */
	
	/**
	 * Agrega un objeto de la clase pagina (page) pasada por parametro al array memoria. Para ello aumenta el tamaño de este en 1 
	 * y añade la pagina en el nuevo espacio
	 * Precondiciones: el objeto page no puede ser null
	 * Postcondiciones: ninguna
	 * @param page
	 */
	public void agregarPagina(Pagina page)
	{
			Pagina[] newMemoria= new Pagina[memoria.length+1];
			for(int i=0; i<memoria.length;i++) 
			{
					newMemoria[i]=memoria[i];
			}
			newMemoria[newMemoria.length-1]=page;
			memoria=newMemoria;
	}	
}