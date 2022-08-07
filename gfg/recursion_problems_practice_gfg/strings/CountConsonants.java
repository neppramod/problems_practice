import java.util.*;

public class CountConsonants {
    public static void main(String[] args) {
	    CountConsonants sol = new CountConsonants();
        String s = "geeksforgeeks portal";
        sol.countConsonants(s);
	}

    private void countConsonants(String s) {
        System.out.println(countConsonants(s, 0));
    }

    private int countConsonants(String s, int i) {
        if (i >= s.length()) {
            return 0;
        } else if (isConsonant(s.charAt(i))) {
            return 1 + countConsonants(s, i + 1);
        } else {
            return 0 + countConsonants(s, i + 1);
        }
    }

    private boolean isConsonant(char c) {
        char c1 = Character.toUpperCase(c);
        return c1 >= 'A' && c1 <= 'Z' && !isAlphabet(c1);
    }

    private boolean isAlphabet(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }    
}
