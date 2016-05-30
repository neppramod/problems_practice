import java.util.ArrayList;
import java.util.Scanner;

public class PrefixPiFunctionTestPatternPrint
{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void kmpMatcher(String text, String pattern)
    {
        char[] T = text.toCharArray();
        char[] P = pattern.toCharArray();

        int n = T.length;
        int m = P.length;
        int[] PI = comptePrefixFunction(pattern);
        int q = 0;
        ArrayList<Integer> foundIndices = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            while (q > 0 && P[q] != T[i - 1])
                q = PI[q];
            if (P[q] == T[i - 1])
                q = q + 1;
            if (q == m) {
                foundIndices.add(i-m);
                System.out.println("Pattern found starting at shift " + ANSI_BLUE + (i - m) + ANSI_WHITE + ".");
                q = PI[q];
            }
        }

        printPattern(text, pattern, foundIndices);
    }

    private static void printPattern(String text, String pattern, ArrayList<Integer> foundIndices)
    {
        int colorIndices[] = new int[text.length()];

        for (Integer index : foundIndices) {
            for (int i = index; i < index + pattern.length(); i++) {
                colorIndices[i] = 1;
            }
        }

        for (int i = 0; i < text.length(); i++) {
            if (colorIndices[i] == 1)
                System.out.print(ANSI_BLUE + text.charAt(i) + ANSI_WHITE);
            else
                System.out.print(text.charAt(i));
        }
        System.out.println();
    }

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

    private static void prefixMatchWithUserInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Text: ");
        String text = sc.nextLine();
        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        kmpMatcher(text, pattern);
    }

    private static void prefixMatchWithSampleInput()
    {
        String[] texts = new String[] {"aaaa", "a", "aa", "aaabaaaaabaaabaaaaabaaaaba"};
        String[] patterns = new String[] {"a", "a", "a", "aaaba"};

        for (int i = 0; i < texts.length; i++) {
            System.out.println("Text: " + texts[i] + ", Pattern: " + patterns[i]);
            kmpMatcher(texts[i], patterns[i]);
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        prefixMatchWithSampleInput();
        prefixMatchWithUserInput();
    }
}
