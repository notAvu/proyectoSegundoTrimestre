package clases;

public class Buscador {
	//atributos
	private Pagina[] memoria;
	
	//metodos
	public Buscador(int size) 
	{
		memoria=new Pagina[size];
	}
	
	public Pagina[] getMemoria() {
		return memoria;
	}

	public void setMemoria(Pagina[] memoria) {
		this.memoria = memoria;
	}
	//TODO Documentar
	public String toString()
	{
		String print="";
		for(int i =0;i<memoria.length;i++)
		{
			print=print+" "+memoria[i].toString();
		}
		return print;
	}
	
	//métodos para busqueda de páginas
	/**
	 * 
	 * @param busqueda
	 * @return keywords
	 */
	/*
	 * public String[] toArray(String busqueda) { String[]
	 * keywords=busqueda.split("\s"); return keywords; }
	 */
	
	//métodos para agregar página
	
	/**
	 * Recorre el array para comprobar si hay algun espacio vacio en el array
	 * 
	 * Precondiciones:ninguna
	 * Postcondiciones:ninguna
	 * @return hueco
	 */
	public int encontrarVacio() {
		int hueco=-1;
		for(int i=0; i<memoria.length;i++) 
		{
			if(memoria[i]==null) 
			{
				hueco=i;
				break;
			}
		}
		return hueco;
	}
	
	/**
	 * Agrega un objeto de la clase pagina (page) al array memoria. Si el array memoria no es lo suficientemente grande
	 * crea un nuevo array con el contenido del que ya existe para sustituirlo por este (Lo que viene siendo aumentar
	 * el tamaño del array en uno pero con mas pasos)
	 * Precondiciones: el objeto page no puede ser null
	 * Postcondiciones: ninguna
	 * @param page
	 */
	public void agregarPagina(Pagina page)
	{
		if(encontrarVacio()==-1) 
		{
			Pagina[] newMemoria= new Pagina[memoria.length+1];
			for(int i=0; i<memoria.length;i++) 
			{
					newMemoria[i]=memoria[i];
			}
			newMemoria[newMemoria.length]=page;
		}else 
		{
			memoria[encontrarVacio()]=page;
		}
	}
	/**
	 * Ordena la memoria con el metodo de burbuja en base a el numero de palabras que coinciden entre la busqueda y las palabras clave.
	 * Si dos p�ginas tienen el mismo numero de coincidencias se ordenan en base al pagerank
	 * Precondiciones: no puede haber elementos null en el array memoria.
	 * Postcondiciones: el array debe haber quedado ordenado ascendentemente en funcion de las coincidencias en la busqueda y el pagerank
	 * @param palabras
	 */
/*TODO cubrir el caso de que haya valores null en el array (Una opcion es hacer que el array sea inicialmente de un solo elemento e ir incrementando
 *  para lo que habria que eliminar algun metodo innecesario)
 */
	public void ordenarBusqueda(String[] palabras)
	{
		Pagina aux;
		for (int i=0 ; i< memoria.length -1 ; i++) 
		{
			for (int j = memoria.length -1 ; j > i ; j--)
				{
					if (memoria[j].getCoincidencias(palabras) < memoria[j-1].getCoincidencias(palabras))
					{
						aux = memoria[j];
						memoria[j] = memoria[j-1];
						memoria[j-1] = aux;
					}else if(memoria[j].getCoincidencias(palabras) == memoria[j-1].getCoincidencias(palabras)) 
					{
						if (memoria[j].getPageRank() < memoria[j-1].getPageRank())
						{
							aux = memoria[j];
							memoria[j] = memoria[j-1];
							memoria[j-1] = aux;
						}
					}
				}
		}
	}	
}