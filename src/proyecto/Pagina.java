package proyecto;

public class Pagina {
		//Atributos
	  private String url;
	  private String descripcion;
	  private int pageRank;
	  private String[] palabrasClave;
	  private String hipervinculo;
	  
	 
	  	//Metodos
	  
	  	public Pagina(String url,String descripcion, int pageRank, Pagina link,String[] palabrasClave) 
		{
			 this.descripcion=descripcion;
			 this.hipervinculo=link.getUrl();
			 link.setPageRank(link.getPageRank()+1);
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
	
		public void setHipervinculo(Pagina hipervinculo) 
		{
			this.hipervinculo = hipervinculo.getUrl();
		}
		
		/**
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
