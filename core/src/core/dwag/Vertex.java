package dwag;

import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> edges = new ArrayList<Edge>(); // Creates the list of Edges
	private int totalWeight = Integer.MAX_VALUE; // Sets to infinity because we want to find the smallest
	private boolean visited;
	//public Vertex prev;
	//public double minDist = Double.POSITIVE_INFINITY;
	
	// Since this is a weighted, acyclic, directed graph, we need 3 things:
	// Get/set weight values, get/set visited (to stop cycles), get/sets the edges
	
	// First, we need to determine the edges of the graph
	
	// Call to get the edges
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	// Sets the edges
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	// Secondly, we need to determine the weights of those edges
	
	// Grabs the total weight from the starting Vertex
	public int weightFromSource() {
		return totalWeight;
	}
	// Determines the total weight from the starting Vertex
	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	
	}
	
	// Lastly we need to determine if that edge has been visited
	
	// Asks for the visited nodes
	public boolean verticesVisited() {
		return visited;
	}
	// Sets the visited nodes
	public void setVisited(boolean visited) {
		this.visited = visited;
		
	}

}
