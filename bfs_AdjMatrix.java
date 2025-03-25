import java.util.*;
class AdjMatrix {
    int adjmat[][];
    int vertices;
    AdjMatrix(int vertices){
        this.vertices=vertices;
        adjmat=new int[vertices][vertices];
    }
   public void addEdge(int u,int v){
        adjmat[u][v]=1;
        adjmat[v][u]=1;
    }
    public void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[vertices];
        visited[start]=true;
        q.add(start);
        while (!q.isEmpty()) {
            int p=q.poll();
            System.out.print(p+" ");
            for (int i = 0; i < vertices; i++) {
                if (adjmat[p][i]==1 && !visited[i]) {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }

}
public class bfs_adjmat {
    public static void main(String[] args) {
        int v=5;
        AdjMatrix g=new AdjMatrix(v);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);

        g.bfs(0);
    }
}
