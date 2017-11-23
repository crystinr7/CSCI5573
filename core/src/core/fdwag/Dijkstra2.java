import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Scanner;


class Vertex implements Comparable<Vertex>  {
    // Make the shortest time infinity for comparison reasons
    public double shortestTime = Double.POSITIVE_INFINITY;
    public final String name;
    public Edge[] connectsTo;
    
    
    public Vertex fromVertex;
    // Vertex id number, this needs to be a string for now, 
    // working on making it an object
    public Vertex(String id) { 
      name = id; 
    }
    
    public String toString() { 
        return name; 
    }
    // Compares shortest time to every other vertex's shortest time
    public int compareTo(Vertex everyOtherVertex){
        return Double.compare(shortestTime, everyOtherVertex.shortestTime);
    }

}


class Edge {
    // List the final destination as well as the weight for it
    public final Vertex destination;
    public final double weight;
    public Edge(Vertex destinationID, double weightID){ 
        destination = destinationID; 
        weight = weightID; 
    }
}
class ObjectPass {
    // This is what I'm trying to do to enter obeject instead of String
    public String value;
    public ObjectPass(String ids) {
        value = ids;  
    }
    
}

   
   

public class Dijkstra2 {
    // After looking at the different algorithms, the algortihm that worked best was 
    // Dijkstra's algorithm. Thus we need to set the source vertex to 0 and the others
    // are still at positive infinity.
    public static void computePaths(Vertex source) {
        source.shortestTime = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        // Vertex queue will help determine if visited
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            // Retrieves and removes the head of the queue
            Vertex pointA = vertexQueue.poll();

            // Visit each edge exiting pointA
            for (Edge e : pointA.connectsTo) {
                // Labels the weight for the edge
                double weight = e.weight;
                Vertex pointB = e.destination;
                // Find the shortest path to that spot
                double timeToPointA = pointA.shortestTime + weight;
        
                if (timeToPointA < pointB.shortestTime) {
                     vertexQueue.remove(pointB);
                     pointB.shortestTime = timeToPointA ;
                     pointB.fromVertex = pointA;
                     vertexQueue.add(pointB);
                }
            }
        }
    }

    public static List<Vertex> shortestPath(Vertex destination) {
        List<Vertex> route = new ArrayList<Vertex>();
        for (Vertex vertex = destination; vertex != null; vertex = vertex.fromVertex)
            route.add(vertex);

        Collections.reverse(route);
        return route;
    }
    
    //public static void convertToString(Object) {
       //String convertedToString = String.valueOf(Object);
    //}
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        String id_number;
        String connecting_edge;
        String newEdge;
       
        float newWeight;
        char vertex_id;
        System.out.println("ID:");
        id_number = user_input.next();
        
        Vertex node1 = new Vertex(id_number);
        //Asks for next enter node can easily convert
        // to ask for input from simulation
        System.out.println("Next ID:");
        id_number = user_input.next();
        Vertex node2 = new Vertex(id_number);
        System.out.println("ID:");
        id_number = user_input.next();
        Vertex node3 = new Vertex(id_number);
                
        
     
        // set the edges and weight
        // here we ned the simluator to feed connecting edges
        node1.connectsTo = new Edge[]{ new Edge(node3, 44.2),
                                   new Edge(node2, 12.2) };
        node2.connectsTo = new Edge[]{ new Edge(node3, 10.5) };
        
        node3.connectsTo = new Edge[]{ new Edge(node3, 25.2) };
        computePaths(node1);
        System.out.println("Time to get to " + node3 + ": " + node3.shortestTime);
        
        List<Vertex> route = shortestPath(node3);
        System.out.println("The path to get to " + node3 + ": " + route);
    }
}
// The program still needs to interact with simulator
