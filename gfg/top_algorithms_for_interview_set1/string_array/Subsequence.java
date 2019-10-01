/*
  https://www.geeksforgeeks.org/print-subsequences-string/
*/

public class Subsequence
{
    static int counter = 0;

    static void printSubSeqRec(String str, int n, int index, String curr)
    {
        if (index == n) {
            return;
        }

        //System.out.println(curr);
        counter++;

        for (int i = index + 1; i < n; i++) {
            curr = curr + str.charAt(i);
            printSubSeqRec(str, n, i, curr);

            // backtrack
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public static void main(String[] args)
    {
        String onezeros = "0000001111011011110000";
        printSubSeqRec(onezeros, onezeros.length(), -1, "");
        System.out.println("Counter: " + counter);
    }
}
