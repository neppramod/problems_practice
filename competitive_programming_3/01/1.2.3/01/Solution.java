/* Using Java, read in a double (e.g. 1.4732, 15.324547327, etc.) echo it, but with a minimum field width of 7 and 3 digits after the decimal point (e.g. ss1.473 (where 's' denotes a space). s15.325, etc.) */

/*
 - Read double in scanner
 - %f.p is right justified
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double readVal = sc.nextDouble();
        System.out.printf("'%7.3f'\n", readVal);
    }
}
