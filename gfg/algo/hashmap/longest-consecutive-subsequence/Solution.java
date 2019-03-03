import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int arr[] =  {1, 9, 3, 10, 4, 20, 2};
		int[] arr = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
		printLongestConsecutiveSubsequenceLength(arr);

    }

	private static void printLongestConsecutiveSubsequenceLength(int[] arr) {
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int longest = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i]-1)) {
				int j = arr[i];

				while (set.contains(j)) {
					j++;
				}

				longest = Math.max(j-arr[i], longest);
			}
		}

		System.out.println(longest);
	}
}
