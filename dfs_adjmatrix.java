class AdjMatrix {
    int adjmat[][];
    int vertices;

    AdjMatrix(int vertices) {
        this.vertices = vertices;
        adjmat = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adjmat[u][v] = 1;
        adjmat[v][u] = 1;
    }

    public void dfs(int start) {
        boolean visited[] = new boolean[vertices];
        dfs_fun(start, visited);

    }

    public void dfs_fun(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i = 0; i < vertices; i++) {
            if (adjmat[s][i] == 1 && !visited[i]) {
                dfs_fun(i, visited);
            }
        }
    }
}

public class dfs_adjmat {
    public static void main(String[] args) {
        int v = 5;
        AdjMatrix g = new AdjMatrix(v);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);

        g.dfs(0);
    }
}
