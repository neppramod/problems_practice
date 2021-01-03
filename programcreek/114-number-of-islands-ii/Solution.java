import java.util.*;
 
public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		//int[][] positions = {{0,0}, {0, 1}, {1, 2}, {2, 1}};
		int[][] positions = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 1, 2 } };
		int m = 3, n = 3;
		List<Integer> result = sol.numberOfIslands(m, n, positions);
		System.out.println(result);

	}
	
	int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };  // adjacent nodes distance from current node
	
	public List<Integer> numberOfIslands(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
	
		if (positions == null || m == 0 || n == 0) {
			return result;
		}
			
		int[] parent = new int[m * n];  // it is easier to handle union-find with 1D array, so we translated 2D array positions to its related 1D array position
	
		// initialize parent to -1, to show it has not been visited
		Arrays.fill(parent, -1);
	
		int numberOfIslands = 0;
		// Let's go through each position in positions, and count each island and analyze its adjacent neighbors
		for (int[] position : positions) {
	
			// let's calculate 1D index in parent using position
			// index = row * number of columns + columns
			int index = position[0] * n + position[1];

			// if a node was not handled previously, only then handle it
			// if parent of current position has not been set (as it was water before), add land to it and set its parent to itself
			if (parent[index] == -1) {

				// set its parent to itself (disjoint set)
				parent[index] = index;
	
				// we will first add a land count
				numberOfIslands++;
				
				// Let's analyze its adjacent neighbors
				for (int k = 0; k < 4; k++) {
					int x = position[0] + moves[k][0];
					int y = position[1] + moves[k][1];
	
					// same as above index = row * number of columns + columns
					int rootIndex = x * n + y;
	
					// if neighbor is within the given 2D array, and already visited (if not -1, that means it was handled before, which means it is part of a land)
					if (x >= 0 && x < m && y >= 0 && y < n && parent[rootIndex] != -1) {
	
						// now we use union-find algorithm to get root of the rootIndex node (x, y)
						// in union-find there is one node representative of the whole block, so all the values of land mass
						// will use same node as its representative node (root).
	
						int newRoot = getRoot(parent, rootIndex);
	
						// if this newRoot was not part of land where index is the root (representative node), we set root as index
						// by setting root of newRoot as index, we basically merged both nodes and effectively
						// all the nodes whose parents were newRoot or index (or all the land masses both represented became one)
						// so we need to decrement the numberOfIslands, because we don't want to double count the both nodes
						if (newRoot != index) {
							parent[newRoot] = index;
							numberOfIslands--;
						}
					}
				}
			}
				
		
			// since we are done with this iteration, let's add the numberOfIslands for this iteration to our result
			// for the next iteration of position, we don't need to reset numberOfIslands, because that will use previous value (add or decrement to that count)
			result.add(numberOfIslands);
	
		}
	
		return result;
	}
	
	// Now all that is remaining is to implement find getRoot of union-find
	// If you remember, when we created a node for the first time (change water to land), we set parent of current node to itself
	// So by logic, we know there is at least one node, whose parent is itself, and all other connected nodes will in some way (directly or indirectly) point to this node, if we keep on going back to parent until we reach end.
	// E.g. If we merge 2 nodes, children of first node will point first node as root and children of 2nd node will point 2nd node as its parent
	// When we merge these 2 nodes, we only change root of one to other, but don't change root values of any of the children
	// So we cannot just return parent of any node. We need to go all the way to the root and find a node such that the node's parent is itself (that is the true root).
	// One ring to rule them all, one ring to find them, one ring to bring them all, and in the darkness bind them. :)
	
	
	int getRoot(int[] parent, int rootIndex) {
		while (parent[rootIndex] != rootIndex) {
			rootIndex = parent[rootIndex];
		}
	
		return rootIndex;
	}	
}
