import java.util.*;

/**
   Generate all binary strings without consecutive 1’s
   Given an integer K. Task is Print All binary string of size K (Given number).

Examples: 

Input : K = 3  
Output : 000 , 001 , 010 , 100 , 101 

Input : K  = 4 
Output :0000 0001 0010 0100 0101 1000 1001 1010

With previous techniques this should be pretty easy

Generate strings using {'0', '1'} set, but while adding next character, for only 1 make sure previous character is not 1
When size is k, print it

 */
public class GenerateAllBinaryStringsWithoutConsecutive1s {
    public static void main(String[] args) {
	    GenerateAllBinaryStringsWithoutConsecutive1s sol = new GenerateAllBinaryStringsWithoutConsecutive1s();
        int k = 4;
        sol.printBinaryStringsWithoutConsecutive1s(k);
	}
	
    public void printBinaryStringsWithoutConsecutive1s(int k) {
        printBinaryStringsWithoutConsecutive1s("", k);
    }

    char[] set = { '0', '1' };

    private void printBinaryStringsWithoutConsecutive1s(String s, int k) {
        if (s.length() == k) {
            System.out.println(s);
        } else {
            for (char c : set) {
                if (c == '1') {
                    if (!isLastChar1(s)) {
                        printBinaryStringsWithoutConsecutive1s(s + c, k);
                    }
                } else {
                    printBinaryStringsWithoutConsecutive1s(s + c, k);
                }
            }
        }
    }

    private boolean isLastChar1(String s) {
        if (s.length() == 0) {
            return false;
        } else {
            return s.charAt(s.length()-1) == '1';
        }
    }
}
