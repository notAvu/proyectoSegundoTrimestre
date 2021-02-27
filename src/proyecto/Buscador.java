package proyecto;

public class Buscador {
	//atributos
	private Pagina[] memoria=new Pagina[5];

	
	//metodos
	public Pagina[] getMemoria() {
		return memoria;
	}

	public void setMemoria(Pagina[] memoria) {
		this.memoria = memoria;
	}
	
	//métodos para busqueda de páginas
	/**
	 * 
	 * @param busqueda
	 * @return keywords
	 */
	public String[] toArray(String busqueda) 
	{
		String[] keywords=busqueda.split("\s");
		return keywords;
	}
	
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
	
}
