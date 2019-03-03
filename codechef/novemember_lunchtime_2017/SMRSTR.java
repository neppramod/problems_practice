import java.util.*;

public class SMRSTR
{
    static int[] solve(int[] X, int D)
    {
        int Q = X.length;
        int[] result = new int[Q];

        for (int i = 0; i < Q; i++) {
            result[i] = X[i] / D;
        }

        return result;
    }

    static void printarray(int[] result)
    {
        int N = result.length;
        for (int i = 0; i < N-1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println(result[N-1]);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int D = 1;
            int[] X = new int[Q];

            for (int i = 0; i < N; i++) {
                D *= sc.nextInt();
            }

            for (int i = 0; i < Q; i++) {
                X[i] = sc.nextInt();
            }

            printarray(solve(X, D));
        }
    }
}
