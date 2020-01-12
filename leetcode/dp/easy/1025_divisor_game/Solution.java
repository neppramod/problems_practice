import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(divisorGame(N));
    }

    public static boolean divisorGame(int N) {
        return N % 2 == 0;
    }


}
