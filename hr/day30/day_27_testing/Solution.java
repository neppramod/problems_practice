import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
5
4 3
-1 0 4 2
6 1
-2 -4 -5 0 3 4
5 3
0 -1 5 6 7
3 2
-9 0 10
7 6
-9 -8 -7 0 9 10 11

*/

public class Solution
{

    static void printinput()
    {
        System.out.println("5");
        System.out.println("4 3");
        System.out.println("-1 0 4 2"); // yes
        System.out.println("6 1");
        System.out.println("-2 -4 -5 0 3 4"); // no
        System.out.println("5 3");
        System.out.println("0 -1 5 6 7"); // yes
        System.out.println("3 2");
        System.out.println("-9 0 10"); // no
        System.out.println("7 6");
        System.out.println("-9 -8 -7 0 9 10 11"); // yes
    }

    public static void main(String[] args)
    {   
       
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Boolean> answers = new ArrayList<>();
        
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();                                    
            int K = sc.nextInt();
            int[] arr = new int[N];           
            
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            
            answers.add(isCancelled(arr, K));
        }
        
        for (boolean cancelled : answers) {
            System.out.println(cancelled ? "YES" : "NO");
        }
    }
    
    private static boolean isCancelled(int[] inputs, int K)
    {
        int sum = 0;
        
        for (int num : inputs) {
            if (num <= 0) {
                sum++;
            }
        }
        
        return (sum < K);
    }
   
}

