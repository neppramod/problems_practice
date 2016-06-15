import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int largestsum(int[][] arr)
    {
        if (arr == null || arr.length == 0)
            return 0;
          
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                int sum = 0;

                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <= j+1; l++) {
                        if (k == i) {
                            if (l == j-1 || l == j+1) {
                                continue;
                            }
                        }

                        sum += arr[k][l];
                    }
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        System.out.println(largestsum(arr));
    }
}


