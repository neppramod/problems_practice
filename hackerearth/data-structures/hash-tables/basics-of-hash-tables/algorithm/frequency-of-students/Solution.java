import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> map = new TreeMap<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String key = sc.next();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
