import java.util.*;

public class Solution {

    public static void main(String[] args) {


        int result = subtractProductAndSum(4421);
        System.out.println(result);
    }

    public static int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        int mult = 1;
        for (char c : s.toCharArray()) {
            int cur = (c - '0');
            sum += cur;
            mult *= cur;
        }

        return mult - sum;
    }
}
