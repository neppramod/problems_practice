public class BuildingBridges
{
    static int longestBridge(int[] X)
    {
        int[] L = new int[X.length];
        L[0] = 1;

        for (int j = 1; j < X.length; j++) {
            int max = 0;
            for( int i = 0; i < j; i++) {
                if (X[i] < X[j]) {
                    max = Math.max(max, L[i]);
                }
            }

            L[j] = max + 1;
        }

        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] X = {5, 1, 3, 4, 2, 6};
        System.out.println(longestBridge(X));
    }
}
