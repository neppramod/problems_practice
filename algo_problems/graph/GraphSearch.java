import java.util.*;

public class GraphSearch
{

    static class Graph
    {
        int V;
        LinkedList<Integer> adjacencyList[];
        public Graph(int V) {
            this.V = V;
            adjacencyList = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjacencyList[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int start, int end)
        {
            adjacencyList[start].add(end);
        }

        void BFS(int start)
        {
            boolean[] visited = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            visited[start] = true;
            q.add(start);

            while (!q.isEmpty()) {
                int c = q.poll();

                System.out.print(c + " - ");

                for (int n : adjacencyList[c]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        q.add(n);
                    }
                }
            }
            System.out.println();
        }

        void DFS(int start, boolean[] visited)
        {
            visited[start] = true;
            System.out.print(start + " - ");

            for (int n : adjacencyList[start]) {
                if (!visited[n]) {
                    DFS(n, visited);
                }
            }
        }


    }

    public static void main(String[] args)
    {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);

        boolean visited[] = new boolean[g.V];
        g.DFS(2, visited);
        System.out.println();
    }


}
