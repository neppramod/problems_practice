import java.util.*;

public class Solution
{
    static int R = 4;
    static int C = 3;
    static int[] x = {0,-1,0,0,1};
    static int[] y = {0,0,-1,1,0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] keys = {{'1','2','3'},
                         {'4','5','6'},
                         {'7','8','9'},
                         {'*','0','#'}};

        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(dp[i], -1);
        }


        int totalCount = 0;
        /*
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //totalCount += getCount(i,j,N, keys);
                // totalCount += getCountDP(i, j, N, keys, dp);

            }
        }
        */

        totalCount = getCountDP(keys, N);
        System.out.println(totalCount);

    }

    static int getCount(int i,  int j, int N, char[][] keys)
    {
        if (!isvalid(i,j) || !isaccepted(keys[i][j])) return 0;
        if (N == 1) return 1;

        int result = 0;
        for (int k = 0; k < 5; k++) {
            result += getCount(i+x[k], j+y[k], N-1, keys);
        }

        return result;
    }

    static int getCountDP(char[][] keys, int N)
    {
        if (N <= 0) return 0;
        if (N == 1) return 10;

        // taking N+1 for simplicity, count[i][j] will store
        // number of count starting with digit i and length j
        int[][] count = new int[10][N+1];
        int nextNum = 0, totalCount = 0;

        for (int i = 0; i <= 9; i++) {
            count[i][0] = 0;  // 0 length, value 0
            count[i][1] = 1;  // 1 length, value 1
        }

        int cur = 0, next = 0;
        for (int k = 2; k <= N; k++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (isaccepted(keys[i][j])) {
                        cur = keys[i][j] - '0';
                        count[cur][k] = 0;

                        for (int l = 0; l < 5; l++) {
                            int ro = i+x[l], co = j+y[l];
                            if (isvalid(ro,co) && isaccepted(keys[ro][co])) {
                                next =keys[ro][co]-'0';
                                count[cur][k] += count[next][k-1];
                            }
                        }
                    }
                }
            }
        }

        totalCount = 0;
        for (int i = 0; i <= 9; i++) {
            totalCount += count[i][N];
        }

        return totalCount;
    }

    static boolean isvalid(int i, int j)
    {
        if (i < 0 || j < 0 || i >= R || j >= C) return false;
        return true;
    }

    static boolean isaccepted(char c)
    {
        if (c=='*' || c == '#') return false;
        return true;
    }
}
