import java.util.*;

class DijkstraAlgorithm {
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        List<List<Edge>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int src, int dest, int weight) {
            adj.get(src).add(new Edge(dest, weight));
            adj.get(dest).add(new Edge(src, weight)); // If the graph is undirected
        }

        void dijkstra(int src) {
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            pq.add(new Edge(src, 0));

            while (!pq.isEmpty()) {
                Edge current = pq.poll();
                int u = current.dest;

                for (Edge edge : adj.get(u)) {
                    int v = edge.dest;
                    int weight = edge.weight;

                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Edge(v, dist[v]));
                    }
                }
            }

            System.out.println("Vertex  Distance from Source");
            for (int i = 0; i < V; i++) {
                System.out.println(i + "       " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 9;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        int source = 0;
        graph.dijkstra(source);
    }
}
