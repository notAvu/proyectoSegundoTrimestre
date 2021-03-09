package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Buscador;
import clases.Pagina;

class Pruebas {

	//paginas de prueba ya creadas
	private String[] arrayEjemplo1= {"tienda","patinete","barata"};
	private Pagina ejemplo1=new Pagina("http://ejemplo1", "ejemplo1", 1, arrayEjemplo1);

	private String[] arrayEjemplo2= {"tienda","ropa","moda"};
	private Pagina ejemplo2=new Pagina("http://ejemplo2", "ejemplo2", 2, arrayEjemplo2);

	private String[] arrayEjemplo3= {"tienda","móviles"};
	private Pagina ejemplo3=new Pagina("http://ejemplo3", "ejemplo3", 3, arrayEjemplo3);

	Buscador buscador=new Buscador();


//Tests
//Pagina
	@Test
	public void testSetHipervinculo() {
		ejemplo3.setHipervinculo(ejemplo2);
		assertEquals(3, ejemplo2.getPageRank());
	}

	@Test //Test en el que no coinciden palabras
	public void testGetCoincidenciasCero() {
		String[] array= {"ninguna"};
		assertEquals(0,ejemplo1.getCoincidencias(array));
	}

	@Test //Test en el que coinciden algunas de todas
	public void testGetCoincidenciasAlgunas() {
		String[] array= {"tienda", "patinete", "moda"};
		assertEquals(2,ejemplo1.getCoincidencias(array));
	}

	@Test //Test en el que coinciden todas las palabras
	public void testGetCoincidenciasTodas() {
		assertEquals(3,ejemplo1.getCoincidencias(arrayEjemplo1));
	}

//Buscador
	@Test //Test que comprueba que no se hacer JUnit bien
	public void testAgregarPagina() {
		String[] arrayprueba= {"palabra"};
		buscador.agregarPagina(new Pagina("prueba.com", "prueba", 1, arrayprueba));
		Object[] array= {"	prueba.com\nprueba"};
		assertArrayEquals(array, buscador.getMemoria());
	}

	@Test //Test que comprueba que me hizo odiar JUnit
	public void testOrdenarBusqueda() {
		String[] palabras= {"tienda"};
		Pagina[] resultado=buscador.ordenarBusqueda(palabras);
		String[] array= {"asdf"};
		assertArrayEquals(array, resultado);

	}

	@Test //Test que comprueba que voy a suspender el proximo examen
	public void testObtenerPagina() {
		String[] arrayprueba= {"palabra"};
		buscador.agregarPagina(new Pagina("prueba.com", "prueba", 1, arrayprueba));
		assertEquals("prueba.com prueba", buscador.obtenerPagina("prueba.com"));
	}

	//Estas pruebas unitarias en JUnit y sus comentarios son responsabilidad de Antonio, espero que saquen una sonrisa en quien lo lea porque las lagrimas ya me las he usado yo todas :')
	
	
	@Test //Test que comprueba que la pagina se ha añadido a la memoria
	public void testComprobarPagina() {
		String[] arrayprueba= {"palabra"};
		buscador.agregarPagina(new Pagina("prueba.com", "prueba", 1, arrayprueba));
		assertTrue(buscador.comprobarPagina("prueba.com"));
	}
	
}
