import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] rooms = {{INF, 0, -1, INF},
                         {-1, INF, -1, INF},
                         {INF, INF, INF, INF},
                         {0, INF, INF, -1}
                         };

        sol.wallsAndGates(rooms);

        for (int i = 0; i < rooms.length; i++) {
            System.out.println(Arrays.toString(rooms[i]));
        }
    }

    /*
    Given a grid, INF represents open space (2147483647), -1 as obstacle, 0 as gate.
    For each INF find the distance to nearest gate
    */

    static final int INF = 999999;

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int  j = 0; j < n; j++) {
               if (rooms[i][j] == 0) {
                   fillroom(rooms, i, j-1, 0, visited);
                   fillroom(rooms, i, j+1, 0, visited);
                   fillroom(rooms, i-1, j, 0, visited);
                   fillroom(rooms, i+1, j, 0, visited);
               } 
            }
        }
    }

    void fillroom(int[][] rooms, int i, int j, int dist, boolean[][] visited) {

        int m = rooms.length;
        int n = rooms[0].length;
        // here i,j is neighbor
        if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] <= 0 || visited[i][j]) {
            return;
        }

        rooms[i][j] = Math.min(rooms[i][j], dist + 1);
        visited[i][j] = true;

        fillroom(rooms, i, j - 1, dist + 1, visited);
        fillroom(rooms, i, j + 1, dist + 1, visited);
        fillroom(rooms, i - 1, j, dist + 1, visited);
        fillroom(rooms, i + 1, j, dist + 1, visited);

        visited[i][j] = false;
    }

}
