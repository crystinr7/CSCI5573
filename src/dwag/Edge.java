package dwag;


public class Edge {
	
	private int startVertex;
	private int toVertex;
	private int weight;
	// Need to change to Strings here, so that we can have an unique id
	public Edge(int startVertex, int toVertex, int weight) {
		
		// Set the variables
		this.startVertex = startVertex;
		this.toVertex = toVertex;
		this.weight = weight;
		
	}
	// For this class we need to create the edge, therefore we need the 
	// two nodes/vertices that it is connected to, since it is directed, 
	// the edge will go from one vertex to another vertex, without being
	// allowed to go both ways
	
	// Therefore we need a from/to vertex
	public int prevVertex() {
		return startVertex;
	}
	public int nextVertex() {
		return toVertex;
	}
	// Since this graph is weighted we need the weight along the edge
	public int weightOfEdge() {
		return weight;
	}
	
	// Determines the neighboring node/vertex
	// based on the two nodes/vertices that are connected by this edge
	public int getNeighbor(int nodeIndex) {
		if (this.startVertex == nodeIndex) {
			return this.toVertex;		
		} else {
			return this.startVertex;
		}
	}
	
}
