import java.io.*;
import java.util.*;

class GFG {
    // Class to represent a node in the adjacency list
    static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w) {
            vertex = v;
            weight = w;
        }

        int getVertex() { return vertex; }
        int getWeight() { return weight; }
    }

    // Function to find shortest distances from source to all vertices
    public static int[] dijkstra(int V, ArrayList<ArrayList<AdjListNode>> graph, int src) {
        // Initialize distance array with infinity
        int[] distance = new int[V];
        for (int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;

        // Priority queue to store vertices and their distances
        PriorityQueue<AdjListNode> pq = new PriorityQueue<>(
            (v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new AdjListNode(src, 0));

        // Main algorithm loop
        while (!pq.isEmpty()) {
            AdjListNode current = pq.poll();

            // Process all adjacent vertices
            for (AdjListNode n : graph.get(current.getVertex())) {
                // If we find a shorter path
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = distance[current.getVertex()] + n.getWeight();
                    pq.add(new AdjListNode(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }
        
        return distance;
    }

    public static void main(String[] args) {
        int V = 9;  // Number of vertices
        ArrayList<ArrayList<AdjListNode>> graph = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        int source = 0;  // Source vertex

        // Adding edges to the graph
        graph.get(0).add(new AdjListNode(1, 4));
        graph.get(0).add(new AdjListNode(7, 8));
        graph.get(1).add(new AdjListNode(2, 8));
        graph.get(1).add(new AdjListNode(7, 11));
        graph.get(1).add(new AdjListNode(0, 7));
        graph.get(2).add(new AdjListNode(1, 8));
        graph.get(2).add(new AdjListNode(3, 7));
        graph.get(2).add(new AdjListNode(8, 2));
        graph.get(2).add(new AdjListNode(5, 4));
        graph.get(3).add(new AdjListNode(2, 7));
        graph.get(3).add(new AdjListNode(4, 9));
        graph.get(3).add(new AdjListNode(5, 14));
        graph.get(4).add(new AdjListNode(3, 9));
        graph.get(4).add(new AdjListNode(5, 10));
        graph.get(5).add(new AdjListNode(4, 10));
        graph.get(5).add(new AdjListNode(6, 2));
        graph.get(6).add(new AdjListNode(5, 2));
        graph.get(6).add(new AdjListNode(7, 1));
        graph.get(6).add(new AdjListNode(8, 6));
        graph.get(7).add(new AdjListNode(0, 8));
        graph.get(7).add(new AdjListNode(1, 11));
        graph.get(7).add(new AdjListNode(6, 1));
        graph.get(7).add(new AdjListNode(8, 7));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(7, 1));

        // Calculate shortest paths
        int[] distance = dijkstra(V, graph, source);

        // Print results
        System.out.println("Vertex    Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.printf("%d %15d%n", i, distance[i]);
        }
    }
}
