import java.util.*;

/*
  Given a string, sort it in decreasing order based on the frequency of characters.

  Example 1:

  Input:
  "tree"

  Output:
  "eert"

  Explanation:
  'e' appears twice while 'r' and 't' both appear once.
  So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
  Example 2:

  Input:
  "cccaaa"

  Output:
  "cccaaa"

  Explanation:
  Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
  Note that "cacaca" is incorrect, as the same characters must be together.
  Example 3:

  Input:
  "Aabb"

  Output:
  "bbAa"

  Explanation:
  "bbaA" is also a valid answer, but "Aabb" is incorrect.
  Note that 'A' and 'a' are treated as two different characters.
 */

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = "Aabb";
        String result = frequencySort(s);
        System.out.println(result);


    }

    static class C implements Comparable<C>
    {
        char c;
        int f;

        public C(char c1, int f1) {
            c = c1;
            f = f1;
        }

        public int compareTo(C cc) {
            return cc.f - f;
        }
    }

    public static String frequencySort(String s) {
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : cs) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        PriorityQueue<C> queue = new PriorityQueue<>();
        for ( char c : map.keySet()) {
            queue.add(new C(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            C c = queue.poll();
            for (int i = 0; i < c.f; i++) {
                sb.append(c.c);
            }
        }

        return sb.toString();
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
