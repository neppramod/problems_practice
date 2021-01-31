import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = "ADOBECODEBANC", T = "ABC";
        String output = minWindow(S, T);
        System.out.println(output);
    }

    public static String minWindow(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> allElementSet = new HashSet<>();
        HashSet<Character> foundSet = new HashSet<>();

        for (char c : ts) {
            allElementSet.add(c);
        }

        int curMin = Integer.MAX_VALUE;
        String val = "";

        for (int i = 0; i < cs.length; i++) {
            if (allElementSet.contains(cs[i])) {
                map.put(cs[i], i);
                if (!foundSet.contains(cs[i])) {
                    foundSet.add(cs[i]);
                }

                if (foundSet.size() == ts.length) {
                    int min = getMin(map);
                    int max = getMax(map);

                    int diff = max-min;
                    if (diff < curMin) {
                        curMin = diff;
                        val = s.substring(min, max + 1);
                    }
                }
            }
        }

        return val;


    }

    static int getMin(HashMap<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (int k : map.keySet()) {
            if (min > map.get(k)) {
                min = map.get(k);
            }
        }

        return min;
    }

    static int getMax(HashMap<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int k : map.keySet()) {
            if (max < map.get(k)) {
                max = map.get(k);
            }
        }

        return max;
    }


    /* Add to hashmap, initialize each value to null
       When a non-number is found from ts, put it in a set, when set count is size of cs, compare indices of min and max, and set this value to new difference, and extract the string. If this improves, change it

     */

}
