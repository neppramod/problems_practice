import java.util.*;

/*
Print all increasing sequences of length k from first n natural numbers

Given two positive integers n and k, print all increasing sequences of length k such that the elements in every sequence are from the first n natural numbers.

Input: k = 2, n = 3
Output: 1 2
        1 3
        2 3


        This is exactly same as Print all possible combinations of r elements in a given array of size n

        There values were given as array, here we just need to generate it
        number starts from 1 to n (inclusive) and we need to generate k values
 */

public class PrintIncreasingSequences {
    public static void main(String[] args) {
	    PrintIncreasingSequences sol = new PrintIncreasingSequences();
        int n = 7;
        int k = 3;
        sol.printIncreasingSequences(n, k);
	}

    public void printIncreasingSequences(int n, int k) {
        List<Integer> tmp = new ArrayList<>();

        printIncreasingSequences(k, 1, n, tmp);
    }

    private void printIncreasingSequences(int k, int start, int end, List<Integer> tmp) {
        if (tmp.size() == k) {
            System.out.println(tmp);
        } else {
            for (int i = start; i <= end; i++) {
                if (tmp.size() < k) {
                    tmp.add(i);
                    printIncreasingSequences(k, i + 1, end, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
	
    
}
