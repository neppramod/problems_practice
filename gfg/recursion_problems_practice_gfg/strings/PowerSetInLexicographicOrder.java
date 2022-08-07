import java.util.*;

public class PowerSetInLexicographicOrder {
    public static void main(String[] args) {
	    PowerSetInLexicographicOrder sol = new PowerSetInLexicographicOrder();
        String s = "abc";
        sol.printPowerSetInLexicographicalOrder(s);
	}
	
    public void printPowerSetInLexicographicalOrder(String s) {
        printPowerSet(s, "", 0, s.length());
        System.out.println();
    }

    private void printPowerSet(String s, String sub, int start, int end) {
        if (start > end) {  // only start > end return
            return;
        } else {
            System.out.print(sub + " ");
            for (int i = start; i < end; i++) {
                printPowerSet(s, sub + s.charAt(i), i + 1, end);
            }
        }
    }
}
