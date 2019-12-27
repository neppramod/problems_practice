import java.util.*;

public class Solution
{
    static int MAXN = (int)(2 * Math.pow(10, 5) + 10);
    static long MOD = (long)(Math.pow(10, 9) + 7);
    static int MAXS = 5000;
    static long[] factorial = new long[MAXN];
    static long[] invfactorial = new long[MAXN];

    static class Pair implements Comparable<Pair>
    {
        int x, y;

        public Pair(int x1, int y1) {
            x = x1;
            y = y1;
        }

        public int compareTo(Pair p1) {
            if (x - p1.x != 0) {
                return x - p1.x;
            } else {
                return y - p1.y;
            }
        }
    }

    static long expo(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b % 2 == 1) {
            return (a * expo(a, b-1)) % MOD;
        } else {
            long result = expo(a, b/2);
            return (result * result) % MOD;
        }
    }

    static void calcFactorial() {
        factorial[0] = invfactorial[0] = 1;
        for (int i = 1; i < MAXN; i++) {
            factorial[i] = (factorial[i-1] * i) % MOD;
            invfactorial[i] = expo(factorial[i], MOD - 2) % MOD;
        }
    }

    static long binomial(int n, int k) {
        return ((factorial[n] * invfactorial[k] % MOD) * invfactorial[n-k]) % MOD;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        calcFactorial();

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();

        Pair[] S = new Pair[N+1];
        S[0] = new Pair(H, W);

        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            S[i] = new Pair(x, y);
        }

        Arrays.sort(S);
        long[] ans = new long[MAXS];

        for (int i = 0; i <= N; i++) {
            ans[i] = binomial(S[i].x + S[i].y - 2, S[i].x-1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int x = S[j].x - S[i].x;
                int y = S[j].y - S[i].y;

                if (x < 0 || y < 0)
                    continue;

                ans[j] -= ans[i] * binomial(x + y, y);
                ans[j] %= MOD;
            }
        }

        if (ans[N] < 0) ans[N] += MOD;
        System.out.println(ans[N]);
    }




}
