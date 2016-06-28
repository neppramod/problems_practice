import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static boolean isPrime(int n)
    {
		if (n == 1)
			return false;
		if (n == 2)
			return true;

        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
		int m = (int)Math.sqrt(n);
        
        for (int i = 2; i <= n; i++) {            
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) {					
                    prime[j] = false;
                }
            }
        }
        
        return prime[n];
    }
        
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       int[] nums = new int[T];
        
       for (int i = 0; i < T; i++) {
           nums[i] = sc.nextInt();
       }
        
       for (int i = 0; i < nums.length; i++) {
           if (isPrime(nums[i])) {
               System.out.println("Prime");
           } else {
               System.out.println("Not prime");
           }
       }
    }
}

