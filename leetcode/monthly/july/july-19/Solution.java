import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		String a = "1010", b = "1011";
		Solution sol = new Solution();
		System.out.println(sol.addBinary(a, b));
    }
    
	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

		int carry = 0;
		int i = a.length() - 1, j = b.length() - 1;
		while (i >= 0 && j >= 0) {
			int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
			int cur = sum % 2;
			sb.append(cur);
			carry = sum/2;
			i--;j--;
		}

		while (i >= 0) {
			int sum = a.charAt(i) - '0' + carry;
			int cur = sum % 2;
			sb.append(cur);
			carry = sum/2;
			i--;
		}

		while (j >= 0) {
			int sum = b.charAt(j) - '0' + carry;
			int cur = sum % 2;
			sb.append(cur);
			carry = sum/2;
			j--;
		}

		if (carry > 0) {
			sb.append(carry);
		}

		sb.reverse();
		return sb.toString();
    }
}
