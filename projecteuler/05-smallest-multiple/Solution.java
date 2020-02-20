import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 20; i >= 3; i--) {
            Map<Integer, Integer> primes = primeFactors(i);
            for (int k : primes.keySet()) {
                if (!map.containsKey(k)) {
                    map.put(k, primes.get(k));
                } else {
                    int cur = map.get(k);
                    int newVal = primes.get(k);
                    if (newVal > cur) {
                        map.put(k, newVal);
                    }
                }
            }
        }

        System.out.println(map);
        long ans = multiply(map);
        System.out.println(ans);
    }

    static long multiply(Map<Integer, Integer> map) {
        long ans = 1;
        for (int k : map.keySet()) {
            ans *= Math.pow(k, map.get(k));
        }
        return ans;
    }


    static HashMap<Integer, Integer> primeFactors(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (num % 2 == 0) {
            if (!map.containsKey(2)) {
                map.put(2, 1);
            } else {
                map.put(2, map.get(2) + 1);
            }
            num /= 2;
        }

        for (int i = 3; i <= num; i++) {
            while (num % i == 0) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                } else {
                    map.put(i, map.get(i) + 1);
                }
                num/=i;
            }
        }

        return map;
    }
}
