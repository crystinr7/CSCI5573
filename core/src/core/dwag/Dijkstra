package dwag;

import java.util.ArrayList;
// This class will implement Dijkstra's algorithm to traverse
// the graph to find the shortest path in 

public class Dijkstra {
	
	// List for vertices
	private Vertex[] vertices;
	
	// Keeps track of the number of vertices 
	// and the number of edges in the graph
	private int vertex_quantity;
	private int edge_quantity;
	
	
	public Dijkstra(Edge[] edges) {
	
		// Updates vertex quantity
		this.vertex_quantity = calculatevertex_quantity(edges);
		this.vertices = new Vertex[this.vertex_quantity];
		
		for (int i = 0; i < this.vertex_quantity; i++) {
			this.vertices[i] = new Vertex();
		}
		
		// Determines the number of edges within the graph
		// Add all the edges to the vertices
		this.edge_quantity = edges.length;
		
		for(int addEdge = 0; addEdge < this.edge_quantity; addEdge++) {
			this.vertices[edges[addEdge].prevVertex()].getEdges().add(edges[addEdge]);
			this.vertices[edges[addEdge].nextVertex()].getEdges().add(edges[addEdge]);
		}
	}
	// Calculates the number of vertices in the graph
	private int calculatevertex_quantity(Edge[] edges) {
		int vertex_quantity = 0;
		
		for(Edge i : edges) {
			if (i.nextVertex() > vertex_quantity)
				vertex_quantity = i.nextVertex();
			if (i.prevVertex() > vertex_quantity)
				vertex_quantity = i.prevVertex();
		}
		vertex_quantity++;
		return vertex_quantity;
	}
	
	
    
	// Determines the smallest weight
	public void findShortestPath() {
		// node 0 as source
		this.vertices[0].setTotalWeight(0);
		int nextV = 0;
		// Visit every node that you can
		for (int i = 0; i < this.vertices.length; i++) {
			
			// loop around the edges of current node
			ArrayList<Edge> edgesOnVertex = this.vertices[nextV].getEdges();
			
			for(int connectedEdge = 0; connectedEdge < edgesOnVertex.size(); connectedEdge++) {
				int neighborIndex = edgesOnVertex.get(connectedEdge).getNeighbor(nextV);
				//only if not visited
				if (!this.vertices[neighborIndex].verticesVisited()) {
					int possiblepath = this.vertices[nextV].weightFromSource() + edgesOnVertex.get(connectedEdge).weightOfEdge();
					
					if (possiblepath < vertices[neighborIndex].weightFromSource()) {
						vertices[neighborIndex].setTotalWeight(possiblepath);
						
					}
				}
			}
			
			// All neighboring vertices checked, therefore visited = TRUE
			vertices[nextV].setVisited(true);
			
			
			// Next vertex must be shortest distance 
			nextV = vMinWeight();
		}
	}
	
	private int vMinWeight() {
		// Set index of vertex to 0 and all weights of unvisited vertices
		// to infinity/max_value
		int VertexIndex = 0;
		int infinity = Integer.MAX_VALUE;
		// If less than infinity give new weight for that path 
		for (int i = 0; i < this.vertices.length; i++) {
			int currentWeight = this.vertices[i].weightFromSource();
			
			
			if (!this.vertices[i].verticesVisited() && currentWeight < infinity) {
				infinity = currentWeight;
				VertexIndex = i;	
			}		
			
		}
		return VertexIndex;
	}
	
	// Displays results
	public void results() {
		String output = "Smallest weight/time from source vertex to vertex";
		
		for (int i = 0; i < this.vertices.length; i++) {
			output += ("\nFrom 0 to " + i +
					" : " + vertices[i].weightFromSource());
			
		}
		System.out.println(output);
		
	}
	
}
