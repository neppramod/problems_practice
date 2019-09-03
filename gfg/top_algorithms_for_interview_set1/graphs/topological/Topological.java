import java.util.*;

public class Topological
{
    int V;
    LinkedList<Integer> adj[];

    public Topological(int V)
    {
        this.V = V;

        adj = new LinkedList[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList();
        }
    }

    public void addEdge(int v1, int v2)
    {
        adj[v1].add(v2);
    }

    public LinkedList<Integer> topologicalSort()
    {

        LinkedList<Integer> topologicalList = new LinkedList<>();
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (visited[v] == false) {
                topologicalSort(v, visited, topologicalList);
            }
        }

        return topologicalList;
    }

    private void topologicalSort(int v, boolean[] visited, LinkedList<Integer> topologicalList)
    {
        visited[v] = true;

        for (int n : adj[v]) {
            if (!visited[n]) {
                topologicalSort(n, visited, topologicalList);
            }
        }

        // Add to front of linked list once done, can use stack also
        topologicalList.addFirst(v);
    }

    public static void main(String[] args) {
        Topological g = new Topological(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        LinkedList<Integer> sorted = g.topologicalSort();
        System.out.println(sorted);

    }
}
