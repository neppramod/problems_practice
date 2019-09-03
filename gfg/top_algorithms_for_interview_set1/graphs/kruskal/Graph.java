import java.util.*;

public class Graph
{
    int V, E;
    Edge[] edges;

    public Graph(int V, int E)
    {
        this.V = V;
        this.E = E;

        edges = new Edge[E];
        for (int e = 0; e < E; e++) {
            edges[e] = new Edge();
        }
    }

    private class Edge
    {
        public int src, dest, weight;

        public String toString()
        {
            return src + " - " + dest + " : " + weight;
        }
    }

    private class EdgeComparator implements Comparator<Edge>
    {
        public int compare(Edge e1, Edge e2) {

            return e1.weight - e2.weight;
        }
    }

    private class subset
    {
        int rank;
        int parent;
    }

    private int find(subset[] subsets, int i)
    {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    private void union(subset[] subsets, int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[xroot].parent = yroot;
            if(subsets[xroot].rank == subsets[yroot].rank) {
                subsets[yroot].rank++;
            }
        }
    }

    public ArrayList<Edge> mstkruskal()
    {
        subset[] subsets = new subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        Arrays.sort(edges, new EdgeComparator());

        ArrayList<Edge> mst = new ArrayList<>();
        for (Edge e : edges) {
            int u = find(subsets, e.src);
            int v = find(subsets, e.dest);

            if (u != v) {
                union(subsets, u, v);
                mst.add(e);
            }
        }

        return mst;
    }

    public void addEdge(int index, int v1, int v2, int weight)
    {
        edges[index].src = v1;
        edges[index].dest = v2;
        edges[index].weight = weight;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9, 14);
        graph.addEdge(0,  0, 1, 4);
        graph.addEdge(1,  0, 7, 8);
        graph.addEdge(2,  1, 7, 11);
        graph.addEdge(3,  1, 2, 8);
        graph.addEdge(4,  7, 8, 7);
        graph.addEdge(5,  7, 6, 1);
        graph.addEdge(6,  2, 8, 2);
        graph.addEdge(7,  8, 6, 6);
        graph.addEdge(8,  2, 3, 7);
        graph.addEdge(9,  2, 5, 4);
        graph.addEdge(10, 6, 5, 2);
        graph.addEdge(11, 3, 5, 14);
        graph.addEdge(12, 3, 4, 9);
        graph.addEdge(13, 5, 4, 10);

        ArrayList<Edge> mst = graph.mstkruskal();
        for (Edge edge : mst) {
            System.out.println(edge);
        }
    }
}
