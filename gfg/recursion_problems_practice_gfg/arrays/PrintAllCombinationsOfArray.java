import java.util.*;

/*

  Print all possible combinations of r elements in a given array of size n

  Same technique as before start, end
  Make sure size does not exceed k

 */

public class PrintAllCombinationsOfArray {
    public static void main(String[] args) {
	    PrintAllCombinationsOfArray sol = new PrintAllCombinationsOfArray();
        int[] arr = { 1, 2, 3, 4, 5};
        sol.printCombination(arr, 3);
	}
	
    public void printCombination(int[] arr, int k) {
        List<Integer> tmp = new ArrayList<>();
        printCombination(arr, tmp, k, 0, arr.length);
    }

    private void printCombination(int[] arr, List<Integer> tmp, int k, int start, int end) {
        if (tmp.size() == k) {
            System.out.println(tmp);
        } else {
            for (int i = start; i < end; i++) {
                if (tmp.size() < k) {
                    tmp.add(arr[i]);
                    printCombination(arr, tmp, k, i+1, end);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
