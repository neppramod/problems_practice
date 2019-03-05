import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();

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
            adjacencyList[dest].add(src);
        }

        void printGraph()
        {
            for (int i = 0; i < V; i++) {
                System.out.printf("%d ", i);
                for (int c : adjacencyList[i]) {
                    System.out.printf("--> %d ", c);
                }
                System.out.println();
            }
        }
    }
}
