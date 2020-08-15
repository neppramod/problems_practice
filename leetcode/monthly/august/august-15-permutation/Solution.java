import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String input = "I";
		int[] result = sol.findPermutation(input);
		System.out.println(Arrays.toString(result));
    }
    
    public int[] findPermutation(String s) {
		if (s == null || s.length() == 0) {
			return new int[] {};
		}

		int n = s.length();
		int[] arr = new int[n+1];
		for (int i = 0; i <= n; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'D') {
				for (int j = i; j >= 0; j--) {
					if (s.charAt(j) != 'D') {
						break;
					}
					swap(arr, j, j + 1);	
				}
				
			}
		}

		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
