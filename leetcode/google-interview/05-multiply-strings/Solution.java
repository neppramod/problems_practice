import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		String s1 = "23";
		String s2 = "2";
		Solution sol = new Solution();
		System.out.println(sol.multiply(s1, s2));
    }
    
    public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return "";
		}

		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[n1.length() + n2.length()];

		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int mod = d[i] % 10;
			sb.insert(0, mod);
			int carry = d[i] / 10;
			if (i < d.length-1) {
				d[i+1] += carry;
			}
		}

		while (sb.charAt(0) == '0' && sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
    }

	/*
num1 = "123"
num2 = "456"

num1 = "321"
num2 = "654"

int[] d = new int[6];



s = 456919368
	*/
}
