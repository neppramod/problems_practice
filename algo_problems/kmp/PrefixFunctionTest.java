import java.util.Scanner;

public class PrefixFunctionTest
{
    public static int[] comptePrefixFunction(String input)
    {
        int m = input.length();
        char [] P = new char[m + 1];

        // Copy characters by adjusting index
        for (int i = 0; i < m; i++) {
            P[i + 1] = input.charAt(i);
        }

        int[] PI = new int[m + 1];
        PI[1] = 0;
        int k = 0;
        for (int q = 2; q < m; q++) {
            while (k > 0 && (P[k + 1] != P[q])) {
                k = PI[k];
            }

            if (P[k + 1] == P[q])
                k = k + 1;
            PI[q] = k;
        }

        return PI;
    }

    private static void printPI(int[] PI)
    {
        System.out.print("Pi -> ");
        for (int i = 1; i < PI.length; i++) {
            System.out.print(PI[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args)
    {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Input String: ");
        String stringInput = sc.next();
        String P = stringInput;
        int[] PI = comptePrefixFunction(P);
        printPI(PI);
        */


        String[] inputStrings = new String[] {"aaaaaabaaaaaaabaab",
                "aaaaaaab", "aaabaaaaabaaabaaaaabaaaaba"};

        for (int i = 0; i < inputStrings.length; i++) {
            System.out.println("Case " + (i + 1) + ": " + inputStrings[i]);
            printPI(comptePrefixFunction(inputStrings[i]));
        }

    }
}
