import java.util.*;

public class StringWithAdditiveSequence {
    public static void main(String[] args) {
	StringWithAdditiveSequence sol = new StringWithAdditiveSequence();
	String s = "12345678";
    sol.isStringWithAdditiveSequence(s);
    }
    
    public void isStringWithAdditiveSequence(String s) {
        List<Integer> tmp = new ArrayList<>();
        printIsStringWithAdditiveSequence(s, tmp, 0, s.length());
    }

    private boolean isAdditiveSequence(int n1, int n2, int n3) {
        return n1 + n2 == n3;
    }

    private void printIsStringWithAdditiveSequence(String s, List<Integer> tmp, int start, int end) {
        if (start >= end) {
            int n = tmp.size();
            if (n >= 3) {
                System.out.println("True");
            }
        } else {
            for (int i = start; i < end; i++) {
                int cur = Integer.parseInt(s.substring(start, i + 1));

                if (tmp.size() < 2) {
                    tmp.add(cur);
                    printIsStringWithAdditiveSequence(s, tmp, i + 1, end);
                    tmp.remove(tmp.size() - 1);
                } else {
                    int sz = tmp.size();
                    if (isAdditiveSequence(tmp.get(sz-2), tmp.get(sz-1), cur)) {
                        tmp.add(cur);
                        printIsStringWithAdditiveSequence(s, tmp, i + 1, end);
                        tmp.remove(tmp.size() - 1);
                    }
                }
            }
           
        }
       
    }
}
