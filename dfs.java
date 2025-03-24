import java.util.ArrayList;
import java.util.List;

public class dfs {
    public static void dfs1(List<List<Integer>> adj, int s, int v) {
        boolean[] visited = new boolean[v];
        dfsfun(adj, s, visited);
    }

    static void dfsfun(List<List<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int neighbor : adj.get(s)) {
            if (!visited[neighbor]) {
                dfsfun(adj, neighbor, visited);
            }
        }
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 1, 4);

        System.out.println("DFS Traversal starting from vertex 0:");
        dfs1(adj, 0, v);
        System.out.println();
    }
}
