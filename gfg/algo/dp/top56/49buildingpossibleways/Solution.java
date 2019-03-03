import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 5; i++) {

            int result = countWays(i);
            System.out.println(result);
        }
    }

    static int countWays(int input)
    {
        int prevB, prevS, curS, curB;

        if (input == 0) return 0;
        if (input == 1) return 4;

        curS = 1; curB = 1;

        for (int i = 2; i <= input; i++) {
            prevB = curB;
            prevS = curS;

            curS = prevB + prevS;
            curB = prevS;

        }

        int result = curB + curS;
        return result * result;
    }

}
