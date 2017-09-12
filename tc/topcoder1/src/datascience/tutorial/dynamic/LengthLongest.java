import java.util.*;

public class LengthLongest
{
    public static int lengthLongest(int[] A)
    {
        int N = A.length;
        int[] S = new int[N];
        Arrays.fill(S, 1);  // only counting current item

        for (int i = 1; i < N; i++) {
            if (A[i-1] <= A[i] && S[i - 1] + 1 > S[i])
                S[i] = S[i - 1] + 1;
            else
                S[i] = S[i - 1];

            System.out.printf("%d ", S[i]);
        }

        return S[N-1];
    }

    public static void main(String[] args)
    {
        int[] A = {5, 3, 4, 8, 6, 7};
        System.out.println(lengthLongest(A));
    }
}
