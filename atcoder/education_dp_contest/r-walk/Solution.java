import java.util.*;

public class Solution
{
    static final long MOD = 1000000007L;

    static class Node
    {
        long[][] ar = new long[50][50];

        public Node()
        {
            for (int i = 0; i < 50; i++) {
                Arrays.fill(ar[i], 0);
            }
        }
    }

    static Node multiply(Node a, Node b, long N)
    {
        Node answer = new Node();

        // Floyd
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer.ar[i][j] = (answer.ar[i][j] + (a.ar[i][k] * b.ar[k][j]) % MOD) % MOD;
                }
            }
        }

        return answer;
    }

    static Node power(Node a, long b, long N)
    {

        Node answer = new Node();
        for (int i = 0; i < N; i++) {
            answer.ar[i][i] = 1;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                answer = multiply(answer, a, N);

            }

            a = multiply(a, a, N);
            b >>= 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long k = sc.nextLong();

        Node e = new Node();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                e.ar[i][j] = sc.nextLong();
            }
        }

        e = power(e, k, N);
        long answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = ((answer + e.ar[i][j])) % MOD;
            }
        }

            System.out.println(answer);


    }
}
