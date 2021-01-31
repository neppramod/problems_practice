import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int start = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }

            while (map.keySet().size() > k) {
                char prevChar = s.charAt(start);
                int count = map.get(prevChar);

                if (count == 1) {
                    map.remove(prevChar);
                } else {
                    map.put(prevChar, count-1);
                }
                start++;
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    /*

    Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

        i = 0, c = 'e'
        map = [e:1]

        max = max(max, 0 - 0 + 1) = 1

        1 = 1, c = 'c'
        map = [c:1, e:1]
        max = max(1, 1 - 0 + 1) = 2

        i = 2, c = 'e'
        map = [c:1, e:2]
        max = max(2, 2 - 0 + 1) = 3

        i = 3, c = 'b'
        map = [c:1, e:2, b:1]
            prevChar = 'e', count = 1, map[c:1, e:1, b:1], start = 1
            prevChar = 'c', count = 1, map[e:1, b:1], start = 2
        max = (3, 3 - 2 + 1) = 3

        i = 4, c = 'a'
        map = [e:1, b:1, a:1]
            prevChar = e, count = 1, map[b:1, a:1], start = 3, max = max(3, 4-3+1) = 3
     */


}