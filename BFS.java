import java.util.*;

class BFS {
    // BFS traversal from a given source 's'
    static void bfs(List<List<Integer>> adj, int s) {
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS traversal
        boolean[] visited = new boolean[adj.size()]; // Visited array

        // Mark the source node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        System.out.println("BFS Traversal starting from node " + s + ":");

        while (!q.isEmpty()) {
            int curr = q.poll(); // Dequeue the front element
            System.out.print(curr + " "); // Print the current node

            // Traverse all adjacent vertices of 'curr'
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) { // If not visited, mark and enqueue
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println(); // Print a newline after BFS traversal
    }

    // Function to add an edge in the graph
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Since the graph is undirected
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Create adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        // Perform BFS traversal starting from vertex 0
        bfs(adj, 0);
    }
}
