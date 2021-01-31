import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String J ="aA";
        String S = "aAAbbbb";

        int result = numJewelsInStones(J, S);
        System.out.println(result);
    }


    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int result = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }

        return result;
    }
}
