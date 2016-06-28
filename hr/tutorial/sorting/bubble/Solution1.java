import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
		int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
			int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                    numberOfSwaps++;
                }
            }
			
			if (numberOfSwaps == 0)
				break;

			totalSwaps += numberOfSwaps;

			numberOfSwaps = 0;
        }
        
        System.out.printf("Array is sorted in %d swaps.\n", totalSwaps);
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    static void swap(int[] A, int i, int j)
	{
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}

