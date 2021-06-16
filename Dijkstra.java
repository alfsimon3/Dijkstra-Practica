package es.upm.dit.adsw.ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author DANIEL SÁNCHEZ PONCE
 * @author ALFONSO FERNÁNDEZ SIMÓN
 * @author NEREA ENCARNACIÓN GONZÁLEZ-CUTRE
 *
 * based on http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html#algorithm
 */

public class Dijkstra {
	private final Graph graph;
	private Set <Node> visitedNodes;
    private Set <Node> unvisitedNodes;
    private Map <Node, Node> predecessors;
    private Map <Node, Integer> distance;


    public Dijkstra(Graph graph, Node src) {
    	this.graph = graph;
    	visitedNodes = new HashSet<Node>();
    	unvisitedNodes = new HashSet<Node>();
    	distance = new HashMap<Node, Integer>();
    	predecessors = new HashMap<Node, Node>();
    	distance.put(src, 0);
    	unvisitedNodes.add(src);
    	while (unvisitedNodes.size() > 0) {
    		Node node = getMinimum(unvisitedNodes);
    		visitedNodes.add(node);
    		unvisitedNodes.remove(node);
    		findMinimalDistances(node);
    	}
    }

    private Node getMinimum(Set<Node> vertexes) {
    	Node minimum = null;
    	for (Node vertex : vertexes) {
    		if (minimum == null) {
    			minimum = vertex;
    		} else {
    			if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
    			}
    		}
    	}
    	return minimum;
    }

    private int getShortestDistance(Node vertex) {
    	Integer d = distance.get(vertex);
    		if (d == null) {
    			return Integer.MAX_VALUE;
    		} else {
    			return d;
    		}
    }

    private void findMinimalDistances(Node node) {
    	List<Node> adjacentNodes = getNeighbors(node);
    	for (Node target : adjacentNodes) {
    		if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
    			distance.put(target, getShortestDistance(node) + getDistance(node, target));
    			predecessors.put(target, node);
    			unvisitedNodes.add(target);
    		}
    	}
    }

    private List<Node> getNeighbors(Node node) {
    	List<Node> neighbors = new ArrayList<Node>();
    	List<Link> linksAdy= graph.getLinks(node);
    		for (Link link : linksAdy){
    			Node nodeAdy = graph.getNode(link.getDst());
    				if (!isSettled(link.getDst())) {
    					neighbors.add(nodeAdy);
    				}
    		}
    		return neighbors;
    }

    private int getDistance(Node node, Node target) {
    	List<Node> path = new ArrayList<Node>();
    	path.add(node);
    	path.add(target);
    	int distance = graph.getWeight(path);
    	return distance;
    }

    public List<Node> getPath(Node dst){
    	List<Node> path1 = new LinkedList<Node>();
    	Node step = dst;
    	if (predecessors.get(step) == null) {
    		return null;
    	}
    	path1.add(step);
    	while (predecessors.get(step) != null) {
    		step = predecessors.get(step);
    		path1.add(step);
    	}
    	Collections.reverse(path1);
    	return path1;
    }
 
    private boolean isSettled(String dst) {
    	Node node = graph.getNode(dst);
    	return visitedNodes.contains(node);
    }
    
}

