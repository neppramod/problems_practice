import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * CombinationInAStrignOfDigits
 */
public class CombinationInAStrignOfDigits {
    public static void main(String[] args) {
        CombinationInAStrignOfDigits sol = new CombinationInAStrignOfDigits();
        String s = "1234";
        sol.printCombinationInAStrings(s);
    }

    public void printCombinationInAStrings(String s) {
        List<String> tmp = new ArrayList<>();
        printCombinationInAStrings(s, 0, s.length(), tmp);
    }

    private void printCombinationInAStrings(String s, int start, int end, List<String> tmp) {
        if (start >= end) {
            for (int i = 0; i < tmp.size()-1; i++) {
                System.out.print(tmp.get(i) + " ");
            }
            System.out.println(tmp.get(tmp.size()-1));
        } else {
            for (int i = start; i < end; i++) {
                tmp.add(s.substring(start, i + 1));
                printCombinationInAStrings(s, i + 1, end, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}