import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N, K;

        N = sc.nextInt();
        K = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        boolean contains = false;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (set.contains(num)) {
                contains = true;
                break;
            } else {
                set.add(K-num);
            }
        }

        if (contains) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
