import java.util.*;

/*
  BFS: 2, 0, 3, 1
  DFS: 2, 0, 1, 3
 */

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
        boolean[] visited = new boolean[g.V];
        g.DFS(2, visited);
        System.out.println();
    }

    static class Graph
    {
        int V;
        LinkedList<Integer> adjacencyList[];
        public Graph(int V)
        {
            this.V = V;
            adjacencyList = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjacencyList[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int src, int dest)
        {
            // undirected
            adjacencyList[src].add(dest);

        }

        void BFS(int start)
        {
            boolean visited[] = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()) {
                Integer cur = queue.poll();
                visited[cur] = true;

                System.out.printf("%d, ", cur);

                for (int c : adjacencyList[cur]) {
                    if (!visited[c]) {
                        visited[c] = true;
                        queue.add(c);
                    }
                }
            }

            System.out.println();
        }

        void DFS(int start, boolean[] visited)
        {
            visited[start] = true;
            System.out.printf("%d, ", start);
            for (int c : adjacencyList[start]) {
                if (!visited[c]) {
                    DFS(c, visited);
                }
            }
        }
    }
}
