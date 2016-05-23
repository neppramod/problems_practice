import java.util.*;

public class Graph {
	 public void bfs(GNode gNode, int element) {
		  Queue < GNode > queue = new LinkedList < GNode > ();
		  queue.add(gNode);

		  while (!queue.isEmpty()) {

			   // Visit the node
			   GNode node = queue.poll();
			   node.visited = true;
			   System.out.println("Visited: " + node.data);

			   /*
			   if (node.data == element) {
				System.out.println("Found" + element);
				break;
			   }
			   */

			   // Search adjacent nodes
			   for (GNode gn: node.neighbors) {
					if (!gn.visited) {
					 	queue.add(gn);
					}
			   }
		   
		  }
	  
	 }
	 
	  public void dfs(GNode gNode, int element) {
        if (gNode == null) {
            return;
        }

        // VLR = pre-order traversal
        gNode.visited = true;
        System.out.println("Visited: "+gNode.data);

        if (gNode.data == element) {
            System.out.println("Found: "+gNode.data);
            return;
        }

        for (GNode gn: gNode.neighbors) {
            if (!gn.visited) {
                dfs(gn, element);
            }
        }

    }

	 public static void main(String[] args) {
		  GNode zero = new GNode(0);
		  GNode one = new GNode(1);
		  GNode two = new GNode(2);
		  GNode three = new GNode(3);

		  zero.neighbors = new ArrayList < GNode > ();
		  zero.neighbors.add(two);
		  zero.neighbors.add(one);

		  two.neighbors = new ArrayList < GNode > ();
		  two.neighbors.add(zero);
		  two.neighbors.add(three);

		  one.neighbors = new ArrayList < GNode > ();
		  one.neighbors.add(two);

		  three.neighbors = new ArrayList < GNode > ();
		  three.neighbors.add(three);

		  Graph graph = new Graph();
		  //graph.bfs(two, 3);
		  graph.dfs(two, 3);
	 }
}
