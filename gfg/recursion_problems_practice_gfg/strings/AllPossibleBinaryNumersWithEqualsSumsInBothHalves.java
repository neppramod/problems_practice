import java.util.*;

public class AllPossibleBinaryNumersWithEqualsSumsInBothHalves {
    public static void main(String[] args) {
	    AllPossibleBinaryNumersWithEqualsSumsInBothHalves sol = new AllPossibleBinaryNumersWithEqualsSumsInBothHalves();
		int n = 5;
        sol.printEqualSumHalves(n);
	}


    char[] set = { '0', '1' };
    
    public void printEqualSumHalves(int n) {
        printEqualSumHalves("", n);
    }

    private void printEqualSumHalves(String s, int n) {
        if (s.length() == n) {
            if(isEqualHalfSums(s)) {
                System.out.println(s);
            }
        } else {
            for (char c : set) {
                printEqualSumHalves(s + c, n);
            }
        }
    }

    private boolean isEqualHalfSums(String s) {
        int len = s.length();
        int l = getSum(s, 0, len/2-1);
        int r = getSum(s, len - (len/2), len-1);
        return l == r;
    }

    private int getSum(String s, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += s.charAt(i) - '0';
        }

        return sum;
    }
    
}
