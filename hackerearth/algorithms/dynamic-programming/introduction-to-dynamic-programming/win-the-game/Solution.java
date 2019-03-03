import java.util.*;

public class Solution
{
    static double[] arr = new double[1001];
    public static void main(String[] arg)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < 1001; i++)
            arr[i] = 0;

        while (T-- > 0) {
            int R = sc.nextInt();
            int G = sc.nextInt();

            printSatyamProb(R, G);
        }
    }

    private static void printSatyamProb(int R, int G)
    {
        double value;
        if (R == 0) value = 1.0;
        else value = getProbability(R, G);
        System.out.printf("%.6f\n", value);
    }

    private static double getProbability(double R, double G)
    {
    	int g = (int)G;
    	if (arr[g] != 0) return arr[g];
        double T = R + G;


    	if (g > 2) {
            arr[g] = R/T + (G/T) * ((G-1) / (T-1)) * getProbability(R, G-2);
        } else {
            arr[g] = R/T;
        }

        return arr[g];
    }
}
