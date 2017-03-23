/* Given an integer n (n <= 15), print PI to n digits after the decimal point (rounded). E.g. for n = 2, print 3.14; for n = 4, print 3.1416, for n = 5, print 3.14159 */

/*
Math.PI
String format = String.format("%%.%df", n);
 */

import java.math.*;

public class Solution {
    public static void printPI(int n) {
        String format = String.format("%%.%df",n);
        System.out.printf(format + "\n", Math.PI);
    }

    public static void main(String[] args) {
        printPI(2);
        printPI(4);
        printPI(5);
    }
}
