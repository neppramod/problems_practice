import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;

        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        
        if (A.length < 1)
            return;
        
        int gd = 0;
        if (A.length > 1)
            gd = gcd(A[0], A[1]);
        for (int i = 1; i < A.length-1; i++) {
            gd = gcd(A[i], gd);
        }

        int answer = 0;
        if (gd <= k && gd > 0) {
            for (int i = k; i >= 0; i--) {
                if (i % gd == 0) {
                    answer = i;
                    break;
                }
            }
        }
        
        System.out.println(answer);
    }
}

