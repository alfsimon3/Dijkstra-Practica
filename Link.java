package es.upm.dit.adsw.ej1;

/**
 * 
 * @author DANIEL SÁNCHEZ PONCE
 * @author ALFONSO FERNÁNDEZ SIMÓN
 * @author NEREA ENCARNACIÓN GONZÁLEZ-CUTRE
 *
 */

public class Link {
	
	private final java.lang.String src;
	private final java.lang.String dst;
	private final int weight;
	
	public Link (java.lang.String src, java.lang.String dst, int weight) {
		if (src == null || dst == null || weight < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		this.src = src;
		this.dst = dst;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public java.lang.String getSrc() {
		return src;
	}
	
	public java.lang.String getDst() {
		return dst;
	}
	
	@Override
	public String toString (){
		return String.format ("<%5,%6,%d>" , this.src, this.dst, this.weight);
	}

}
