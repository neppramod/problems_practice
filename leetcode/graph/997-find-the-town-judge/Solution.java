import java.util.*;

/*
  DFS, search all nodes and return the node that satisfied the condition,
otherwise -1
*/
public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] arr = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int N = 4;

        int result = new Solution().solve(N, arr);

        System.out.println(result);

    }

    int solve(int N, int[][] trust) {
        int[] score = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            int v1 = trust[i][0];
            int v2 = trust[i][1];
            score[v1] = score[v1] - 1;
            score[v2] = score[v2] + 1;
        }

        for (int i = 1; i <= N; i++) {
            if (score[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}
