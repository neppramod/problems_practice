import java.util.*;

public class Solution
{

    static final int INF = 99999;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        int[][] graph = new int[][]{
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        int[][] dist = new int[graph.length][graph[0].length];

        // initialize dist as graph
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        //pA2(dist);

        // After all pair
        //System.out.println("All pair");
        allPairShortestPath(dist);
    }

    static void allPairShortestPath(int[][] dist) {
        int V = dist.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        pA2(dist);
    }

    static int solve(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];

        return dp[n];
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%7d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
