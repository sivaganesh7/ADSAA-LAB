class ShortestPath {
    // Number of vertices in the graph (constant)
    static final int V = 9;

    // Finds vertex with minimum distance value from unprocessed vertices
    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE;    // Initialize minimum distance
        int minIndex = -1;              // Initialize index of minimum distance vertex

        // Iterate through all vertices
        for (int v = 0; v < V; v++) {
            // Check if vertex is unprocessed and has smaller distance
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Prints the shortest distances from source to all vertices
    void printSolution(int dist[]) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.printf("%d \t\t %d%n", i, dist[i]);
        }
    }

    // Implements Dijkstra's algorithm using adjacency matrix
    void dijkstra(int graph[][], int src) {
        int[] dist = new int[V];        // Stores shortest distances from source
        Boolean[] sptSet = new Boolean[V]; // Tracks vertices in shortest path tree

        // Initialize distances and processed set
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;    // Set initial distances to infinity
            sptSet[i] = false;              // Mark all vertices as unprocessed
        }

        // Distance from source to itself is 0
        dist[src] = 0;

        // Process all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick vertex with minimum distance from unprocessed set
            int u = minDistance(dist, sptSet);
            
            // Mark vertex as processed
            sptSet[u] = true;

            // Update distances of adjacent vertices
            for (int v = 0; v < V; v++) {
                // Update if:
                // 1. Vertex v is not processed
                // 2. There is an edge from u to v (weight != 0)
                // 3. Distance to u is not infinity
                // 4. New path through u is shorter
                if (!sptSet[v] && 
                    graph[u][v] != 0 && 
                    dist[u] != Integer.MAX_VALUE && 
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the results
        printSolution(dist);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        // Example graph represented as adjacency matrix
        // 0 represents no edge between vertices
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        ShortestPath shortestPath = new ShortestPath();
        shortestPath.dijkstra(graph, 0); // Find shortest paths from vertex 0
        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println("Dijkstra (Adjacency List) Execution Time: " + (end - start) + " ns");
    }
}
