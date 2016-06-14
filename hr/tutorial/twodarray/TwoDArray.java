import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoDArray {
    
    public static int maxsum(int[][] array)
    { 
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[0].length-1; j++) {
                int cur = hourglasssum(i, j, array);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        
        return max;
    }
    
    private static int hourglasssum(int i, int j, int[][] array)
    {
        int sum = 0;
        
        for (int k = i-1; k <= i+1; k++) {
            for (int l = j-1; l <= j+1; l++) {
                if ((k == i && l == j-1) || (k == i && l == j+1)) {
                    continue;
                } else {
                    sum += array[k][l];
                }
            }
        }
        
        return sum;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        System.out.println(maxsum(arr));
    }
}
