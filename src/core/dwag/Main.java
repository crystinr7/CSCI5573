package dwag;

public class Main {
	// Calculate the graph's shortest distance from start node via Dijkstra
	public static void main(String[] args) {
		
		Edge[] edges = {
				
			// Here is where we need to change things around a little bit
			// if the new Edge( , , ) needs to call the numbers from the random
			// number generator that was created by Tri...
			
			// You might need to change this for now so that it mimics it
				
			// Source Node, Destination Node, weight
				
				new Edge(2, 4, 2),
				new Edge(2, 3, 4),				
				new Edge(1, 2, 2),
				new Edge(1, 4, 3),
				new Edge(1, 5, 1),
				
		};
		
		Dijkstra d = new Dijkstra(edges);
		d.findShortestPath();
		// Prints the results of the shortest path from the given source/start 
		// node/vertex
		d.results(); 
		
	}
}
