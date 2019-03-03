import java.util.*;

public class Solution
{

    private static void printMissing(int[] arr, int low, int high) {
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		for (int i = low; i <= high; i++) {
			if (!set.contains(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 3, 5, 4};
        int low = 1, high = 10;
        printMissing(arr, low, high);

    }
}
