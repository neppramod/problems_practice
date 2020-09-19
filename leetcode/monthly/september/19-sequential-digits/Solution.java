import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int low = 100;
		int high = 300;

		List<Integer> result = sol.sequentialDigits(low, high);
		System.out.println(result);
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new ArrayList<>();

		int lowestNumberOfDigits = getDigits(low);
		int highestNumberOfDigits = getDigits(high);
		String digits = "123456789";

		for (int i = lowestNumberOfDigits; i <= highestNumberOfDigits; i++) {
			for (int j = 0; j < 10 - i; j++) {
				int num = Integer.valueOf(digits.substring(j, j + i));
				if (num >= low && num <= high) {
					result.add(num);
				}
			}
		}

		return result;
    }

	int getDigits(int num) {
		int digits = 0;
		while (num != 0) {
			digits++;
			num /= 10;
		}
		return digits;
	}


}
