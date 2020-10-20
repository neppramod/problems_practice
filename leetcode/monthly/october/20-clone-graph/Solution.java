import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		one.neighbors.add(two);
		one.neighbors.add(four);
		two.neighbors.add(one);
		two.neighbors.add(three);
		three.neighbors.add(two);
		three.neighbors.add(four);
		four.neighbors.add(one);
		four.neighbors.add(three);

		Node newNode = sol.cloneGraph(one);
		Set<Node> visited = new HashSet<>();
		printGraph(newNode, visited);
    }

	static void printGraph(Node newNode, Set<Node> visited) {
		if (visited.contains(newNode)) {
			return;
		}
		visited.add(newNode);
		System.out.println(newNode.val);
		for (Node n : newNode.neighbors) {
			printGraph(n, visited);
		}
	}

	// Definition for a Node.
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
    
    public Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}

		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		map.put(node, new Node(node.val, new ArrayList<>()));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (Node n : cur.neighbors) {
				if (!map.containsKey(n)) {
					map.put(n, new Node(n.val, new ArrayList<>()));
					queue.add(n);
				}
				map.get(cur).neighbors.add(map.get(n));
			}
		}

		return map.get(node);
    }
}
