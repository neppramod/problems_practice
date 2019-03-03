import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int K = sc.nextInt();


            HashMap<Integer,Integer> map = new HashMap<>();  // store key and count
            for (int i = 0; i < N; i++) {
                int num = arr[i];
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }

            long count = 0;

            for (int i = 1; i <= K/2; i++) {
                if (map.containsKey(i) && map.containsKey(K-i)) {
                    if (i == K-i) {
                        count += (map.get(i) * (map.get(i) - 1))/2;
                    } else {
                        count += map.get(i) * map.get(K-i);
                    }
                }
            }

            System.out.println(count);
        }
    }
}
