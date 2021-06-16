package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ejemplo de pruebas de la clase Link.
 * 
 * @author Juan A. de la Puente
 * @version 2019.01.27
 * 
 * COMPLETAR HASTA CUBRIR TODOS LOS CASOS
 * 
 */
public class LinkTest {

	
	@Test
	public void test00() {
		Link link = new Link ("A", "B", 1);
		assertEquals ("A", link.getSrc());
		assertEquals ("B", link.getDst());
		assertEquals (1, link.getWeight());
	}

}
