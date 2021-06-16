package es.upm.dit.adsw.ej1;

/**
 * 
 * @author DANIEL SÁNCHEZ PONCE
 * @author ALFONSO FERNÁNDEZ SIMÓN
 * @author NEREA ENCARNACIÓN GONZÁLEZ-CUTRE
 *
 */

public class Node {
	
	private final java.lang.String name;
	private final int x;
	private final int y;
	
	public Node (java.lang.String name, int x, int y) {
		if (name == null || name.isEmpty()) {
			throw new java.lang.IllegalArgumentException();
		}
		this.name = name;
		this.x=x;
		this.y=y;
	}
	
	public java.lang.String getName() {
		return name;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString () {
		return name;
	}


}
