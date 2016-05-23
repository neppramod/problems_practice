package  myprob;

import tree_travarsal_02.order.Node;

import java.util.*;

public class Dijkastra
{
	/*
	public void dijkastra(List<Node> unvisited, List<Node> visited) {
		Node source = unvisited.get(0);
		unvisited.remove(0);
		Map<Node, Integer> minimumDistances = new HashMap<>();
		
		for (Node node : allNodes()) {
			minimumDistances.add(node, Integer.MAX_VALUE);
		}
		
		while (!unvisited.isEmpty()) {
			Node currentNode = unvisited.get(0);
			List<Node> neighbors = getNeighbors(currentNode);
			
			for (Node neighbor : neighbors) {
				int nodeDistance = minimumDistances.get(neighbor);
				int newDistance = getDistance(currentNode) + 
					edgeDistance(currentNode, neighbor);
				
				if (nodeDistance > newDistance)) {
					minimumDistance.put(neighbor, newDistance);
				}
			}
			
			unvisited.remove(currentNode);
			visited.add(currentNode);
		}
	}
	*/
}
