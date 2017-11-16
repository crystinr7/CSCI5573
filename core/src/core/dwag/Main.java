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
				
				new Edge(0, 1, 2),
				new Edge(0, 2, 4),				
				new Edge(1, 2, 2),
				new Edge(1, 4, 3),
				new Edge(1, 5, 1),
				new Edge(2, 6, 1),
				new Edge(3, 5, 4),
				new Edge(4, 5, 2),
				new Edge(4, 4, 7),
				new Edge(4, 7, 2),
				new Edge(5, 6, 8),
				new Edge(6, 7, 5),
		};
		
		Dijkstra d = new Dijkstra(edges);
		d.findShortestPath();
		// Prints the results of the shortest path from the given source/start 
		// node/vertex
		d.results(); 
		
	}
}
