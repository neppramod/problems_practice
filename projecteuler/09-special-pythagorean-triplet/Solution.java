import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = multiple(1000);
        System.out.println(m);
    }

    static int multiple(int n) {
        //int limit = Math.sqrt(n);
        //limit = limit + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int cur = 1000 - (i + j);
                int mul = i * i + j * j;
                if (mul == (cur * cur)) {
                    System.out.println(cur + " * " + i + " * " + j);
                    return (cur * i * j);
                }
            }
        }
        return 0;
    }
}
