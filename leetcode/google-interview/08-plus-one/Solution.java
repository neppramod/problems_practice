import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {9, 9, 8, 9};
		int[] res = sol.plusOne(arr);
		System.out.println(Arrays.toString(res));
    }
    
    public int[] plusOne(int[] digits) {
		int carry = 1;
		int n = digits.length;
		for (int i = n-1; i >= 0; i--) {
			digits[i] += carry;
			carry = digits[i]/10;
			digits[i] = digits[i] % 10;
		}

		if (carry > 0) {
			int[] newDigits = new int[n+1];
			for (int i = n; i > 0; i--) {
				newDigits[i] = digits[i-1];
			}
			newDigits[0] = 1;
			return newDigits;
		} else {
			return digits;
		}
    }
}
