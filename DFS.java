import java.util.*;

class DFS {
    // DFS traversal from a given source 's'
    static void dfs(List<List<Integer>> adj, boolean[] visited, int s) {
        // Mark the current node as visited and print it
        visited[s] = true;
        System.out.print(s + " ");
        
        // Recur for all adjacent vertices of 's'
        for (int neighbor : adj.get(s)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
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

        // Array to track visited nodes
        boolean[] visited = new boolean[V];
        
        System.out.println("DFS Traversal starting from node 0:");
        dfs(adj, visited, 0);
    }
}
