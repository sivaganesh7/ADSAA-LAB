import java.util.*;

class BiconnectedComponents {
    private int vertices;
    private List<List<Integer>> adjList;
    private int time;

    public BiconnectedComponents(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        time = 0;
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    private void findBCCUtil(int u, int[] disc, int[] low, Stack<int[]> stack, int parent, boolean[] visited) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                children++;
                stack.push(new int[]{u, v});
                findBCCUtil(v, disc, low, stack, u, visited);

                low[u] = Math.min(low[u], low[v]);

                if ((parent == -1 && children > 1) || (parent != -1 && low[v] >= disc[u])) {
                    System.out.print("BCC: ");
                    while (true) {
                        int[] edge = stack.pop();
                        System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
                        if (edge[0] == u && edge[1] == v) break;
                    }
                    System.out.println();
                }
            } else if (v != parent && disc[v] < disc[u]) {
                stack.push(new int[]{u, v});
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public void findBCC() {
        int[] disc = new int[vertices];
        int[] low = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                findBCCUtil(i, disc, low, stack, -1, visited);
                if (!stack.isEmpty()) {
                    System.out.print("BCC: ");
                    while (!stack.isEmpty()) {
                        int[] edge = stack.pop();
                        System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        BiconnectedComponents graph = new BiconnectedComponents(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 6);

        System.out.println("Biconnected Components:");
        graph.findBCC();
    }
}
