import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<Long, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long roll = sc.nextLong();
            String name = sc.next();
            map.put(roll, name);
        }

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            long roll = sc.nextLong();
            System.out.println(map.get(roll));
        }
    }
}
