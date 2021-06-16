package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ejemplo de pruebas de la clase Node.
 * 
 * @author Juan A. de la Puente
 * @version 2019.01.27
 * 
 * COMPLETAR HASTA CUBRIR TODOS LOS CASOS
 * 
 */
public class NodeTest {

	@Test
	public void test00() {
		Node node =  new Node("A",0,0);
		assertEquals("A",node.getName());
		assertEquals(0,node.getX());
		assertEquals(0,node.getY());
	}

}
