import java.util.*;

public class Solution
{
    public int minJumps(int[] arr) {
          if (arr == null || arr.length == 0) {
            return 0;
          }

          int n = arr.length;
          Map<Integer, List<Integer>> map = new HashMap<>();
          for (int i = 0; i < arr.length; i++) {
              if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<Integer>());
              }
              map.get(arr[i]).add(i);
          }

          boolean[] visited = new boolean[n];
          Queue<Integer> queue = new LinkedList<Integer>();
          int steps = 0;

          queue.add(0);
          visited[0] = true;

          while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {

              int i = queue.poll();
              if (i == n-1) {
                return steps;
              }

              List<Integer> adjList = map.get(arr[i]);
              adjList.add(i-1);
              adjList.add(i+1);

              for (int j : adjList) {
                if (j >= 0 && j < n && !visited[j]) {
                  visited[j] = true;
                  queue.add(j);
                }
              }

              adjList.clear();  // important to remove TLE
            }

            steps++;
          }

          return -1;
    }
}

/*
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

q = [4, 1]
visited = [0, 4, 1]
steps = 1
Iteration 1 (above)

valIndex[100: [0, 4], -23: [1, 2], 404: [3, 9], 23: [5, 6, 7], 3: [8]]

Iteration 2:
q = [3, 5, 2]
visited = [0, 1, 2, 3, 4, 5]
steps = 2

Iteration 3:
q = [9, 6, 7]
visited = [0, 1, 2, 3, 4, 5, 6, 7, 9]
steps = 3

Iteration 3:
q = [6, 7]
visited = [0, 1, 2, 3, 4, 5, 6, 7, 9]
steps = 3

size = 3:
while size -- > 0:
  size = 2
  i = 9
  return steps = 3
*/
