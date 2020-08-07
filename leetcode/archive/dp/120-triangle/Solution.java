import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(triangle);

        System.out.println(result);

    }

    static int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M-1).size();

        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int res = Integer.MAX_VALUE;
                res = Math.min(res, dp[i-1][j]);
                if (j-1 >= 0) {
                    res = Math.min(res, dp[i-1][j-1]);
                }
                dp[i][j] += res;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            result = Math.min(dp[M-1][j], result);
        }

        //pA2(dp);
        return result;
    }

    static void pA1(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
