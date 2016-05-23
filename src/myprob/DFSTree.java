package myprob;

import java.util.*;

// TreeNode.java
/*
public class TreeNode
{
	public TreeNode left;
	public TreeNode right;
	public int data;
}
*/

public class DFSTree
{
	// dfs
	public static void dfs(TreeNode node, int item)
	{
		if (node == null) {
			return;
		}		
		
		// VLR = pre-order traversal
		// visit		
		System.out.println("Visited: " + node.data);
		if (node.data == item) {
			System.out.println("Found: " + node.data);
			return;
		}
		
		dfs(node.left, item);
		dfs(node.right, item);	
		
		// for graph
		// visit
		// set node as visited
		// call dfs on all adjacent nodes if visited == false	
	}
	
	// bfs
	public static void bfs(TreeNode node, int item)
	{
		if (node == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();
			
			// visit the node
			System.out.println("Visited: " + n.data);
			if (n.data == item) {
				System.out.println("Found: " + n.data);
				return;
			} else {
				if (n.left != null){ queue.add(n.left); }
				if (n.right != null) { queue.add(n.right); }
			}
		}
		
		// for tree inside the while loop
		// visit the node
		// set n.visited = true
		// in else
		// add all adjacent nodes to queue
	}
	
	public static void main(String[] args) 
	{
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(8);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(9);
		
		dfs(root, 7);
			System.out.println();
		dfs(root, 15);
			System.out.println();
		bfs(root, 9);
			System.out.println();
	}
}
