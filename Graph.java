package es.upm.dit.adsw.ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author DANIEL SÁNCHEZ PONCE
 * @author ALFONSO FERNÁNDEZ SIMÓN
 * @author NEREA ENCARNACIÓN GONZÁLEZ-CUTRE
 *
 */

public class Graph {
	private List <Node> nodes = new ArrayList <Node>();
	private List <Link> links = new ArrayList <Link>();
	private Map <java.lang.String, Node> nodeMaps = new HashMap <java.lang.String, Node>();
	private Map <Node, List<Link>> linkMaps = new HashMap <Node, List<Link>> ();
	
	public void addNode (Node node){
		this.nodes.add(node);
		this.nodeMaps.put(node.getName(),node);
		this.linkMaps.put(node, new ArrayList <>());
	}
	
	public void addLink (Link link){
		this.links.add(link);
		Node src = this.getNode(link.getSrc());
		this.linkMaps.get(src).add(link);
	}
	
	public void addLink2D (java.lang.String a, java.lang.String b, int w){
		Link linkAB = new Link (a,b,w);
		Link linkBA = new Link (b,a,w);
		this.links.add(linkAB);
		this.links.add(linkBA);
		}
	
	public java.util.List<Node> getNodes(){
		return nodes;
	}
		
	public Node getNode(java.lang.String name){
		for (Node node : this.nodes){
			if (node.getName().equals(name)){
				return node;
			}
		}
		return null;
	}
	
	public java.util.List<Link> getLinks(){
		return links;
	}
	
	public java.util.List<Link> getLinks(Node node){
		return this.linkMaps.get(node);
	}
	
	public Link getLink(Node src, Node dst){
		List <Link> connection = this.linkMaps.get(src);
		for (Link link : connection){
			if (link.getDst().equals(dst.getName())){
				return link;
			}
		}
		return null;
	}

	public int getWeight(java.util.List<Node> path){
		int weight = 0;
		for (int i=1; i< path.size(); i++ ){
			Link link = getLink(path.get(i-1), path.get(i));
			if (link == null){
				return -1;
			}else{
				weight = weight + link.getWeight();
			}
		}
		return weight;
	}
	
}
