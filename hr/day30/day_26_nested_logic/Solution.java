import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int da = sc.nextInt();
        int ma = sc.nextInt();
        int ya = sc.nextInt();
        int de = sc.nextInt();
        int me = sc.nextInt();
        int ye = sc.nextInt();
        
                
        if (ya == ye) {
            if (ma == me) {
                if (da < de) {
                    System.out.println(0);
                } else {
                    System.out.println(15 * (da-de));
                }
            } else {
                System.out.println(500 * (ma-me));
            }
            
        } else {
            System.out.println(10000);   
        }      
        
        
    }
}
