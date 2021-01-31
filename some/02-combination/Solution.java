import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] ch = {'a', 'b', 'c'};
        combination(ch);
    }

    static void combination(char[] ch)
    {
        int n = ch.length;
        int M = (int)Math.pow(2, n);
        for (int i = 0; i < M; i++) {

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    System.out.print(ch[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
