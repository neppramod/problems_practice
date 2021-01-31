import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int numo = 1;
		int deno = 5;

		String result = sol.fractionToDecimal(numo, deno);
		System.out.println(result);
	}
	
    public String fractionToDecimal(int numerator, int denominator) {
		long num = numerator;
		long deno = denominator;

		boolean negative = (double) num / deno < 0 ? true : false;

		num = Math.abs(num);
		deno = Math.abs(deno);

		String res = negative ? "-" + num / deno : num / deno + "";

		if (num % deno == 0) {
			return res;
		}

		String decimal = "";
		num = (num % deno) * 10;

		Map<Long, Integer> mods = new HashMap<>();

		int index = 0;
		while (!mods.containsKey(num) && num != 0) {
			mods.put(num, index++);
			decimal += num / deno;
			num = (num % deno) * 10;
		}

		if (num == 0) {
			return res + "." + decimal;
		}

		int i = mods.get(num);

		res += "." + decimal.substring(0, i) + "(" + decimal.substring(i) + ")";
		return res;
	}
}
