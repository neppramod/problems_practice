import java.util.*;

public class Graph
{
    int V, E;
    Edge[] edge;

    public Graph(int V, int E)
    {
        this.V = V;
        this.E = E;

        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    public int find(int[] parent, int i)
    {
        if (parent[i] == -1) {
            return i;
        } else {
            return find(parent, parent[i]);
        }
    }

    public void union(int[] parent, int x, int y)
    {
        int xprime = find(parent, x);
        int yprime = find(parent, y);
        parent[xprime] = yprime;
    }

    public boolean containsCycle(Graph graph)
    {
        int[] parent = new int[graph.V];

        // initialize all subsets to -1
        Arrays.fill(parent, -1);

        for (int i = 0; i < E; i++) {
            int x = find(parent, graph.edge[i].src);
            int y = find(parent, graph.edge[i].dest);

            if (x == y) {
                return true;
            } else {
                union(parent, x, y);
            }
        }

        return false;
    }

    class Edge
    {
        int src, dest;
    }

    public static void main(String[] args) {

        int V = 3, E = 2;
        Graph graph = new Graph(V, E);


        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // graph.edge[2].src = 0;
        // graph.edge[2].dest = 2;


        if (graph.containsCycle(graph)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("Does not contain cycle");
        }
    }
}
