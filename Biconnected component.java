import java.util.*;

// This class represents an undirected graph using adjacency list representation
public class biconnect_graph {
    private int V, E; // Number of vertices & edges
    private LinkedList<Integer>[] adj; // Adjacency List

    // Count of biconnected components & discovery time tracking
    static int count = 0, time = 0;

    class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    // Constructor with proper generic type suppression
    @SuppressWarnings("unchecked")
    biconnect_graph(int v) {
        V = v;
        E = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    // Function to add an edge into the graph (undirected graph)
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    // DFS-based function to find and print biconnected components
    void BCCUtil(int u, int disc[], int low[], LinkedList<Edge> st, int parent[]) {
        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (disc[v] == -1) { // If v is not visited yet
                children++;
                parent[v] = u;
                st.add(new Edge(u, v));
                BCCUtil(v, disc, low, st, parent);

                // Update the low value
                low[u] = Math.min(low[u], low[v]);

                // If u is an articulation point, pop all edges from stack till u -- v
                if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) {
                    while (!st.isEmpty() && (st.getLast().u != u || st.getLast().v != v)) {
                        System.out.print("("+st.getLast().u + "--" + st.getLast().v + ") ");
                        st.removeLast();
                    }
                    if (!st.isEmpty()) {
                        System.out.println("("+st.getLast().u + "--" + st.getLast().v+") ");
                        st.removeLast();
                    }
                    count++;
                }
            } else if (v != parent[u]) { // Update low value if v is an ancestor
                low[u] = Math.min(low[u], disc[v]);
                st.add(new Edge(u, v));
            }
        }
    }

    // Function to find biconnected components
    void BCC() {
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        LinkedList<Edge> st = new LinkedList<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                BCCUtil(i, disc, low, st, parent);

            // Print remaining components
            if (!st.isEmpty()) {
                while (!st.isEmpty()) {
                    System.out.print("("+st.getLast().u + "--" + st.getLast().v + ") ");
                    st.removeLast();
                }
                System.out.println();
                count++;
            }
        }
    }

    public static void main(String args[]) {
        biconnect_graph g = new biconnect_graph(12);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(0, 6);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(5, 8);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(10, 11);

        g.BCC();
        System.out.println("Above are " + g.count + " biconnected components in the graph");
    }
}
