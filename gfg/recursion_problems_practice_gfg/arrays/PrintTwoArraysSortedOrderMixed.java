import java.util.*;
/**
   Generate all possible sorted arrays from alternate elements of two given sorted arrays

   Given two sorted arrays A and B, generate all possible arrays such that first element is taken from A then from B then from A and so on in increasing order till the arrays exhausted. The generated arrays should end with an element from B.

   This problem is little tricky than other problems.

   We can pick any one of the element from arr1 as starting element, so we need a way to start for any of these elements. That's why we do tmp.size() == 0 to handle this case. Since we remove that element, that's why at some point we will remove that element, and would have moved i to start + 1 and so on.

   One thing we can be certain is once we pick element from second array, we always set flag back to true. Before picking element from first array, we make sure to print,
   current tmp array.

  Otherwise this is similar algorithm as our start, end combination algorithm. In this case we just need start, end for both arrays, and a flag to switch from one to other. We need the flag to proceed forward, and only add element when the new element is greater than last element in our tmp list.
 */


public class PrintTwoArraysSortedOrderMixed {
    public static void main(String[] args) {
	    PrintTwoArraysSortedOrderMixed sol = new PrintTwoArraysSortedOrderMixed();
        int[] arr1 = {10, 15, 25};
        int[] arr2 = {1, 5, 20, 30};
        sol.printMixed(arr1, arr2);
	}

    public void printMixed(int[] arr1, int[] arr2) {
        List<Integer> tmp = new ArrayList<>();
        printMixed(tmp, arr1, 0, arr1.length, arr2, 0, arr2.length, true);
    }

    private void printMixed(List<Integer> tmp, int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, boolean flag) {
        
        if (flag && tmp.size() > 0) {
            System.out.println(tmp);
        }

        if (flag) {
            for (int i = start1; i < end1; i++) {
                if (tmp.size() == 0) {
                    tmp.add(arr1[i]);
                    printMixed(tmp, arr1, i+1, end1, arr2, start2, end2, !flag);
                    tmp.remove(tmp.size()-1);
                } else {
                    if (arr1[i] >= tmp.get(tmp.size()-1)) {
                        tmp.add(arr1[i]);
                        printMixed(tmp, arr1, i + 1, end1, arr2, start2, end2, !flag);
                        tmp.remove(tmp.size()-1);
                    }
                }
            }
        } else {
            for (int i = start2; i < end2; i++) {
                if(arr2[i] >= tmp.get(tmp.size()-1)) {
                    tmp.add(arr2[i]);
                    printMixed(tmp, arr1, start1, end1, arr2, i + 1, end2, !flag);
                    tmp.remove(tmp.size()-1);
                }
                
            }
        }
    }
}
