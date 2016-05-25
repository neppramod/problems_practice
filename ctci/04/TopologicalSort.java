import java.util.*;

// Not a correct solution, but close to.
public class TopologicalSort
{
    public static class Node
    {
	public int data;
	public Set<Node> neighbors = new HashSet<Node>();
	public Node(int data) { this.data = data; }

	public boolean equals(Node n1, Node n2) {
	    return n1.data == n2.data;
	}

	public String toString() { return this.data + " "; }
    }

    public static class Graph
    {
	public Set<Node> allNodes = new HashSet<Node>();

	public Node findorCreateNode(int data)
	{
	    for (Node n : allNodes) {
		if (n.data == data)
		    return n;
	    }

	    return new Node(data);
	}
	
	public void addEdge(int a, int b)
	{
	    Node node1 = findorCreateNode(a);	    
	    Node node2 = findorCreateNode(b);
	    node1.neighbors.add(node2);
	    allNodes.add(node1);
	    allNodes.add(node2);
	}
    }

    public static Stack<Node> sort(Graph graph)
    {
	Stack<Node> stack = new Stack<Node>();
	Set<Node> visited = new HashSet<Node>();

	for (Node n : graph.allNodes) {
	    if (!visited.contains(n)) {
		sortUtil(n, stack, visited);
	    }
	}

	return stack;
    }



    private static void sortUtil(Node node, Stack<Node> stack, Set<Node> visited)
    {
	visited.add(node);

	for ( Node n : node.neighbors) {
	    if (!visited.contains(n)) {
		sortUtil(n, stack, visited);
	    }
	}

	if (!stack.contains(node))
	    stack.push(node);
    }

    public static void main(String[] args)
    {
	Graph g = new Graph();
	g.addEdge(1,2);
	g.addEdge(1,3);
	g.addEdge(3,4);
	g.addEdge(3,8);
	g.addEdge(5,6);
	g.addEdge(6,3);
	g.addEdge(8,11);

	TopologicalSort ts = new TopologicalSort();
	Stack<Node> orderValues = ts.sort(g);

	while (!orderValues.isEmpty()) {
	    Node n = orderValues.pop();
	    System.out.print(n);
	}

	System.out.println();
	
    }
}
