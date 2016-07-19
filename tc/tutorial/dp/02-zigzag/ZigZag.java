public class ZigZag
{
    static int zigzag(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;
        if (A.length == 1)
            return 1;

        int[] L = new int[A.length];
        L[0] = 1;
        if (A[0] != A[1])
            L[1] = 2;
        else
            L[1] = 1;

        for (int i = 2; i < A.length; i++) {
            if ((A[i-2] < A[i-1] && A[i-1] > A[i]) || (A[i-2] > A[i - 1] && A[i - 1] < A[i])) {
                L[i] = L[i-1] + 1;
            } else {
                L[i] = L[i-1];
            }
        }

        return L[A.length-1];
    }

    public static void main(String[] args)
    {
        int[] A = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };

        //          1   2   2,  3, 4,  5, 5,  5,  5,  5,  6,   6,  6, 6, 6, 6, 7, 7  

        System.out.println(zigzag(A));
    }
}
