import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        String input = "122";
        int result = sol.numDecodings(input);
        System.out.println(result);

    }

    public int numDecodings(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return numDecodings(s, 0, map);
    }

    private int numDecodings(String input, int index, HashMap<Integer, Integer> map) {
        if (index == input.length()) {
            return 1;
        } else if (index > input.length()) {
            return 0;
        } else {

            if (map.containsKey(index)) {
                return map.get(index);
            }

            int sum = 0;

            int single = Integer.valueOf(input.substring(index, index+1));
            if (single > 0 && single <= 9) {
                sum += numDecodings(input, index + 1, map);
            }

            if (index < input.length() - 1) {
                int doubleValue = Integer.valueOf(input.substring(index, index + 2));
                if (doubleValue >= 10 && doubleValue <= 26) {
                    sum += numDecodings(input, index + 2, map);
                }
            }

            map.put(index, sum);
            return sum;
        }
    }

}
