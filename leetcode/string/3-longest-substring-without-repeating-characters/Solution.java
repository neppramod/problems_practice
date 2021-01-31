import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = " ";

        int result = lengthOfLongestSubstring(s);

        System.out.println(result);

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int maxlen = 0;
        char[] sc = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(sc[i]);
            int len = 1;
            for (int j = i + 1; j < n; j++) {
                if (set.contains(sc[j])) {
                    break;
                } else {
                    set.add(sc[j]);
                    len++;
                }
            }
            maxlen = Math.max(maxlen, len);
        }

        return maxlen;
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
