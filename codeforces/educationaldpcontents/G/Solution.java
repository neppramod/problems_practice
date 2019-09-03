import java.util.*;

/*
  Longest Path
 */
public class Solution
{
    static LinkedList<Integer>[] adj;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        int maxLength = 0;
        for (int i = 1; i <= N; i++) {
            int curLength = graph.bfs(i);
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        System.out.println(maxLength);
    }

    private static class Graph
    {
        int N;
        public Graph(int N)
        {
            adj = new LinkedList[N+1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new LinkedList<Integer>();
            }
            this.N = N;
        }

        public void addEdge(int v1, int v2)
        {
            adj[v1].add(v2);
        }

        public int bfs(int node)
        {
            if (node >= N || adj[node] == null) return 0;

            int max = 0;
            for (int n : adj[node]) {
                int len = bfs(n);
                if (len > max) max = len;
            }

            return max + 1;
        }
    }

}
