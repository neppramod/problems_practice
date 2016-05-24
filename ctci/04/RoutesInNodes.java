import java.util.*;

class RoutesInNodes
{
    class Node
    {
	int data;
	boolean visited;

	Node(int data) {this.data = data;}
	
	List<Node> neighbors = new ArrayList<>();
    }

    boolean routeBetweenTwoNodes(Node a, Node b)
    {
	Queue<Node> queue = new LinkedList<>();
	queue.add(a);

	while(!queue.isEmpty()) {
	    Node element = queue.poll();
	    element.visited = true;

	    if (element == b) {
		return true;
	    }

	    for (Node n : element.neighbors) {
		if (!n.visited) {
		    queue.add(n);
		}
	    }
	}

	return false;
    }

    public static void main(String[] args) {
	RoutesInNodes rn = new RoutesInNodes();

	RoutesInNodes.Node one = rn.new Node(1);
	RoutesInNodes.Node three = rn.new Node(3);
	RoutesInNodes.Node five = rn.new Node(5);
	RoutesInNodes.Node four = rn.new Node(4);
	RoutesInNodes.Node six = rn.new Node(6);
	RoutesInNodes.Node seven = rn.new Node(7);

	one.neighbors.add(three);
	one.neighbors.add(four);
	three.neighbors.add(five);
	five.neighbors.add(seven);
	five.neighbors.add(one);
	four.neighbors.add(six);
	six.neighbors.add(five);
	seven.neighbors.add(six);

	System.out.println(rn.routeBetweenTwoNodes(one, five));
    }
}
