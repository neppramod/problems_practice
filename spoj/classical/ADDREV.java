import java.util.*;
public class ADDREV
{
    static int reverse(int i)
    {
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.println(reverse(reverse(n1) + reverse(n2)));
        }
    }
}
