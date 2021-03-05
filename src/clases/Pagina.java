package clases;
/**
 * Contiene los datos de paginas web, su enlace, una breve descripcion, su pagerank, 
 * una serie de palabras clave para facilitar la busqueda, y un link a otra pagina (que puede tener o no).
 * 
 * @version 1.1
 * @author afernandez acandela mgomez thuecas
 *
 */
public class Pagina {
		//Atributos
	  private String url;//Consultable, Modificable 
	  private String descripcion;//Consultable, Modificable 
	  private int pageRank;//Consultable, Modificable 
	  private String[] palabrasClave;//Consultable, Modificable 
	  private String hipervinculo;//Consultable, Modificable 
	  
	 
	  	//Metodos
	  /*
	   * Tenemos dos metodos constructores,uno para crear la pagina con todos sus parametros y otro para 
	   * crear una pagina que no tenga hipervinculo
	   */
	  	public Pagina(String url,String descripcion, int pageRank, Pagina link,String[] palabrasClave) 
		{
			 this.descripcion=descripcion;
			 this.hipervinculo=link.getUrl();
			 link.setPageRank(link.getPageRank()+1);//Aumenta en 1 el pagerank de la página a la que hace referencia
			 this.pageRank=pageRank;
			 this.url=url;
			 this.palabrasClave=palabrasClave;			 
		}
	  	public Pagina(String url,String descripcion, int pageRank,String[] palabrasClave) 
		{
			 this.descripcion=descripcion;
			 this.hipervinculo="Vacio";
			 this.pageRank=pageRank;
			 this.url=url;
			 this.palabrasClave=palabrasClave;			 
		}

		public String getUrl() 
		{
			return url;
		}
	
		public void setUrl(String url) 
		{
			this.url = url;
		}
	
		public String getDescripcion() 
		{
			return descripcion;
		}
	
		public void setDescripcion(String descripcion) 
		{
			this.descripcion = descripcion;
		}
	
		public int getPageRank() 
		{
			return pageRank;
		}
	
		public void setPageRank(int pageRank) 
		{
			this.pageRank = pageRank;
		}
	
		public String[] getPalabrasClave() 
		{
			return palabrasClave;
		}
	
		public void setPalabrasClave(String[] palabrasClave) 
		{
			this.palabrasClave = palabrasClave;
		}
	
		public String getHipervinculo() 
		{
			return hipervinculo;
		}
	
		public void setHipervinculo(Pagina link) 
		{
			this.hipervinculo = link.getUrl();
			link.setPageRank(link.getPageRank()+1);//Aumenta en 1 el pagerank de la página a la que hace referencia
		}
		
		/**
		 * Devuelve la Url del objeto junto a su descripcion
		 * 
		 * Entrada:ninguna
		 * Salida:La string devolver 
		 * Precondiciones: ninguna
		 * Postcondiciones: ninguna
		 * 
		 * @return url y descripcion (strings)
		 */
		public String toString() 
		{
			String url=this.getUrl();
			String desc=this.getDescripcion();
			String devolver=url+" "+desc;
			return devolver;
		}
		/**
		 * Entrada:el array busqueda
		 * Salida:el numero de coincidencias con las palabras clave  
		 * Precondiciones: El array busqueda y el array palabras clave no puede estar vacios
		 * Postcondiciones: Ninguna
		 * 
		 * @param busqueda
		 * @return coincidencias
		 */
		public int getCoincidencias(String busqueda[]) 
		{
			int coincidencias=0;
			for(int i=0; i<busqueda.length;i++) 
			{
				for(int j=0; j<palabrasClave.length;j++) 
				{
					if(palabrasClave[j].equals(busqueda[i])) 
					{
						coincidencias++;
					}
				}
			}
			return coincidencias;
		}
}
