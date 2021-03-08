package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	
	private String[] arrayEjemplo4= {"nada"};
	private Pagina ejemplo4=new Pagina("http://ejemplo4", "ejemplo4", 4, arrayEjemplo4);
	
	//iniciallizacion de pagina para hacer otras pruebas
	private Pagina prueba1;

	private final ByteArrayOutputStream outContent=new ByteArrayOutputStream();
	private final PrintStream originalOut=System.out;

	
	//Reiniciar flujo
	@BeforeEach
	void reiniciarFlujo() {
		/*String[] arrayPrueba1= {"pagina","prueba","tienda"};
		prueba1=new Pagina("prueba", "página de prueba", 1, arrayPrueba1);*/
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	void reiniciarFlujo2() {
		System.setOut(originalOut);
	}

	
	//Test
	@Test
	public void testSetHipervinculo() {
		ejemplo3.setHipervinculo(ejemplo2);
		assertEquals(3, ejemplo2.getPageRank());
	}
	
	@Test
	public void testGetCoincidencias() {
		String[] array= {"tienda"};
		//TODO llamar a metodo getCoincidencias de Pagina
		assertEquals(3,);
	}

	/*
	@Test
	public void testToString() {
		prueba1.toString();
		assertTrue(outContent.toString().contains("prueba"));
	}
	*/
}
